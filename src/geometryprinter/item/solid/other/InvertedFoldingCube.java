package geometryprinter.item.solid.other;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.util.ArrayList;
public class InvertedFoldingCube extends ItemFractured{
    private int size;
    public InvertedFoldingCube(){
        this(0);
    }
    public InvertedFoldingCube(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Inverted Folding Cube";
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
        if(item instanceof InvertedFoldingCube){
             if(size==((InvertedFoldingCube) item).size){
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
        return new InvertedFoldingCube(size);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        for(int i = 0; i<8; i++){
            split.add(new InvertedCube(size));
        }
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Inverted Folding Cube";
    }
}