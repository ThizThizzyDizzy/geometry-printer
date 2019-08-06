package geometryprinter.item;
import geometryprinter.Core;
import simplelibrary.opengl.gui.components.MenuComponentSlider;
import simplelibraryextended.opengl.gui.components.MenuComponentPanel;
public class SettingInt implements Setting{
    private final String name;
    private int min,max;
    public SettingInt(String name){
        this(name, 0);
    }
    public SettingInt(String name, int min){
        this(name, min, 100);
    }
    public SettingInt(String name, int min, int max){
        this(name, min, max, Math.max(min,Math.min(max, 0)));
    }
    public SettingInt(String name, int min, int max, int value){
        this.name = name;
        this.min = min;
        this.max = max;
        this.value = value;
    }
    private int value;
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
            MenuComponentSlider slider = new MenuComponentSlider(0, 0, width, height, min, max, value, true);
            private boolean added = false;
            @Override
            public void tick(){
                if(!added){
                    add(slider);
                    added = true;
                }
                value = (int)slider.getValue();
                super.tick();
            }
        };
        return panel;
    }
    @Override
    public Object getRandomValue(){
        return Core.rand.nextInt(max-min)+min;
    }
    @Override
    public Setting replicate(){
        return new SettingInt(name, min, max, value);
    }
    @Override
    public int getSize(){
        return 1;
    }
}