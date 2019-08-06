package geometryprinter.item;
import geometryprinter.Core;
import simplelibrary.opengl.gui.components.MenuComponentOptionButton;
import simplelibraryextended.opengl.gui.components.MenuComponentPanel;
public class SettingBoolean implements Setting{
    private final String name;
    private int min,max;
    private boolean value;
    public SettingBoolean(String name){
        this(name, false);
    }
    public SettingBoolean(String name, boolean value){
        this.name = name;
        this.value = value;
    }
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
            MenuComponentOptionButton button = new MenuComponentOptionButton(0, 0, width, height, name, true, true, "/textures/gui/button", 0, new String[]{"False","True"});
            private boolean added = false;
            @Override
            public void tick(){
                if(!added){
                    add(button);
                    added = true;
                }
                value = button.getSelectedString().equalsIgnoreCase("True");
                super.tick();
            }
        };
        return panel;
    }
    @Override
    public Object getRandomValue(){
        return Core.rand.nextDouble();
    }
    @Override
    public Setting replicate(){
        SettingBoolean i = new SettingBoolean(name, value);
        return i;
    }
    @Override
    public int getSize(){
        return 1;
    }
}