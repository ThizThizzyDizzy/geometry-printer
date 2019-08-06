package geometryprinter.item.flat;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class Rectangle extends Item{
    private int width, height;
    public Rectangle(){
        this(72, 72);
    }
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        g.drawRect(0, 0, width-1, height-1);
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Rectangle){
            if(width==((Rectangle) item).width&&height==((Rectangle) item).height){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Rectangle(width, height);
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Width"));
        settings.add(new SettingLength("Height"));
        return settings;
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "width":
                width = (int) value;
                break;
            case "height":
                height = (int) value;
        }
    }
    @Override
    public boolean requiresDoubleSiding(){
        return false;
    }
    @Override
    public String getDisplayName(){
        if(width==height){
            return width+"x"+height+" Square";
        }
        return width+"x"+height+" Rectangle";
    }
    @Override
    public boolean canSplit(){
        return false;
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension(width, height);
    }
    @Override
    public boolean requiresColor(){
        return false;
    }
    @Override
    public String getCategoryName(){
        return "Flat";
    }
    @Override
    public String getItemName(){
        return "Rectangle";
    }
}