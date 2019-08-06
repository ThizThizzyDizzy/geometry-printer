package geometryprinter.item;
import geometryprinter.PageObject;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public abstract class ItemFractured extends Item{
    public ItemFractured(){
        super();
        if(init){
            System.err.println("Loading Fractured Item: "+getDisplayName());
        }
    }
    @Override
    public void draw(Graphics g, PageFormat format){}
    @Override
    public boolean requiresDoubleSiding(){
        return false;
    }
    @Override
    public boolean requiresColor(){
        return false;
    }
    @Override
    public abstract String getDisplayName();
    @Override
    public abstract void set(String property, Object value);
    @Override
    public abstract boolean isEqual(Item item);
    @Override
    public abstract ArrayList<Setting> getSettings();
    @Override
    public boolean canSplit(){
        return true;
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension(0, 0);
    }
    @Override
    public abstract PageObject replicate();
    @Override
    public abstract void split(ArrayList<PageObject> split);
    @Override
    public abstract String getCategoryName();
    @Override
    public abstract String getItemName();
}