package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.flat.EquilateralTriangleArray;
import java.util.ArrayList;
public class SnubDisphenoid extends ItemFractured{
    private int size;
    public SnubDisphenoid(){
        this(0);
    }
    public SnubDisphenoid(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Snub Disphenoid";
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
        if(item instanceof SnubDisphenoid){
             if(size==((SnubDisphenoid) item).size){
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
        return new SnubDisphenoid(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        split.add(new EquilateralTriangleArray(size, 12));
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        String name = getDisplayName();
        int index = name.indexOf("Pixel");
        return name.substring(index+6);
    }
}