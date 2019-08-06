package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.solid.platonic.Cube;
import java.util.ArrayList;
public class FoldingCube extends ItemFractured{
    private int size;
    public FoldingCube(){
        this(0);
    }
    public FoldingCube(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Folding Cube";
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
        if(item instanceof FoldingCube){
             if(size==((FoldingCube) item).size){
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
        return new FoldingCube(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        for(int i = 0; i<8; i++){
            split.add(new Cube(size/2));
        }
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Folding Cube";
    }
}