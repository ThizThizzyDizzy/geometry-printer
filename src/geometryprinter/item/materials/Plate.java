package geometryprinter.item.materials;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.SettingInt;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class Plate extends Item{
    protected int width, height, thickness;
    public Plate(){
        this(0, 0, 1);
    }
    public Plate(int width, int height, int thickness){
        this.width = width;
        this.height = height;
        this.thickness = thickness;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        if(thickness<1){
            g.drawRect(0, 0, width, height);
            g.setColor(new Color(127,127,127));
            g.drawRect(1, 1, width-2, height-2);
            return;
        }
        g.setColor(new Color(200, 200, 200));
        g.fillRect(0, 0, width, height);
        g.setColor(new Color(175, 175, 175));
        g.drawRect(0, 0, width, height);
    }
    @Override
    public boolean requiresDoubleSiding(){
        return thickness==1;
    }
    @Override
    public boolean requiresColor(){
        return false;
    }
    @Override
    public String getDisplayName(){
        return width+"x"+height+" Plate";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "width":
                this.width = (int) value;
                break;
            case "height":
                this.height = (int) value;
                break;
            case "thickness":
                this.thickness = (int)value;
                break;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Plate){
            if(height==((Plate) item).height&&width==((Plate) item).width&&thickness==((Plate) item).thickness){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Width"));
        settings.add(new SettingLength("Height"));
        settings.add(new SettingInt("Thickness", 1, 5));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension(width+1, height+1);
    }
    @Override
    public PageObject replicate(){
        return new Plate(width, height, thickness);
    }
    @Override
    public String getCategoryName(){
        return "Materials";
    }
    @Override
    public String getItemName(){
        return "Plate";
    }
}