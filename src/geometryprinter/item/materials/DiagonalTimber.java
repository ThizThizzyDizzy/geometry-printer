package geometryprinter.item.materials;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class DiagonalTimber extends Item{
    protected int length, thickness;
    public DiagonalTimber(){
        this(0, 0);
    }
    public DiagonalTimber(int length, int thickness){
        this.length = length;
        this.thickness = thickness;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        int leg = legLength(thickness);
        g.translate(leg, leg);
        g.drawRect(0, length, thickness, thickness);
        g.drawRect(length, 0, thickness, thickness);
        g.drawLine(thickness, length, length, thickness);
        g.drawLine(0, length, length, 0);
        g.drawLine(thickness, length, thickness+leg, length+leg);
        g.drawLine(length, thickness, length+leg, thickness+leg);
        g.drawLine(thickness+leg, length+leg, length+leg, thickness+leg);
        g.translate(-leg, -leg);
        g.drawLine(0, length, length, 0);
        g.drawLine(0, length, 0, length-thickness);
        g.drawLine(length, 0, length-thickness, 0);
        g.drawLine(length-thickness, 0, 0, length-thickness);
        g.drawLine(length, 0, length+leg, leg);
        g.drawLine(0, length, leg, length+leg);
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
        return length+" Pixel Diagonal Timber; Thickness: "+thickness;
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
        if(item instanceof DiagonalTimber){
            if(length==((DiagonalTimber) item).length&&thickness==((DiagonalTimber) item).thickness){
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
    public int legLength(int hypotenuse){
        return (int)((hypotenuse*Math.sqrt(2))/2);
    }
    @Override
    protected Dimension getItemSize(){
        int size = length+legLength(thickness)+thickness+1;
        return new Dimension(size, size);
    }
    @Override
    public PageObject replicate(){
        return new DiagonalTimber(length, thickness);
    }
    @Override
    public String getCategoryName(){
        return "Materials";
    }
    @Override
    public String getItemName(){
        return "Diagonal Timber";
    }
}