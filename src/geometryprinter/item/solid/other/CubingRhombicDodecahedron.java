package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.util.ArrayList;
public class CubingRhombicDodecahedron extends ItemFractured{
    private int size;
    public CubingRhombicDodecahedron(){
        this(0);
    }
    public CubingRhombicDodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Cubing Rhombic Dodecahedron";
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
        if(item instanceof CubingRhombicDodecahedron){
             if(size==((CubingRhombicDodecahedron) item).size){
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
        return new CubingRhombicDodecahedron(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        for(int i = 0; i<6; i++){
            split.add(new CubicPyramid(size));
        }
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Cubing Rhombic Dodecahedron";
    }
}