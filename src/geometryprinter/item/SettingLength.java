package geometryprinter.item;
import geometryprinter.Core;
import simplelibrary.opengl.gui.components.MenuComponentOptionButton;
import simplelibrary.opengl.gui.components.MenuComponentSlider;
import simplelibraryextended.opengl.gui.components.MenuComponentPanel;
public class SettingLength implements Setting{
    private String name = "Length";
    public SettingLength(){}
    public SettingLength(String name){
        this.name = name;
    }
    /**
     *  Length in inches.
     */
    private int length = 72;
    @Override
    public String getName(){
        return name;
    }
    @Override
    public Object getValue(){
        return length;
    }
    @Override
    public MenuComponentPanel getSettings(double width, double height){
        final MenuComponentOptionButton measure = new MenuComponentOptionButton(0, 0, width, height/2, "Measure", true, true, "/textures/gui/button", 0, "Inches", "Centimeters");
        final MenuComponentSlider slider = new MenuComponentSlider(0, height/2, width, height/2, .5, 5, 1, 20, true);
        MenuComponentPanel panel = new MenuComponentPanel(0, 0, width, height){
            @Override
            public void tick(){
                if(measure.getIndex()==1){
                    length = (int) ((slider.getValue()/2.54)*72);
                }else{
                    length = (int) (slider.getValue()*72);
                }
                super.tick();
            }
        };
        panel.add(measure);
        panel.add(slider);
        return panel;
    }
    @Override
    public Object getRandomValue(){
        double min = .5/2.54;
        double max = 360;
        return Core.rand.nextDouble()*(max-min)+min;
    }
    @Override
    public Setting replicate(){
        SettingLength l = new SettingLength(name);
        l.length = length;
        return l;
    }
    @Override
    public int getSize(){
        return 2;
    }
}