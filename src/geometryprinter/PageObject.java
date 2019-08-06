package geometryprinter;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
import javax.swing.JPanel;
public abstract class PageObject extends JPanel{
    public PageObject(){}
    public abstract void print(Graphics g, PageFormat format);
    public abstract boolean requiresDoubleSiding();
    public abstract boolean requiresColor();
    public abstract PageObject replicate();
    public abstract String getDisplayName();
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        print(g, null);
    }
    /**
     *Draws an isosceles Triangle
     * @param x the X position of the Triangle
     * @param y the Y position of the Triangle
     * @param base the width of the Triangle's Base
     * @param height The triangle's height
     * @param g The graphics object to draw with
     * @param sideways weather or not to draw the triangle rotated sideways
     * @param flipped weather or not to flip over the triangle
     */
    protected void drawTriangle(int x, int y, int base, int height, Graphics g, boolean sideways, boolean flipped){
        if(sideways){
            if(flipped){
                g.drawLine(x+height, y, x+height, y+base);
                g.drawLine(x+height, y, x, y+base/2);
                g.drawLine(x, y+base/2, x+height, y+base);
            }else{
                g.drawLine(x, y, x, y+base);
                g.drawLine(x, y, x+height, y+base/2);
                g.drawLine(x+height, y+base/2, x, y+base);
            }
        }else{
            if(flipped){
                g.drawLine(x, y+height, x+base, y+height);
                g.drawLine(x, y+height, x+base/2, y);
                g.drawLine(x+base/2, y, x+base, y+height);
            }else{
                g.drawLine(x, y, x+base, y);
                g.drawLine(x, y, x+base/2, y+height);
                g.drawLine(x+base/2, y+height, x+base, y);
            }
        }
    }
    public abstract boolean canSplit();
    public void split(ArrayList<PageObject> split){
        throw new UnsupportedOperationException("Item "+getDisplayName()+" is marked as splittable, but split(...) is not overriden!");
    }
    public void update(){
        setSize(getItemSize());
    }
    protected abstract Dimension getItemSize();
}