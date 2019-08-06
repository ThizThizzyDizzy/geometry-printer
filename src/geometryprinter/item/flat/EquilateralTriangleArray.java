package geometryprinter.item.flat;
import geometryprinter.PageObject;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingInt;
import geometryprinter.item.SettingLength;
import java.util.ArrayList;
public class EquilateralTriangleArray extends IsoscelesTriangleArray{
    public EquilateralTriangleArray(){
        this(1,1);
    }
    public EquilateralTriangleArray(int sideLength, int triangles){
        super(sideLength, (int)(sideLength*Math.sqrt(3))/2, triangles);
    }
    @Override
    public String getDisplayName(){
        return base+" pixel Equilaterial Triangle Array ("+triangles+")";
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "base":
                base = (int)value;
                height = (int)(base*Math.sqrt(3))/2;
                break;
            case "length":
                base = (int)value;
                height = (int)(base*Math.sqrt(3))/2;
                break;
            case "triangles":
            case "count":
                triangles = (int)(value);
        }
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Length"));
        settings.add(new SettingInt("Count", 1));
        return settings;
    }
    @Override
    public PageObject replicate(){
        return new EquilateralTriangleArray(base, triangles);
    }
}