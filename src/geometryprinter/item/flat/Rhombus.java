package geometryprinter.item.flat;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class Rhombus extends Item{
    private int shortLength;
    public Rhombus(){
        this(0);
    }
    public Rhombus(int shortLength){
        this.shortLength = shortLength;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        g.drawLine(0, (getHeight()-1)/2, (getWidth()-1)/2, 0);
        g.drawLine(0, (getHeight()-1)/2, (getWidth()-1)/2, (getHeight()-1));
        g.drawLine((getWidth()-1), (getHeight()-1)/2, (getWidth()-1)/2, 0);
        g.drawLine((getWidth()-1), (getHeight()-1)/2, (getWidth()-1)/2, (getHeight()-1));
        g.setColor(new Color(127, 127, 127));
        g.drawLine((getWidth()-1)/2,0,(getWidth()-1)/2,(getHeight()-1));
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Rhombus){
            if(shortLength==((Rhombus) item).shortLength){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Rhombus(shortLength);
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Short Length"));
        return settings;
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "short length":
                shortLength = (int) value;
                break;
        }
    }
    @Override
    public boolean requiresDoubleSiding(){
        return false;
    }
    @Override
    public String getDisplayName(){
        return shortLength+" Pixel Rhombus";
    }
    @Override
    public boolean canSplit(){
        return false;
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension((int)(shortLength*Math.sqrt(2)),shortLength);
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
        return "Rhombus";
    }
}