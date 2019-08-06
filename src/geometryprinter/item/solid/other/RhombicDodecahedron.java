package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.flat.Rhombus;
import java.util.ArrayList;
public class RhombicDodecahedron extends ItemFractured{
    private int size;
    public RhombicDodecahedron(){
        this(0);
    }
    public RhombicDodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Rhombic Dodecahedron";
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
        if(item instanceof RhombicDodecahedron){
             if(size==((RhombicDodecahedron) item).size){
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
        return new RhombicDodecahedron(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        for(int i = 0; i<12; i++){
            split.add(new Rhombus(size));
        }
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Rhombic Dodecahedron";
    }
}