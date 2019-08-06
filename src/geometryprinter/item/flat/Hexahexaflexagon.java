package geometryprinter.item.flat;
import geometryprinter.PageObject;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.util.ArrayList;
public class Hexahexaflexagon extends EquilateralTriangleArray{
    public Hexahexaflexagon(){
        this(1);
    }
    public Hexahexaflexagon(int sideLength){
        super(sideLength, 19);
    }
    @Override
    public String getDisplayName(){
        return base+" pixel Hexahexaflexagon";
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Length"));
        return settings;
    }
    @Override
    public PageObject replicate(){
        return new Hexahexaflexagon(base);
    }
}