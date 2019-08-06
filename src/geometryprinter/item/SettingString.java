package geometryprinter.item;
import geometryprinter.Core;
import simplelibrary.Sys;
import simplelibrary.opengl.gui.components.MenuComponentTextBox;
import simplelibraryextended.opengl.gui.components.MenuComponentPanel;
public class SettingString implements Setting{
    private final String name;
    public SettingString(String name){
        this.name = name;
    }
    private String value = "";
    @Override
    public String getName(){
        return name;
    }
    @Override
    public Object getValue(){
        return value;
    }
    @Override
    public MenuComponentPanel getSettings(double width, double height){
        MenuComponentPanel panel = new MenuComponentPanel(0, 0, width, height){
            MenuComponentTextBox text = new MenuComponentTextBox(0, 0, width, height, value, true);
            private boolean added = false;
            @Override
            public void tick(){
                if(!added){
                    add(text);
                    added = true;
                }
                value = text.text;
                super.tick();
            }
        };
        return panel;
    }
    @Override
    public Object getRandomValue(){
        return Sys.generateRandomString(Core.rand.nextInt(10)+1);
    }
    @Override
    public Setting replicate(){
        SettingString s = new SettingString(name);
        s.value = value;
        return s;
    }
    @Override
    public int getSize(){
        return 2;
    }
}