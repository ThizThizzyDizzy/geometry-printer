package geometryprinter.item.flat;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingInt;
import geometryprinter.item.SettingLength;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class IsoscelesTriangleArray extends Item{
    protected int base, height, triangles;
    public IsoscelesTriangleArray(){
        this(1, 1, 1);
    }
    public IsoscelesTriangleArray(int base, int height, int triangles){
        this.base = base;
        this.height = height;
        this.triangles = triangles;
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        for(int i = 0; i<triangles; i++){
            if(i%2==0){
                drawTriangle(i/2*base, 0, base, height-1, g, false, false);
            }else{
                drawTriangle(i/2*base+base/2, 0, base, height-1, g, false, true);
            }
        }
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
        return base+"x"+height+" Triangle array ("+triangles+")";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "base":
                base = (int)value;
                break;
            case "height":
                height = (int)value;
                break;
            case "triangles":
            case "count":
                triangles = (int)(value);
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof IsoscelesTriangleArray){
            if(base==((IsoscelesTriangleArray) item).base&&height==((IsoscelesTriangleArray) item).height&&triangles==((IsoscelesTriangleArray) item).triangles){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Base"));
        settings.add(new SettingLength("Height"));
        settings.add(new SettingInt("Count", 1));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return triangles>1;
    }
    @Override
    public void split(ArrayList<PageObject> split){
        int t = triangles/2;
        split.add(new IsoscelesTriangleArray(base, height, t));
        split.add(new IsoscelesTriangleArray(base, height, triangles-t));
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension((int)((triangles+1)*base/2D), height);
    }
    @Override
    public PageObject replicate(){
        return  new IsoscelesTriangleArray(base, height, triangles);
    }
    @Override
    public String getCategoryName(){
        return "Flat";
    }
    @Override
    public String getItemName(){
        return "Isosceles Triangle Array";
    }
}