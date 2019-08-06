package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class CubicPyramid extends Item{
    private int size;
    public CubicPyramid(){
        this(1);
    }
    public CubicPyramid(int size){
        this.size = size;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        int base = size;
        int height = (int)(Math.sqrt(size*size+((size/2d)*(size/2d)))/2);
        g.drawRect(height, height, base, base);
        g.drawLine(height+base/2, 0, height, height);
        g.drawLine(height+base/2, 0, height+base, height);
        g.drawLine(0, height+base/2, height, height);
        g.drawLine(0, height+base/2, height, height+base);
        g.drawLine(height+base,height,height*2+base,height+base/2);
        g.drawLine(height+base,height+base,height*2+base,height+base/2);
        g.drawLine(height,height+base,height+base/2,height*2+base);
        g.drawLine(height+base,height+base,height+base/2,height*2+base);
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
        return size+" Pixel Cubic Pyramid";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "size":
                this.size = (int) value;
                break;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof CubicPyramid){
            if(size==((CubicPyramid) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Size"));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;//TODO yes
    }
    @Override
    protected Dimension getItemSize(){
        int base = size;
        int height = (int)(Math.sqrt(size*size+((size/2d)*(size/2d)))/2);
        return new Dimension(base+height*2,base+height*2);
    }
    @Override
    public PageObject replicate(){
        return new CubicPyramid(size);
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Cubic Pyramid";
    }
}