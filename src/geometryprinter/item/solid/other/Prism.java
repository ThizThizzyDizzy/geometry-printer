package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingInt;
import geometryprinter.item.SettingLength;
import geometryprinter.item.flat.Polygon;
import geometryprinter.item.flat.Rectangle;
import java.util.ArrayList;
public class Prism extends ItemFractured{
    private int sideLength, sides, height;
    public Prism(){
        this(0,0,0);
    }
    public Prism(int sideLength, int sides, int height){
        this.sideLength = sideLength;
        this.sides = sides;
        this.height = height;
    }
    @Override
    public String getDisplayName(){
        return sideLength+"x"+height+" "+sides+"-sided Prism";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "side length":
                sideLength = (int) value;
                break;
            case "height":
                height = (int) value;
                break;
            case "sides":
                sides = (int) value;
                break;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Prism){
             if(sideLength==((Prism) item).sideLength&&height==((Prism) item).height&&sides==((Prism) item).sides){
                 return true;
             }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingInt("Sides", 3, 20));
        settings.add(new SettingLength("Side Length"));
        settings.add(new SettingLength("Height"));
        return settings;
    }
    @Override
    public PageObject replicate(){
        return new Prism(sideLength, sides, height);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        split.add(new Polygon(sides, sideLength, true));
        split.add(new Polygon(sides, sideLength, true));
        for(int i = 0; i<sides; i++){
            split.add(new Rectangle(sideLength, height));
        }
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Prism";
    }
}