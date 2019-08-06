package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.flat.IsoscelesTriangleArray;
import java.util.ArrayList;
public class InvertedCube extends ItemFractured{
    private int size;
    public InvertedCube(){
        this(0);
    }
    public InvertedCube(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Inverted Cube";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "size":
                size = (int) value;
                break;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof InvertedCube){
             if(size==((InvertedCube) item).size){
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
    public PageObject replicate(){
        return new InvertedCube(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        split.add(new IsoscelesTriangleArray(size, (int) Math.sqrt(Math.pow(size/2d,2)*2), 12));
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Inverted Cube";
    }
}