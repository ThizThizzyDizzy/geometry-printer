package geometryprinter.item.chemistry;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingInt;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class PolyatomicIonSheet extends Item{
    public PolyatomicIonSheet(){
        this(1);
    }
    public PolyatomicIonSheet(int size){
        this.size = size;
    }
    private int size;
    private static final int textHeight = 3;//for size 1
    private static final int borderSize = 5;//for size 1
    private static final int columnWidth = textHeight*10;//for size 1
    @Override
    public void draw(Graphics g, PageFormat format){
        g.setColor(Color.black);//each line is 3 pixels tall
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.setFont(new Font("Segoe UI", Font.PLAIN, size*textHeight*2));
        g.drawString("Polyatomic Ions", size*borderSize+textHeight*3, (int)(size*(borderSize+textHeight*1.5)));
        g.setFont(new Font("Segoe UI", Font.PLAIN, size*textHeight));
        ArrayList<String> texts = new ArrayList<>();
        texts.add("Forumula\tName\tFormula\tName");
        texts.add("NO3^-\tnitrate\tClO4^-\tperclorate");
        texts.add("NO2^-\tnitrite\tClO3^-\tchlorate");
        texts.add("CrO4^2-\tchromate\tClO2^-\tchlorite");
        texts.add("Cr2O7^2-\tdichromate\tClO^-\thypochlorite");
        texts.add("CN^-\tcyanide\tCl can be replaced by any halogen\t ");
        texts.add("MnO4^-\tpermanganate\t\t ");
        texts.add("OH^-\thydroxide\tHCO3^-\thydrogen carbonate");
        texts.add("O2^2-\tperoxide\t\t (bicarbonate)");
        texts.add("NH2^-\tamide\tHSO4^-\thydrogen sulfate");
        texts.add("CO3^2-\tcarbonate\t\t (bisulfate)");
        texts.add("SO4^2-\tsulfate\tHSO3^-\thydrogen sulfite");
        texts.add("SO3^2-\tsulfite\t\t (bisulfite)");
        texts.add("C2O4^2-\toxalate\tHC2O4^-\thydrogen oxalate");
        texts.add("PO4^3-\tphosphate\t\t (bioxalate)");
        texts.add("PO3^3-\tphosphite\tHPO4^2-\thydrogen phosphate");
        texts.add("S2O3^2-\tthiosulfate\tH2PO4^-\tdihydrogen phosphate");
        texts.add("AsO4^3-\tarsenate\tHS^-\thydrogen sulfide");
        texts.add("SeO4^2-\tselenate\tBO3^3-\tborate");
        texts.add("SiO3^2-\tsilicate\tB4O7^2-\ttetraborate");
        texts.add("C4H4O6^2-\ttartrate\tSiF6^2-\thexafluorosilicate");
        texts.add("C2H3O2^-\tacetate (CH3COO^-)\tSCN^-\tthiocyanate");
        texts.add("NH4^+\tammonium\tAsO3^3-\tarsenite");
        texts.add("\t\tReO4^-\tperhennate");
        for(int i = 0; i<texts.size(); i++){
            for(int j = 0; j<4; j++){
                String str = texts.get(i).split("\t")[j];
                if(str.contains("^")){
                    int carat = str.indexOf('^');
                    str = str.substring(0, carat)
                            .replace("0","₀")
                            .replace("1","₁")
                            .replace("2","₂")
                            .replace("3","₃")
                            .replace("4","₄")
                            .replace("5","₅")
                            .replace("6","₆")
                            .replace("7","₇")
                            .replace("8","₈")
                            .replace("9","₉")
                            +str.substring(carat+1, str.length())
                            .replace("0","⁰")
                            .replace("1","¹")
                            .replace("2","²")
                            .replace("3","³")
                            .replace("4","⁴")
                            .replace("5","⁵")
                            .replace("6","⁶")
                            .replace("7","⁷")
                            .replace("8","⁸")
                            .replace("9","⁹")
                            .replace("+","⁺")
                            .replace("-","⁻");
                }
                g.drawString(str, size*(borderSize+columnWidth*j), size*(borderSize+textHeight*(3+i)));
            }
        }
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
        return "Size "+size+" Polyatomic Ion Sheet";
    }
    @Override
    public void set(String property, Object value){
        if(property.equals("size")){
            size = (int)value;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof PolyatomicIonSheet){
            return ((PolyatomicIonSheet) item).size==size;
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingInt("size", 1, 5, 3));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension(size*(borderSize*2+columnWidth*4), size*(borderSize*2+textHeight*26));
    }
    @Override
    public String getCategoryName(){
        return "Chemistry";
    }
    @Override
    public String getItemName(){
        return "Polyatomic Ion Sheet";
    }
    @Override
    public PageObject replicate(){
        return new PolyatomicIonSheet(size);
    }
}