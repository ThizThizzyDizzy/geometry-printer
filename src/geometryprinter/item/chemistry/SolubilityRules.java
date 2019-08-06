package geometryprinter.item.chemistry;
import geometryprinter.Page;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingBoolean;
import geometryprinter.item.SettingInt;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class SolubilityRules extends Item{
    public SolubilityRules(){
        this(1);
    }
    public SolubilityRules(int size){
        this.size = size;
    }
    private int size;
    private static final int textHeight = 3;//for size 1
    private static final int borderSize = 5;//for size 1
    @Override
    public void draw(Graphics g, PageFormat format){
        g.setColor(Color.black);//each line is 3 pixels tall
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.setFont(new Font("Segoe UI", Font.PLAIN, size*textHeight*2));
        g.drawString("The Solubility Rules", size*borderSize+textHeight*3, (int)(size*(borderSize+textHeight*1.5)));
        g.setFont(new Font("Segoe UI", Font.PLAIN, size*textHeight));
        g.drawString("1. All common salts of the Group 1 elements and", size*borderSize, size*(borderSize+textHeight*3));
        g.drawString("    ammonium are soluble.", size*borderSize, size*(borderSize+textHeight*4));
        g.drawString("2. All common acetates and nitrates are soluble", size*borderSize, size*(borderSize+textHeight*5));
        g.drawString("3. All binary compounds of Group VII elements", size*borderSize, size*(borderSize+textHeight*6));
        g.drawString("   (Other than F) with metals are soluble except", size*borderSize, size*(borderSize+textHeight*7));
        g.drawString("   those of silver, mercury (I), and lead.", size*borderSize, size*(borderSize+textHeight*8));
        g.drawString("4. All sulfates are soluble except those of barium,", size*borderSize, size*(borderSize+textHeight*9));
        g.drawString("   strontium, lead, calcium, silver, and mercury (I)", size*borderSize, size*(borderSize+textHeight*10));
        g.drawString("5. Except for those in rule 1, carbonates, hydroxides,", size*borderSize, size*(borderSize+textHeight*11));
        g.drawString("   oxides, and phosphates are insoluble.", size*borderSize, size*(borderSize+textHeight*12));
    }
    @Override
    public boolean requiresDoubleSiding(){
        return false;
    }
    @Override
    public boolean requiresColor(){
        return false;
    }
    @Override
    public String getDisplayName(){
        return "Size "+size+" Solubility Rules";
    }
    @Override
    public void set(String property, Object value){
        if(property.equals("size")){
            size = (int)value;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof SolubilityRules){
            return ((SolubilityRules) item).size==size;
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingInt("size", 1, 9, 4));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension(size*(borderSize*2+textHeight*23), size*(borderSize*2+textHeight*12));
    }
    @Override
    public String getCategoryName(){
        return "Chemistry";
    }
    @Override
    public String getItemName(){
        return "Solubility Rules";
    }
    @Override
    public PageObject replicate(){
        return new SolubilityRules(size);
    }
}