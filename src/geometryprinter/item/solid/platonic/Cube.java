package geometryprinter.item.solid.platonic;
import geometryprinter.PageObject;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.solid.other.Box;
import java.util.ArrayList;
public class Cube extends Box{
    public Cube(){
        this(1);
    }
    public Cube(int size){
        super(size, size, size);
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Size"));
        return settings;
    }
    @Override
    public void set(String property, Object value){
        if(property.toLowerCase().equals("size")){
            length = width = height = (int) value;
        }
    }
    @Override
    public String getDisplayName(){
        return length+" Pixel Cube";
    }
    @Override
    public PageObject replicate(){
        return new Cube(length);
    }
    @Override
    public String getCategoryName(){
        return "Platonic Solids";
    }
    @Override
    public String getItemName(){
        return "Cube";
    }
}