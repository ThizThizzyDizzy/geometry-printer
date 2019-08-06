package geometryprinter;
import simplelibrary.opengl.ImageStash;
public class MenuComponentEditablePage extends MenuComponentPage{
    public MenuComponentEditablePage(Page page){
        super(page);
    }
    public void refresh(){
        if(img>-1){
            System.out.println("Refreshing...");
            ImageStash.instance.deleteTexture(img);
            img = -1;
        }
    }
}