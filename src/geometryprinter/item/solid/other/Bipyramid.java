package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingInt;
import geometryprinter.item.SettingLength;
import geometryprinter.item.flat.IsoscelesTriangleArray;
import java.util.ArrayList;
public class Bipyramid extends ItemFractured{
    private int sideLength, sides, height;
    public Bipyramid(){
        this(0,0,0);
    }
    public Bipyramid(int sideLength, int sides, int height){
        this.sideLength = sideLength;
        this.sides = sides;
        this.height = height;
    }
    @Override
    public String getDisplayName(){
        return sideLength+"x"+height+" "+sides+"-sided Bipyramid";
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
        if(item instanceof Bipyramid){
             if(sideLength==((Bipyramid) item).sideLength&&height==((Bipyramid) item).height&&sides==((Bipyramid) item).sides){
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
        return new Bipyramid(sideLength, sides, height);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        double radius = (1/Math.cos(Math.toRadians(90-(180/sides))))*(sideLength/2d);
        double height = this.height/2d;
        split.add(new IsoscelesTriangleArray(sideLength, (int) Math.sqrt(height*height+radius*radius), sides*2));
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Bipyramid";
    }
}