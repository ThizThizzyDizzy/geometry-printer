package geometryprinter;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuOutOfMemory extends Menu{
    public MenuOutOfMemory(GUI gui){
        super(gui, new MenuMain(gui));
    }
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange){
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
        if(button==1)gui.open(parent);
    }
    @Override
    public void renderBackground(){}
    @Override
    public void render(int millisSinceLastTick){
        GL11.glColor4d(0, 0, 0, 1);
        drawCenteredText(0, 0, Display.getWidth(), 100, "OUT OF MEMORY");
        drawCenteredText(0, 300, Display.getWidth(), 350, "Please don't try to print so much at a time.");
        drawCenteredText(0, 500, Display.getWidth(), 530, "Right click to return to main menu.");
    }
}