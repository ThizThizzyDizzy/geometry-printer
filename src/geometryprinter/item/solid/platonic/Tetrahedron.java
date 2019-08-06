package geometryprinter.item.solid.platonic;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.flat.EquilateralTriangleArray;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class Tetrahedron extends Item{
    private int length;
    public Tetrahedron(){
        this(1);
    }
    public Tetrahedron(int length){
        this.length = length;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        int base = length;
        int h = (int)((base*Math.sqrt(3))/2);
        g.drawLine(base, 0, base*2, h*2);
        g.drawLine(base, 0, 0, h*2);
        g.drawLine(0,h*2,base*2,h*2);
        g.drawLine(0,h*2,base*2,h*2);
        g.drawLine(base,h*2,base/2,h);
        g.drawLine(base,h*2,base+base/2,h);
        g.drawLine(base/2,h,base+base/2,h);
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
        return length+" Pixel Tetrahedron";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "size":
                length = (int) value;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Tetrahedron){
            if(length==((Tetrahedron) item).length){
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
        return true;
    }
    @Override
    protected Dimension getItemSize(){
        int base = length;
        int h = (int)((base*Math.sqrt(3))/2);
        return new Dimension(base*2,h*2+1);
    }
    @Override
    public PageObject replicate(){
        return new Tetrahedron(length);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        split.add(new EquilateralTriangleArray(length, 4));
    }
    @Override
    public String getCategoryName(){
        return "Platonic Solids";
    }
    @Override
    public String getItemName(){
        return "Tetrahedron";
    }
}