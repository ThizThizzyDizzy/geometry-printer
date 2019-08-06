package geometryprinter;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import simplelibrary.game.GameHelper;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
import simplelibrary.opengl.gui.components.MenuComponentButton;
import simplelibrary.opengl.gui.components.MenuComponentTextBox;
import simplelibraryextended.opengl.Renderer3D;
import simplelibraryextended.opengl.gui.components.MenuComponentAdvancedList;
import simplelibraryextended.opengl.gui.menu.AdvancedMenu;
import simplelibraryextended.opengl.model.Model;
public class MenuAddItem extends AdvancedMenu{
    public final MenuComponentAdvancedList list;
    protected final PrintingList printlist;
    private final MenuComponentButton add1;
    private final MenuComponentButton add10;
    private final MenuComponentButton add100;
    private final Item item;
    public final ArrayList<Setting> settings = new ArrayList<>();
    private double rot;
    private double rotSpeed = 1;
    private Model model;
    private static boolean metric = false;
    public MenuAddItem(GUI gui, Menu parent, Item item){
        super(gui, parent, Core.is3D?GameHelper.MODE_3D:GameHelper.MODE_2D);
        list = add(new MenuComponentAdvancedList(Display.getWidth()-800, 0, 400, Display.getHeight()-120, 20, true));
        add1 = add(new MenuComponentButton(list.x, list.y+list.height, list.width, 40, "Add 1", true, true, "/textures/gui/button"));
        add10 = add(new MenuComponentButton(list.x, list.y+list.height+40, list.width, 40, "Add 10", true, true, "/textures/gui/button"));
        add100 = add(new MenuComponentButton(list.x, list.y+list.height+80, list.width, 40, "Add 100", true, true, "/textures/gui/button"));
        printlist = add(new PrintingList());
        for(Setting setting : item.getSettings()){
            settings.add(setting);
            list.add(new MenuComponentTextBox(0, 0, list.width-list.vertScrollbarWidth, 40, setting.getName(), false));
            list.add(setting.getSettings(list.width-list.vertScrollbarWidth, 40*setting.getSize()));
        }
        this.item = item;
        try{
            model = item.getModel(settings);
            model.calculateDimensions();
            model.randomizeColors();
        }catch(IOException | NullPointerException ex){
            model = new Model();
        }
    }
    @Override
    public void keyboardEvent(char character, int key, boolean pressed, boolean repeat){
        if(pressed&&!repeat&&key==Keyboard.KEY_R){
            metric = !metric;
        }
        super.keyboardEvent(character, key, pressed, repeat);
    }
    @Override
    public void renderBackground(){}
    @Override
    public void tick(){
        super.tick();
        if(item.changesShape()){
            try {
                model = item.getModel(settings);
                model.calculateDimensions();
            } catch (IOException ex) {
                Logger.getLogger(MenuAddItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for(Setting setting : settings){
            item.set(setting.getName(), setting.getValue());
        }
        testSize();
    }
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange) {
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
        if(button==1&&pressed){
            gui.open(parent);
        }
    }
    @Override
    public void render(int millisSinceLastTick){
        super.render(millisSinceLastTick);
        if(model!=null){
            GL11.glColor4d(0, 0, 0, 1);
            drawText(0, 0, Display.getWidth(), 20, "Depth: "+Math.round(model.getDepth()*item.getModelScale(settings)*(metric?2.54:1)*100)/100d+(metric?" cm":" in"));
            drawText(0, 20, Display.getWidth(), 40, "Width: "+Math.round(model.getWidth()*item.getModelScale(settings)*(metric?2.54:1)*100)/100d+(metric?" cm":" in"));
            drawText(0, 40, Display.getWidth(), 60, "Height: "+Math.round(model.getHeight()*item.getModelScale(settings)*(metric?2.54:1)*100)/100d+(metric?" cm":" in"));
            GL11.glColor4d(1, 1, 1, 1);
        }
    }
    @Override
    public void buttonClicked(MenuComponentButton button){
        if(button==add1){
            PrintingList.addItem(item, settings);
        }
        if(button==add10){
            PrintingList.addItem(item, settings, 10);
        }
        if(button==add100){
            PrintingList.addItem(item, settings, 100);
        }
    }
    public void render3D(int millisSinceLastTick){
        rot+=rotSpeed;
        GL11.glPushMatrix();
        GL11.glTranslated(-2, 0, -7);
        if(metric){
            GL11.glRotated(90, 0, 1, 0);
        }else{
            GL11.glRotated(-90, 0, 1, 0);
        }
        Renderer3D.drawModel("ruler");
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslated(-5, -1, -7);
        GL11.glRotated(rot, 0, 1, 0);
        GL11.glScaled(item.getModelScale(settings), item.getModelScale(settings), item.getModelScale(settings));
        Renderer3D.drawModel(model);
        GL11.glPopMatrix();
    }
    private void testSize(){
        error = warning = null;
        compilePrintJob();
        if(error!=null){
            add1.color = add10.color = add100.color = Color.red;
            return;
        }
        if(warning!=null){
            add1.color = add10.color = add100.color = Color.yellow;
            return;
        }
        add1.color = add10.color = add100.color = Color.white;
    }
    private static String error = null;
    private static String warning = null;
    private void compilePrintJob(){
        try{
            addItem(item.replicate());
        }catch(Exception ex){
            if(error==null)error = ex.getMessage();
        }
    }
    private static Page page;
    private static boolean addItem(PageObject item){
        item.update();
        if(item.getWidth()*item.getHeight()==0){
            if(item.canSplit()){
                return addItemSplit(item);
            }else{
                if(error==null)error = "Item has 0 area! "+item.getDisplayName();
                return false;
            }
        }
        page = new Page();
        if(page.add(item)){
            return true;
        }else if(item.canSplit()){
            return addItemSplit(item);
        }else{
            if(error==null)error = "Cannot fit item: "+item.getDisplayName();
        }
        return false;
    }
    private static boolean addItemSplit(PageObject item){
        if(item.getWidth()*item.getHeight()>0){
            if(page.add(item)){
                return true;
            }
        }
        ArrayList<PageObject> split = new ArrayList<>();
        if(item instanceof ItemFractured){
            if(warning==null)warning = "Fractured object: "+item.getDisplayName();
        }else{
            if(warning==null)warning = "Splitting object: "+item.getDisplayName();
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