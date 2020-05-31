package geometryprinter;
import java.util.ArrayList;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuCredits extends Menu{
    public static final ArrayList<String> credits = new ArrayList<>();
    static{
        credits.add("Made By");
        credits.add("");
        credits.add("ThizThizzyDizzy");
        credits.add("");
        credits.add("");
        credits.add("Libraries Used");
        credits.add("");
        credits.add("SimpleLibrary");
        credits.add("by computerneek");
        credits.add("");
        credits.add("LWJGL");
        credits.add("by the LWJGL Team");
    }
    public MenuCredits(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    public void renderBackground(){
        yOffset = 0;
        totalTextHeight = 0;
        for(String str : credits){
            text(str);
        }
        if(scroll>totalTextHeight){
            scroll = -(Display.getHeight());
        }
    }
    private double yOffset = 300;
    private double scroll = Integer.MAX_VALUE;
    private double textHeight = 20;
    private double totalTextHeight = 0;
    private double textWidth = Display.getWidth()-400;
    public void text(String text){
        if(text==null||text.isEmpty()){
            text();
            return;
        }
        String[] texts = text.split("&");
        double wide = textWidth/(double)texts.length;
        GL11.glColor4d(0, 0, 0, 1);
        for(int i = 0; i<texts.length; i++){
            drawCenteredTextWithBounds(200+wide*i, yOffset-scroll, 200+wide*(i+1), yOffset+textHeight-scroll, Display.getWidth()/2-textWidth/2, 0, Display.getWidth()/2+textWidth/2, Display.getHeight(), texts[i]);
        }
        GL11.glColor4d(1, 1, 1, 1);
        totalTextHeight += textHeight;
        yOffset+=textHeight;
    }
    public void text(){
        totalTextHeight += textHeight;
        yOffset+=textHeight;
    }
    @Override
    public void tick(){
        super.tick();
        scroll+=2;
    }
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange){
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
        if(button==1)gui.open(parent);
    }
}