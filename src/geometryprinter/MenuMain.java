package geometryprinter;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
import simplelibrary.opengl.gui.components.MenuComponentButton;
import simplelibraryextended.opengl.AdvancedRenderer2D;
public class MenuMain extends Menu{
    private MenuComponentButton start;
    private MenuComponentButton exit;
    private MenuComponentButton credits;
    public MenuMain(GUI gui){
        super(gui, null);
        start = add(new MenuComponentButton(Display.getWidth()/2-600, 250, 800, 120, "Start", true, true, "/textures/gui/button"));
        exit = add(new MenuComponentButton(Display.getWidth()/2-600, 500, 800, 120, "Exit", true, true, "/textures/gui/button"));
        credits = add(new MenuComponentButton(0, Display.getHeight()-40, 200, 40, "Credits", true, true, "/textures/gui/button"));
    }
    @Override
    public void renderBackground(){
        exit.x = start.x = Display.getWidth()/2-600;
        credits.y = Display.getHeight()-40;
    }
    @Override
    public void render(int millisSinceLastTick){
        super.render(millisSinceLastTick);
        GL11.glColor4d(.875, .875, .875, 1);
        drawRect(Display.getWidth()-400, 0, Display.getWidth(), Display.getHeight(), 0);
        GL11.glColor4d(0, 0, 0, 1);
        yOffset = 5;
        text(" News:");
        for(String str : Core.news){
            text(str);
        }
        GL11.glColor4d(1, 1, 1, 1);
    }
    @Override
    public void buttonClicked(MenuComponentButton button){
        if(button==start){
            gui.open(new MenuCategories(gui, this));
        }
        if(button==credits){
            gui.open(new MenuCredits(gui, this));
        }
        if(button==exit){
            Core.helper.running = false;
        }
    }
    private double textHeight = 20;
    private double yOffset = 5;
    private void text(String text){
        text = AdvancedRenderer2D.drawTextWithWordWrap(Display.getWidth()-395, yOffset, Display.getWidth()-5, yOffset+textHeight, text);
        yOffset += textHeight+3;
        if(text==null||text.trim().isEmpty())return;
        text(text);
    }
    @Override
    public void keyboardEvent(char character, int key, boolean pressed, boolean repeat){
        super.keyboardEvent(character, key, pressed, repeat);
        if(key==Keyboard.KEY_D&&Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)&&pressed&&!repeat){
            gui.open(new MenuNetDesigner(gui, this));
        }
    }
}