package geometryprinter;
import org.lwjgl.opengl.GL11;
public abstract class BackgroundElement{
    protected double xRotSpeed;
    protected double xRot;
    protected double yRotSpeed;
    protected double yRot;
    protected double zRotSpeed;
    protected double zRot;
    protected double xSpeed;
    protected double x;
    protected double ySpeed;
    protected double y;
    protected double zSpeed;
    protected double z;
    private static final double size = 25;
    private final int timeLimit = Core.rand.nextInt(20*25)+20*30;
    private int time = 0;
    private double scale = 0;
    public boolean dying = false;
    public boolean dead = false;
    public BackgroundElement(){
        xRot = Core.rand.nextDouble()*360;
        yRot = Core.rand.nextDouble()*360;
        zRot = Core.rand.nextDouble()*360;
        xSpeed = Core.rand.nextGaussian()*size/500;
        ySpeed = Core.rand.nextGaussian()*size/500;
        zSpeed = Core.rand.nextGaussian()*size/500;
        xRotSpeed = Core.rand.nextGaussian()*5;
        yRotSpeed = Core.rand.nextGaussian()*5;
        zRotSpeed = Core.rand.nextGaussian()*5;
        x = (Core.rand.nextDouble()-.5)*size;
        y = (Core.rand.nextDouble()-.5)*size;
        z = -5-Core.rand.nextDouble()*size/10;
    }
    public void render(int millisSinceLastTick){
        if(x>size*2-z&&xSpeed>=0){
            dying = true;
        }
        if(y>size*2-z&&ySpeed>=0){
            dying = true;
        }
        if(x<-size*2+z&&xSpeed<=0){
            dying = true;
        }
        if(y<-size*2+z&&ySpeed<=0){
            dying = true;
        }
        if(z>-1&&zSpeed>=0){
            dying = true;
        }
        if(z<-10&&zSpeed<=0){
            dying = true;
        }
        time++;
        if(time>=timeLimit||dying){
            if(scale>0){
                scale-=.05;
            }else{
                dead = true;
            }
        }else{
            if(scale<1){
                scale+=.05;
            }
        }
        xRot += xRotSpeed;
        yRot += yRotSpeed;
        zRot += zRotSpeed;
        x += xSpeed;
        y += ySpeed;
        z += zSpeed;
        GL11.glPushMatrix();
        GL11.glScaled(.2, .2, .2);
        GL11.glTranslated(x, y, z);
        GL11.glRotated(xRot, 1, 0, 0);
        GL11.glRotated(yRot, 0, 1, 0);
        GL11.glRotated(zRot, 0, 0, 1);
        GL11.glScaled(scale, scale, scale);
        GL11.glColor4d(1, 1, 1, 1);
        draw(millisSinceLastTick);
        GL11.glPopMatrix();
    }
    protected abstract void draw(int millisSinceLastTick);
}