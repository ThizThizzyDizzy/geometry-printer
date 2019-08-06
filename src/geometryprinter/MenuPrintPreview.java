package geometryprinter;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
import simplelibrary.opengl.gui.components.MenuComponentButton;
import simplelibrary.opengl.gui.components.MenuComponentList;
public class MenuPrintPreview extends Menu{
    public static ArrayList<Page> pages = new ArrayList<>();
    public MenuComponentButton print;
    public static ArrayList<String> warnings = new ArrayList<>();
    public static ArrayList<String> errors = new ArrayList<>();
    public MenuComponentList list;
    private static boolean errored = false;
    private static boolean warninged = false;
    private static boolean finished = false;
    public MenuPrintPreview(GUI gui, Menu parent){
        super(gui, parent);
        print = add(new MenuComponentButton(Display.getWidth()-400, Display.getHeight()-40, 400, 40, "Print", false, true, "/textures/gui/button"));
        list = add(new MenuComponentList(0, 0, 20, Display.getHeight(), 20, true));
    }
    double yOffset = 0;
    int delay = 100;
    String task = "";
    int completed = 0;
    int total = 0;
    boolean running = true;
    @Override
    public void onGUIOpened(){
        errored = warninged = finished = false;
        warnings.clear();
        errors.clear();
        compilePrintJob();
    }
    @Override
    public void onGUIClosed(){
        running = false;
    }
    @Override
    public void tick(){
        super.tick();
        if(!errors.isEmpty()){
            errored = true;
        }
        if(!warnings.isEmpty()){
            warninged = true;
        }
        if(finished&&delay>0){
            delay--;
        }
        if(delay<=0){
            if(!errors.isEmpty()||!warnings.isEmpty()){
                yOffset-=7;
                if(yOffset<=-20){
                    yOffset+=20;
                    if(!errors.isEmpty()){
                        errors.remove(0);
                    }
                    if(!warnings.isEmpty()){
                        warnings.remove(0);
                    }
                }
            }
        }
    }
    @Override
    public void renderBackground(){
        if(!pages.isEmpty()){
            list.width = pages.get(0).pageWidth+20;
        }
        print.color = errored?Color.red:(warninged?Color.yellow:Color.white);
    }
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange){
        if(button==1&&pressed){
            gui.open(parent);
        }
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
    }
    @Override
    public void render(int millisSinceLastTick){
        if(finished){
            super.render(millisSinceLastTick);
            GL11.glColor4d(.875, .875, .875, 1);
            drawRect(print.x, 0, print.x+print.width, print.y, 0);
        }else{
            GL11.glColor4d(.875, .875, .875, 1);
            drawRect(0, Display.getHeight()/2-80, Display.getWidth()*(completed/(double)total), Display.getHeight()/2+80, 0);
            GL11.glColor4d(0, 0, 0, 1);
            drawCenteredText(0, Display.getHeight()/2-160, Display.getWidth(), Display.getHeight()/2-80, task+"...");
            drawCenteredText(0, Display.getHeight()/2-80, Display.getWidth(), Display.getHeight()/2, completed+"/"+total);
            drawCenteredText(0, Display.getHeight()/2, Display.getWidth(), Display.getHeight()/2+80, Math.round(completed/(double)total*10000)/100d+"%");
        }
        for(int i = 0; i<warnings.size(); i++){
            String warning = warnings.get(i);
            GL11.glColor4d(.5, .5, 0, 1);
            drawText(0, i*20+yOffset, (Display.getWidth()-400)/2, (i+1)*20+yOffset, warning);
        }
        for(int i = 0; i<errors.size(); i++){
            String error = errors.get(i);
            GL11.glColor4d(.5, 0, 0, 1);
            drawText((Display.getWidth()-400)/2, i*20+yOffset, Display.getWidth()-400, (i+1)*20+yOffset, error);
        }
    }
    @Override
    public void buttonClicked(MenuComponentButton button){
        if(button==print){
            new CustomPrinting(pages).printIt();
        }
    }
    private void compilePrintJob(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                ArrayList<PageObject> objs = new ArrayList<>();
                task = "Gathering Items";
                for(Item item : PrintingList.items.keySet()){
                    for(int i = 0; i<PrintingList.items.get(item); i++){
                        PageObject I = item.replicate();
                        I.update();
                        total++;
                        objs.add(I);
                    }
                }
                pages.clear();
                task = "Sorting Items";
                objs.sort(new Comparator<PageObject>(){
                    @Override
                    public int compare(PageObject o1, PageObject o2){
                        return (o2.getWidth()*o2.getHeight())-(o1.getWidth()*o1.getHeight());
                    }
                });
                task = "Arranging Items";
                for(PageObject obj : objs){
                    if(!running)return;
                    try{
                        addItem(obj);
                    }catch(Exception ex){
                        errors.add(ex.getMessage());
                    }
                    completed++;
                }
                task = "Rendering Pages";
                total = pages.size();
                completed = 0;
                for(Page page : pages){
                    if(!running)return;
                    list.add(new MenuComponentPage(page));
                    completed++;
                }
                if(pages.size()>0){
                    print.enabled = true;
                }
                finished = true;
            }
        }).start();
    }
    private static boolean addItem(PageObject item){
        item.update();
        if(item.getWidth()*item.getHeight()==0){
            if(item.canSplit()){
                return addItemSplit(item);
            }else{
                errors.add("Item has 0 area! "+item.getDisplayName());
                return false;
            }
        }
        for(Page page : pages){
            if(page.add(item)){
                return true;
            }
        }
        Page page = new Page();
        if(page.add(item)){
            pages.add(page);
        }else if(item.canSplit()){
            return addItemSplit(item);
        }else{
            errors.add("Cannot fit item: "+item.getDisplayName());
        }
        return false;
    }
    private static boolean addItemSplit(PageObject item){
        if(item.getWidth()*item.getHeight()>0){
            for(Page page : pages){
                if(page.add(item)){
                    return true;
                }
            }
        }
        ArrayList<PageObject> split = new ArrayList<>();
        if(item instanceof ItemFractured){
            warnings.add("Fractured object: "+item.getDisplayName());
        }else{
            warnings.add("Splitting object: "+item.getDisplayName());
        }
        item.split(split);
        boolean ret = true;
        for(PageObject i : split){
            i.update();
            if(ret){
                ret = addItem(i);
            }else{
                addItem(i);
            }
        }
        return ret;
    }
}