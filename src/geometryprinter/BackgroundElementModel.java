package geometryprinter;
import org.lwjgl.opengl.GL11;
import simplelibraryextended.opengl.Renderer3D;
import simplelibraryextended.opengl.model.Model;
public class BackgroundElementModel extends BackgroundElement{
    private final Model model;
    private double scale = Core.rand.nextDouble()/2+.1;
    public BackgroundElementModel(Model model){
        model.randomizeColors();
        this.model = model;
    }
    @Override
    protected void draw(int millisSinceLastTick){
        GL11.glPushMatrix();
        GL11.glScaled(scale, scale, scale);
        Renderer3D.drawModel(model);
        GL11.glPopMatrix();
    }
}