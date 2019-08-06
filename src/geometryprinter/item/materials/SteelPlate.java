package geometryprinter.item.materials;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingInt;
import geometryprinter.item.SettingLength;
import java.util.ArrayList;
public class SteelPlate extends ItemFractured{
    private int width,height,thickness;
    public SteelPlate(){
        this(0, 0, 1);
    }
    public SteelPlate(int width, int height, int thickness){
        this.width = width;
        this.height = height;
        this.thickness = thickness;
    }
    @Override
    public String getDisplayName(){
        return width+"x"+height+" Plate; Thickness: "+thickness;
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "width":
                this.width = (int) value;
                break;
            case "height":
                this.height = (int) value;
                break;
            case "thickness":
                this.thickness = (int)value;
                break;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof SteelPlate){
            if(height==((SteelPlate) item).height&&width==((SteelPlate) item).width&&thickness==((SteelPlate) item).thickness){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Width"));
        settings.add(new SettingLength("Height"));
        settings.add(new SettingInt("Thickness", 1, 5));
        return settings;
    }
    @Override
    public PageObject replicate(){
        return new SteelPlate(width,height,thickness);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        if(thickness==1){
            split.add(new Plate((int)width, (int)height, 1));
        }else{
            for(int i = 0; i<2; i++){
                split.add(new Plate((int)width, (int)height, 2));
            }
            for(int i = 0; i<thickness-2; i++){
                split.add(new Plate((int)width, (int)height, 0));
            }
        }
    }
    @Override
    public String getCategoryName(){
        return "Materials";
    }
    @Override
    public String getItemName(){
        return "Steel Plate";
    }
}