package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class Box extends Item{
    protected int length, width, height;
    public Box(){
        this(1, 1, 1);
    }
    public Box(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        int yOfCenterLine = Math.max(length/2,width/2);
        //center line
        g.drawRect(0, yOfCenterLine, length, height);
        g.drawRect(length, yOfCenterLine, width, height);
        g.drawRect(length+width, yOfCenterLine, length, height);
        g.drawRect(length*2+width, yOfCenterLine, width, height);
        
        //top line
        g.drawRect(0, yOfCenterLine-width/2, length, width/2);
        g.drawRect(length, yOfCenterLine-length/2, width, length/2);
        g.drawRect(length+width, yOfCenterLine-width/2, length, width/2);
        g.drawRect(length*2+width, yOfCenterLine-length/2, width, length/2);
        
        //bottom line
        g.drawRect(0, yOfCenterLine+height, length, width/2);
        g.drawRect(length, yOfCenterLine+height, width, length/2);
        g.drawRect(length+width, yOfCenterLine+height, length, width/2);
        g.drawRect(length*2+width, yOfCenterLine+height, width, length/2);
    }
    @Override
    public boolean requiresDoubleSiding(){
        return false;
    }
    @Override
    public boolean requiresColor(){
        return false;
    }
    @Override
    public String getDisplayName(){
        return length+"x"+width+"x"+height+" Box";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "length":
                this.length = (int) value;
                break;
            case "width":
                this.width = (int)value;
                break;
            case "height":
                this.height = (int)value;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Box){
            if(length==((Box) item).length&&width==((Box) item).width&&height==((Box) item).height){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Length"));
        settings.add(new SettingLength("Width"));
        settings.add(new SettingLength("Height"));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;//TODO yes
    }
    @Override
    protected Dimension getItemSize(){
        int realWidth = length*2+width*2+1;
        int yOfCenterLine = Math.max(length/2,width/2);
        int realHeight = yOfCenterLine*2+height+1;
        return new Dimension(realWidth, realHeight);
    }
    @Override
    public PageObject replicate(){
        return new Box(length, width, height);
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Box";
    }
}