package geometryprinter;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
import geometryprinter.item.PolyhedronNet.NetPart;
import java.awt.Color;
import org.lwjgl.input.Keyboard;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuNetDesigner extends Menu{
    private Page page = new Page();
    private MenuComponentEditablePage preview;
    private int sides = 3;
    private int side = 0;
    private PolyhedronNet.NetPart selectedPart = null;
    private PolyhedronNet.NetPart net = null;
    public MenuNetDesigner(GUI gui, Menu parent){
        super(gui, parent);
        preview = add(new MenuComponentEditablePage(page));
    }
    @Override
    public void renderBackground(){}
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange){
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
        if(button==1&&pressed)gui.open(parent);
    }
    @Override
    public void keyboardEvent(char character, int key, boolean pressed, boolean repeat){
        super.keyboardEvent(character, key, pressed, repeat);
        if(pressed){
            if(key==Keyboard.KEY_ADD||key==Keyboard.KEY_EQUALS||key==Keyboard.KEY_PERIOD){
                if(sides<20)sides++;
            }
            if(key==Keyboard.KEY_SUBTRACT||key==Keyboard.KEY_COMMA){
                if(sides>3)sides--;
            }
            if(key==Keyboard.KEY_SPACE||key==Keyboard.KEY_RETURN){
                if(net==null){
                    net = new PolyhedronNet.NetPart(sides%2==0?360d/(sides*2):0, sides, 0, 0, 25);
                    selectedPart = net.addPolygon(side, sides);
                }
                //add polygon
            }
            if(key==Keyboard.KEY_BACK||key==Keyboard.KEY_DELETE){
                if(selectedPart!=null){
                    NetPart parent = selectedPart.getParent();
                    parent.remove(selectedPart);
                    if(parent.getAllParts().size()==1){
                        selectedPart = null;
                    }else{
                        selectedPart = parent;
                    }
                }
            }
            refresh();
        }
    }
    private void refresh(){
        page.removeAll();
        final MenuNetDesigner that = this;
        PolyhedronNet n = new PolyhedronNet() {
            @Override
            protected void buildNet(){
                if(that.net==null){
                    net = new PolyhedronNet.NetPart(sides%2==0?360d/(sides*2):0, sides, 0, 0, 25, new Color(127, 127, 255));
                    return;
                }
                net = that.net;
            }
            @Override
            public String getDisplayName(){
                return "Custom Net";
            }
            @Override
            public boolean isEqual(Item item){
                return item==this;
            }
            @Override
            public String getCategoryName(){
                return "N/A";
            }
            @Override
            public String getItemName(){
                return getDisplayName();
            }
            @Override
            public PageObject replicate(){
                return this;
            }
        };
        n.update();
        page.add(n);
        preview.refresh();
    }
}