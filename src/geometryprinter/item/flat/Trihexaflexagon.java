package geometryprinter.item.flat;
import geometryprinter.PageObject;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingLength;
import java.util.ArrayList;
public class Trihexaflexagon extends EquilateralTriangleArray{
    public Trihexaflexagon(){
        this(1);
    }
    public Trihexaflexagon(int sideLength){
        super(sideLength, 10);
    }
    @Override
    public String getDisplayName(){
        return base+" pixel Trihexaflexagon";
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingLength("Length"));
        return settings;
    }
    @Override
    public PageObject replicate(){
        return new Trihexaflexagon(base);
    }
}