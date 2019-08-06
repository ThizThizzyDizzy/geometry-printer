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
public class GyroelongatedPentagonalCupola extends ItemFractured{
    private int size;
    public GyroelongatedPentagonalCupola(){
        this(0);
    }
    public GyroelongatedPentagonalCupola(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Gyroelongated Pentagonal Cupola";
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
        if(item instanceof GyroelongatedPentagonalCupola){
             if(size==((GyroelongatedPentagonalCupola) item).size){
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
        return new GyroelongatedPentagonalCupola(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        split.add(new EquilateralTriangleArray(size, 25));
        for(int i = 0; i<5; i++){
            split.add(new Rectangle(size,size));
        }
        split.add(new Polygon(5,size,true));
        split.add(new Polygon(10,size,true));
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