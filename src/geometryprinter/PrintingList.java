package geometryprinter;
import java.util.HashMap;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static simplelibrary.opengl.Renderer2D.drawRect;
import simplelibrary.opengl.gui.components.MenuComponentButton;
import simplelibraryextended.opengl.AdvancedRenderer2D;
public class PrintingList extends MenuComponentButton{
    static final HashMap<Item, Integer> items = new HashMap<>();
    private final boolean editable;
    public Item selected;
    public PrintingList(){
        this(false);
    }
    public PrintingList(final boolean editable){
        super(Display.getWidth()-400, 0, 400, Display.getHeight()-(editable?40:0), "", true);
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!editable){
                    gui.open(new MenuPrintList(gui, parent));
                }
            }
        });
        this.editable = editable;
    }
    private HashMap<Rectangle, Item> rects = new HashMap<Rectangle, Item>();
    @Override
    public void render(){
        GL11.glColor4d(.875, .875, .875, 1);
        drawRect(x, y, x+width, y+height, 0);
        yOffset = 5;
        text("Stuff to print:");
        rects.clear();
        selected = null;
        for(Item item : items.keySet()){
            double minY = yOffset;
            if(editable){
                GL11.glColor4d(.75, .75, .75, 1);
                drawRect(Display.getWidth()-395, yOffset, Display.getWidth()-395+textHeight, yOffset+textHeight, 0);
                rects.put(new Rectangle(Display.getWidth()-395-(int)x, (int)(yOffset-y), (int)textHeight, (int)textHeight), item);
                GL11.glColor4d(.9375, .9375, .9375, 1);
                drawRect(Display.getWidth()-394, yOffset+1, Display.getWidth()-396+textHeight, yOffset+textHeight-1, 0);
                GL11.glColor4d(1, 0, 0, 1);
                drawRect(Display.getWidth()-390, yOffset+2*textHeight/5, Display.getWidth()-400+textHeight, yOffset+3*textHeight/5, 0);
            }
            text(items.get(item)+" "+item.getDisplayName());
            double maxY = yOffset;
            if(isClickWithinBounds(Mouse.getX(), Display.getHeight()-Mouse.getY(), Display.getWidth()-400, minY, Display.getWidth(), maxY)){
                selected = item;
            }
        }
        GL11.glColor4d(1, 1, 1, 1);
    }
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange) {
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
        if(pressed&&button==0){
            for(Rectangle rect : rects.keySet()){
                if(x>=rect.x&&y>=rect.y&&x<=rect.x+rect.width&&y<=rect.y+rect.height){
                    int amount = 1;
                    if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
                        amount*=10;
                    }
                    if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
                        amount*=100;
                    }
                    removeItem(rects.get(rect), amount);
                }
            }
        }
    }
    private double textHeight = 20;
    private double yOffset = 5;
    private void text(String text){
        GL11.glColor4d(0, 0, 0, 1);
        text = AdvancedRenderer2D.drawTextWithWordWrap(Display.getWidth()-395+(editable?textHeight:0), yOffset, Display.getWidth()-5, yOffset+textHeight, text);
        yOffset += textHeight+3;
        if(text==null||text.trim().isEmpty())return;
        text(text);
    }
    public static void addItem(Item item, ArrayList<Setting> settings){
        addItem(item, settings, 1);
    }
    public static void addItem(Item item, ArrayList<Setting> settings, int amount){
        item.settings = settings;
        for(Item i : items.keySet()){
            if(i.equals(item)){
                items.put(i, items.get(i)+amount);
                return;
            }
        }
        Item i = (Item) item.replicate();
        ArrayList<Setting> newSettings = new ArrayList<>();
        for(Setting s : settings){
            newSettings.add(s.replicate());
        }
        i.settings = newSettings;
        items.put(i, amount);
    }
    public static void removeItem(Item item){
        removeItem(item, 1);
    }
    public static void removeItem(Item item, int amount){
        for(Item i : items.keySet()){
            if(i.equals(item)){
                if(items.get(i)-amount<=0){
                    items.remove(item);
                    return;
                }
                items.put(i, items.get(i)-amount);
                return;
            }
        }
    }
}