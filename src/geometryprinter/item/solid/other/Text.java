package geometryprinter.item.solid.other;
import geometryprinter.item.materials.Timber;
import geometryprinter.item.materials.DiagonalTimber;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.ItemFractured;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import geometryprinter.item.SettingString;
import geometryprinter.item.solid.platonic.Cube;
import java.util.ArrayList;
public class Text extends ItemFractured{
    private String text;
    private int thickness;
    public Text(){
        this(0, "");
    }
    public Text(int thickness, String text){
        this.thickness = thickness;
        this.text = text;
    }
    @Override
    public String getDisplayName(){
        return thickness+" Pixel Text: "+text;
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "thickness":
                thickness = (int) value;
                break;
            case "text":
                text = (String) value;
                break;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Text){
             if(thickness==((Text) item).thickness&&text.equals(((Text) item).text)){
                 return true;
             }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Thickness"));
        settings.add(new SettingString("Text"));
        return settings;
    }
    @Override
    public PageObject replicate(){
        return new Text(thickness, text);
    }
    @Override
    public void split(ArrayList<PageObject> split){
        for(char c : text.toCharArray()){
            switch(c){
                case '0':
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Cube(thickness));
                    split.add(new Cube(thickness));
                    break;
                case '1':
                    split.add(new Timber(5*thickness, thickness));
                    break;
                case '2':
                    split.add(new Timber(3*thickness, thickness));
                    split.add(new Cube(thickness));
                    split.add(new Cube(thickness));
                    for(int i = 0; i<4; i++){
                        split.add(new DiagonalTimber(1*thickness, thickness));
                    }
                    split.add(new DiagonalTimber(2*thickness, thickness));
                    break;
                case '3':
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    break;
                case '4':
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    break;
                case '5':
                    split.add(new Timber(3*thickness, thickness));
                    split.add(new Timber(3*thickness, thickness));
                    split.add(new Timber(3*thickness, thickness));
                    split.add(new Cube(thickness));
                    split.add(new Cube(thickness));
                    break;
                case '6':
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Cube(thickness));
                    break;
                case '7':
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    break;
                case '8':
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Cube(thickness));
                    split.add(new Cube(thickness));
                    split.add(new Cube(thickness));
                    break;
                case '9':
                    split.add(new Timber(5*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Timber(2*thickness, thickness));
                    split.add(new Cube(thickness));
                    break;
                default:
                    throw new IllegalArgumentException("Cannot understand character: \'"+c+"\'");
            }
        }
    }
    @Override
    public String getCategoryName(){
        return "Other";
    }
    @Override
    public String getItemName(){
        return "Text";
    }
}