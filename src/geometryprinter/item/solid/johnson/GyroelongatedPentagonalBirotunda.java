package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.flat.EquilateralTriangleArray;
import geometryprinter.item.flat.Polygon;
import geometryprinter.item.flat.Rectangle;
import java.util.ArrayList;
public class GyroelongatedPentagonalBirotunda extends ItemFractured{
    private int size;
    public GyroelongatedPentagonalBirotunda(){
        this(0);
    }
    public GyroelongatedPentagonalBirotunda(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Gyroelongated Pentagonal Birotunda";
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
        if(item instanceof GyroelongatedPentagonalBirotunda){
             if(size==((GyroelongatedPentagonalBirotunda) item).size){
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
        return new GyroelongatedPentagonalBirotunda(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        split.add(new EquilateralTriangleArray(size, 40));
        for(int i = 0; i<12; i++){
            split.add(new Polygon(5,size,true));
        }
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