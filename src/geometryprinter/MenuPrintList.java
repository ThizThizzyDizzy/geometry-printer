package geometryprinter;
import geometryprinter.item.Item;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
import simplelibrary.opengl.gui.components.MenuComponentButton;
import simplelibraryextended.opengl.Renderer3D;
import simplelibraryextended.opengl.model.Model;
public class MenuPrintList extends Menu{
    public MenuComponentButton preview;
    private double rot;
    private double rotSpeed = 1;
    private Item item;
    private Model model;
    private static boolean metric = false;
    private final PrintingList print;
    public MenuPrintList(GUI gui, Menu parent){
        super(gui, parent);
        print = add(new PrintingList(true));
        preview = add(new MenuComponentButton(print.x, print.y+print.height, print.width, 40, "Print Preview", true, true, "/textures/gui/button"));
    }
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange){
        if(button==1&&pressed){
            gui.open(parent);
        }
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
    }
    @Override
    public void buttonClicked(MenuComponentButton button){
        if(button==preview){
            gui.open(new MenuPrintPreview(gui, this));
        }
    }
    @Override
    public void renderBackground(){
        if(print.selected!=item){
            item = print.selected;
            model = null;
        }
    }
    @Override
    public void render(int millisSinceLastTick){
        super.render(millisSinceLastTick);
        if(model!=null){
            GL11.glColor4d(0, 0, 0, 1);
            drawText(0, 0, Display.getWidth(), 20, "Depth: "+Math.round(model.getDepth()*item.getModelScale()*(metric?2.54:1)*100)/100d+(metric?" cm":" in"));
            drawText(0, 20, Display.getWidth(), 40, "Width: "+Math.round(model.getWidth()*item.getModelScale()*(metric?2.54:1)*100)/100d+(metric?" cm":" in"));
            drawText(0, 40, Display.getWidth(), 60, "Height: "+Math.round(model.getHeight()*item.getModelScale()*(metric?2.54:1)*100)/100d+(metric?" cm":" in"));
            GL11.glColor4d(1, 1, 1, 1);
        }
    }
    public void render3D(int millisSinceLastTick){
        if(item==null)return;
        if(model==null){
            try{
                model = item.getModel();
                if(model!=null)model.calculateDimensions();
            }catch(IOException ex){
                Logger.getLogger(MenuPrintList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        rot+=rotSpeed;
        GL11.glPushMatrix();
        GL11.glTranslated(3, 0, -7);
        if(metric){
            GL11.glRotated(90, 0, 1, 0);
        }else{
            GL11.glRotated(-90, 0, 1, 0);
        }
        Renderer3D.drawModel("ruler");
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslated(-3, -1, -7);
        GL11.glRotated(rot, 0, 1, 0);
        GL11.glScaled(item.getModelScale(), item.getModelScale(), item.getModelScale());
        Renderer3D.drawModel(model);
        GL11.glPopMatrix();
    }
}