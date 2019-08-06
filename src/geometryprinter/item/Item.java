package geometryprinter.item;
import geometryprinter.PageObject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.io.IOException;
import java.util.ArrayList;
import simplelibraryextended.opengl.model.Model;
import simplelibraryextended.opengl.model.OBJLoader;
public abstract class Item extends PageObject{
    public static ArrayList<Item> items = new ArrayList<>();
    public static boolean init = true;
    public ArrayList<Setting> settings = new ArrayList<>();
    public Item(){
        if(init)items.add(this);
    }
    @Override
    public void print(Graphics g, PageFormat format){
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        draw(g, format);
    }
    public abstract void draw(Graphics g, PageFormat format);
    @Override
    public abstract boolean requiresDoubleSiding();
    @Override
    public abstract boolean requiresColor();
    @Override
    public abstract String getDisplayName();
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Item){
            return isEqual((Item)obj);
        }
        return false;
    }
    public abstract void set(String property, Object value);
    public abstract boolean isEqual(Item item);
    public abstract ArrayList<Setting> getSettings();
    @Override
    public abstract boolean canSplit();
    @Override
    protected abstract Dimension getItemSize();
    public abstract String getCategoryName();
    public abstract String getItemName();
    public Model getModel() throws IOException{
        return getModel(settings);
    }
    public Model getModel(ArrayList<Setting> settings) throws IOException{
        return OBJLoader.loadModel("/models/"+getCategoryName().toLowerCase()+"/"+getItemName().toLowerCase()+"/model.obj");
    }
    public double getModelScale(){
        return getModelScale(settings);
    }
    public double getModelScale(ArrayList<Setting> settings){
        for(Setting setting : settings){
            if(setting.getName().equalsIgnoreCase("size")){
                return (int) setting.getValue()/72d;
            }
        }
        return 1;
    }
    public void randomize(){
        for(Setting setting : getSettings()){
            set(setting.getName(), setting.getRandomValue());
        }
        update();
    }
    public boolean changesShape(){
        return false;
    }
}