package geometryprinter.item.materials;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class Timber extends Item{
    protected int length, thickness;
    public Timber(){
        this(0, 0);
    }
    public Timber(int length, int thickness){
        this.length = length;
        this.thickness = thickness;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        g.drawRect(thickness, 0, length, thickness);
        g.drawRect(0, thickness, thickness, thickness);
        g.drawRect(thickness+length, thickness, thickness, thickness);
        g.drawRect(thickness, thickness, length, thickness);
        g.drawRect(thickness, thickness*2, length, thickness);
        g.drawRect(thickness, thickness*3, length, thickness);
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
        return length+" Pixel Timber; Thickness: "+thickness;
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "length":
                this.length = (int) value;
                break;
            case "thickness":
                this.thickness = (int)value;
                break;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Timber){
            if(length==((Timber) item).length&&thickness==((Timber) item).thickness){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Length"));
        settings.add(new SettingLength("Thickness"));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;//TODO yes
    }
    @Override
    protected Dimension getItemSize(){
        int realWidth = length+thickness*2+1;
        int realHeight = thickness*4+1;
        return new Dimension(realWidth, realHeight);
    }
    @Override
    public PageObject replicate(){
        return new Timber(length, thickness);
    }
    @Override
    public String getCategoryName(){
        return "Materials";
    }
    @Override
    public String getItemName(){
        return "Timber";
    }
}