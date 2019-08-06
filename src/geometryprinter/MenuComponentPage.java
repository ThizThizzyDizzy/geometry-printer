package geometryprinter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import org.lwjgl.opengl.GL11;
import simplelibrary.opengl.ImageStash;
import simplelibrary.opengl.gui.components.MenuComponent;
public class MenuComponentPage extends MenuComponent{
    protected int img = -1;
    protected final Page page;
    public MenuComponentPage(Page page){
        super(0,0,page.getWidth(),page.getHeight()+10);
        this.page = page;
    }
    @Override
    public void render(){
        if(img==-1){
            BufferedImage image;
            try{
                image = new BufferedImage(page.getWidth(), page.getHeight(), BufferedImage.TYPE_INT_ARGB);
            }catch(OutOfMemoryError ex){
                Core.gui.open(new MenuOutOfMemory(Core.gui));
                return;
            }
            image.getGraphics().setColor(Color.WHITE);
            image.getGraphics().fillRect(0, 0, image.getWidth(), image.getHeight());
            image.getGraphics().setColor(Color.BLACK);
            page.draw(image.getGraphics());
            img = ImageStash.instance.allocateAndSetupTexture(image);
        }
        GL11.glColor4d(1, 1, 1, 1);
        drawRect(x, y, x+width, y+height-10, img);
    }
}