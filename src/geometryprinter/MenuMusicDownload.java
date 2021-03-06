package geometryprinter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.lwjgl.opengl.Display;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
import simplelibrary.opengl.gui.components.MenuComponentButton;
public class MenuMusicDownload extends Menu{
    private final int kb;
    public MenuMusicDownload(GUI gui, Menu parent, int kb){
        super(gui, parent);
        this.kb = kb;
        MenuComponentButton no = add(new MenuComponentButton(Display.getWidth()/8, Display.getHeight()*.7, Display.getWidth()/3, Display.getHeight()/16, "NO", true, true));
        MenuComponentButton yes = add(new MenuComponentButton(Display.getWidth()-no.width-Display.getWidth()/8, Display.getHeight()*.7, Display.getWidth()/3, Display.getHeight()/16, "YES", true, true));
        final Menu theParent = parent;
        final GUI theGUI = gui;
        no.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                theGUI.open(theParent);
            }
        });
        yes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Sounds.allowDownload = true;
                theGUI.open(theParent);
            }
        });
    }
    @Override
    public void render(int millisSinceLastTick){
        super.render(millisSinceLastTick);
        drawCenteredText(0, Display.getHeight()*.3, Display.getWidth(), Display.getHeight()*.35, Main.applicationName+" would like to download "+getSize()+" of music.");
        drawCenteredText(0, Display.getHeight()*.35, Display.getWidth(), Display.getHeight()*.4, "This is optional, but highly reccommended");
        drawCenteredText(0, Display.getHeight()*.42, Display.getWidth(), Display.getHeight()*.47, "Allow download?");
    }
    private String getSize(){
        if(kb<1_000){
            return kb+" KB";
        }
        if(kb<1_000_000){
            return Math.round(kb/10d)/100d+" MB";
        }
        return Math.round(kb/10_000d)/100d+" GB";
    }
}