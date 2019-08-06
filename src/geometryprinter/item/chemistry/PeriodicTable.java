package geometryprinter.item.chemistry;
import geometryprinter.Page;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingBoolean;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class PeriodicTable extends Item{
    //mass source: http://periodictable.com/Properties/A/AtomicMass.an.html#Protactinium.AtomicMass.note, 1/25/2019 around 9 AM
    //oxidation state source: that other one
    private static final int roundMass = 3;//round all mass values to this many decimals
    private static final ArrayList<Element> elements = new ArrayList<>();
    static{
        element("Hydrogen", "H").setMass(1.00794).setOxidationStates("1,-1");
        element("Helium", "He").setMass(4.002602);
        element("Lithium", "Li").setMass(6.941).setOxidationStates("1");
        element("Beryllium", "Be").setMass(9.0121831).setOxidationStates("2");
        element("Boron", "B").setMass(10.81).setOxidationStates("3");
        element("Carbon", "C").setMass(12.011).setOxidationStates("+-4,2");
        element("Nitrogen", "N").setMass(14.0067).setOxidationStates("+-3,5,4,2");
        element("Oxygen", "O").setMass(15.9994).setOxidationStates("-2,-1");
        element("Flourine", "F").setMass(18.998403163).setOxidationStates("-1");
        element("Neon", "Ne").setMass(20.1797);
        element("Sodium", "Na").setMass(22.98976928).setOxidationStates("1");
        element("Magnesium", "Mg").setMass(24.3050).setOxidationStates("2");
        element("Aluminum", "Al").setMass(26.9815385).setOxidationStates("3");
        element("Silicon", "Si").setMass(28.0855).setOxidationStates("4,2");
        element("Phosphorous", "P").setMass(30.973761998).setOxidationStates("+-3,5,4");
        element("Sulfur", "S").setMass(32.065).setOxidationStates("6,+-2,4");
        element("Chlorine", "Cl").setMass(35.453).setOxidationStates("+-1,7,5,3");
        element("Argon", "Ar").setMass(39.948);
        element("Potassium", "K").setMass(39.0983).setOxidationStates("1");
        element("Calcium", "Ca").setMass(40.078).setOxidationStates("2");
        element("Scandium", "Sc").setMass(44.955908).setOxidationStates("3");
        element("Titanium", "Ti").setMass(47.867).setOxidationStates("4,3,2");
        element("Vanadium", "V").setMass(50.9415).setOxidationStates("5,4,3,2");
        element("Chromium", "Cr").setMass(51.9961).setOxidationStates("3,6,2");
        element("Manganese", "Mn").setMass(54.938044).setOxidationStates("2,3,4,6,7");
        element("Iron", "Fe").setMass(55.845).setOxidationStates("3,2,6");
        element("Cobalt", "Co").setMass(58.933194).setOxidationStates("2,3");
        element("Nickel", "Ni").setMass(58.6934).setOxidationStates("2,3");
        element("Copper", "Cu").setMass(63.546).setOxidationStates("2,1");
        element("Zinc", "Zn").setMass(65.38).setOxidationStates("2");
        element("Gallium", "Ga").setMass(69.723).setOxidationStates("1,3");
        element("Germanium", "Ge").setMass(72.63).setOxidationStates("4");
        element("Arsenic", "As").setMass(74.921595).setOxidationStates("+-3,5");
        element("Selenium", "Se").setMass(78.971).setOxidationStates("-2,4,6");
        element("Bromine", "Br").setMass(79.904).setOxidationStates("+-1,7,5,3");
        element("Krypton", "Kr").setMass(83.798).setOxidationStates("0,2");
        element("Rubidium", "Rb").setMass(85.4678).setOxidationStates("1");
        element("Strontium", "Sr").setMass(87.62).setOxidationStates("2");
        element("Yttrium", "Y").setMass(88.90584).setOxidationStates("3");
        element("Zirconium", "Zr").setMass(91.224).setOxidationStates("4");
        element("Niobium", "Nb").setMass(92.90637).setOxidationStates("5,3,4");
        element("Molybdenum", "Mo").setMass(95.95).setOxidationStates("6,5,4,3,2");
        element("Technetium", "Tc").setMass(97).setOxidationStates("7,5,4");
        element("Ruthenium", "Ru").setMass(101.07).setOxidationStates("2,3,4,6,8");
        element("Rhodium", "Rh").setMass(102.9055).setOxidationStates("2,3,4");
        element("Palladium", "Pd").setMass(106.42).setOxidationStates("2,4");
        element("Silver", "Ag").setMass(107.8682).setOxidationStates("1");
        element("Cadmium", "Cd").setMass(112.414).setOxidationStates("2");
        element("Indium", "In").setMass(114.818).setOxidationStates("3");
        element("Tin", "Sn").setMass(118.71).setOxidationStates("4,2");
        element("Antimony", "Sb").setMass(121.76).setOxidationStates("+-3,5");
        element("Tellurium", "Te").setMass(127.6).setOxidationStates("-2,4,6");
        element("Iodine", "I").setMass(126.90447).setOxidationStates("+-1,5,7");
        element("Xenon", "Xe").setMass(131.293).setOxidationStates("0,2,4,6,8");
        element("Caesium", "Cs").setMass(132.90545196).setOxidationStates("1");
        element("Barium", "Ba").setMass(137.327).setOxidationStates("2");
        element("Lanthanum", "La").setMass(138.90547).setOxidationStates("3");
        element("Cerium", "Ce").setMass(140.116).setOxidationStates("3,4");
        element("Praseodymium", "Pr").setMass(140.90766).setOxidationStates("3,4");
        element("Neodymium", "Nd").setMass(114.242).setOxidationStates("3");
        element("Promethium", "Pm").setMass(145).setOxidationStates("3");
        element("Samarium", "Sm").setMass(150.36).setOxidationStates("3,2");
        element("Europium", "Eu").setMass(151.964).setOxidationStates("3,2");
        element("Gadolinium", "Gd").setMass(157.25).setOxidationStates("3");
        element("Terbium", "Tb").setMass(158.92535).setOxidationStates("3,4");
        element("Dysprosium", "Dy").setMass(162.5).setOxidationStates("3");
        element("Holmium", "Ho").setMass(164.93033).setOxidationStates("3");
        element("Erbium", "Er").setMass(167.259).setOxidationStates("3");
        element("Thulium", "Tm").setMass(168.93422).setOxidationStates("3,2");
        element("Ytterbium", "Yb").setMass(173.045).setOxidationStates("3,2");
        element("Lutetium", "Lu").setMass(174.9668).setOxidationStates("3");
        element("Hafnium", "Hf").setMass(178.49).setOxidationStates("4");
        element("Tantalum", "Ta").setMass(180.94788).setOxidationStates("5,4");
        element("Tungsten", "W").setMass(183.84).setOxidationStates("6,5,4,3,2");
        element("Rhenium", "Re").setMass(186.207).setOxidationStates("7,6,5,4,3,2");
        element("Osmium", "Os").setMass(190.23).setOxidationStates("2,3,4,6,8");
        element("Iridium", "Ir").setMass(192.217).setOxidationStates("4,2,6,3");
        element("Platinum", "Pt").setMass(195.084).setOxidationStates("4,2");
        element("Gold", "Au").setMass(196.966569).setOxidationStates("3,1");
        element("Mercury", "Hg").setMass(200.592).setOxidationStates("2,1");
        element("Thallium", "Tl").setMass(204.38).setOxidationStates("3,1");
        element("Lead", "Pb").setMass(207.2).setOxidationStates("4,2");
        element("Bismuth", "Bi").setMass(208.9804).setOxidationStates("3,5");
        element("Polonium", "Po").setMass(209).setOxidationStates("4,2,6");
        element("Astatine", "At").setMass(210).setOxidationStates("+-1,3,5,7");
        element("Radon", "Rn").setMass(222).setOxidationStates("0,2");
        element("Francium", "Fr").setMass(223).setOxidationStates("1");
        element("Radium", "Ra").setMass(226).setOxidationStates("2");
        element("Actinium", "Ac").setMass(227).setOxidationStates("3");
        element("Thorium", "Th").setMass(232.0377).setOxidationStates("4");
        element("Protactinium", "Pa").setApproxMass(231.03588).setOxidationStates("5,4");
        element("Uranium", "U").setMass(238.02891).setOxidationStates("6,5,4,3,2");
        element("Neptunium", "Np").setMass(237).setOxidationStates("6,5,4,3");
        element("Plutonium", "Pu").setMass(244).setOxidationStates("6,5,4,3");
        element("Americium", "Am").setMass(243).setOxidationStates("6,5,4,3,2");
        element("Curium", "Cm").setMass(247).setOxidationStates("3");
        element("Berkelium", "Bk").setMass(247).setOxidationStates("4,3,2");
        element("Californium", "Cf").setMass(251).setOxidationStates("2,3,4");
        element("Einsteinium", "Es").setMass(252).setOxidationStates("3");
        element("Fermium", "Fm").setMass(257).setOxidationStates("3");
        element("Mendelevium", "Md").setMass(258).setOxidationStates("3");
        element("Nobelium", "No").setMass(259).setOxidationStates("2,3");
        element("Lawrencium", "Lr").setMass(262).setOxidationStates("3");
        element("Rutherfordium", "Rf").setMass(267);
        element("Dubnium", "Db").setMass(270);
        element("Seaborgium", "Sg").setMass(269);
        element("Bohrium", "Bh").setMass(270);
        element("Hassium", "Hs").setMass(270);
        element("Meitnerium", "Mt").setMass(278);
        element("Darmstadtium", "Ds").setMass(281);
        element("Roentgenium", "Rg").setMass(281);
        element("Copernicium", "Cn").setMass(285);
        element("Nihonium", "Nh").setMass(286);
        element("Flerovium", "Fl").setMass(289);
        element("Moscovium", "Mc").setMass(289);
        element("Livermorium", "Lv").setMass(293);
        element("Tennessine", "Ts").setMass(293);
        element("Oganesson", "Og").setMass(294);
    }
    public PeriodicTable(){
        this(false);
    }
    public PeriodicTable(boolean wide){
        this.wide = wide;
    }
    private static Element element(String name, String symbol){
        Element e = new Element(elements.size()+1, name, symbol);
        elements.add(e);
        return e;
    }
    private boolean wide;
    private static final boolean centerVertically = false;
    @Override
    public void draw(Graphics g, PageFormat format){
        int width = Page.pageWidth-1;
        int height = Page.pageHeight;
        int size = wide?width/32:width/18;
        int topY = centerVertically?height/2-size*5:0;
        int leftX = width/2-size*(wide?16:9);
        for(Element element : elements){
            int x = element.group-1;
            double y = element.period-1;
            if(wide&&x>=3){
                x+=14;
            }
            if(element.number>=58&&element.number<72){
                //lanthanide series
                if(!wide)y+=2.5;
                x+=element.number-57;
            }
            if(element.number>=90&&element.number<104){
                //actinide series
                if(!wide)y+=2.5;
                x+=element.number-89;
            }
            element.draw(g, leftX+size*x, (int)(topY+size*y), size);
        }
        if(!wide){
            g.drawLine(leftX+size*3-1, topY+size*5, leftX+size*3-1, (int)(topY+size*9.5));
            g.drawLine(leftX+size*3+0, topY+size*5, leftX+size*3+0, (int)(topY+size*9.5));
        }
        g.setFont(new Font("Segoe UI", Font.PLAIN, size/4));
        if(!wide){
            g.drawString("Compiled by James Dolan", leftX+size*12, topY+size);
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
        return (wide?"Wide ":"")+"Periodic Table";
    }
    @Override
    public void set(String property, Object value){
        if(property.equals("wide")){
            wide = (boolean)value;
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof PeriodicTable){
            return ((PeriodicTable) item).wide==wide;
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingBoolean("wide", false));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;
    }
    @Override
    protected Dimension getItemSize(){
        int size = wide?Page.pageWidth/32:Page.pageWidth/18;
        return new Dimension(Page.pageWidth-1, (int)((wide?size*7:size*9.5)+1));
    }
    @Override
    public String getCategoryName(){
        return "Chemistry";
    }
    @Override
    public String getItemName(){
        return "Periodic Table";
    }
    @Override
    public PageObject replicate(){
        return new PeriodicTable(wide);
    }
    private static class Element{
        private final int number;
        private final String name;
        private final String symbol;
        private final int group;
        private final int period;
        private double mass = -1;
        private String oxidations = "";
        private boolean approximateMass = false;
        public Element(int number, String name, String symbol){
            this.number = number;
            this.name = name;
            this.symbol = symbol;
            if(number<3){
                period = 1;
            }else if(number<11){
                period = 2;
            }else if(number<19){
                period = 3;
            }else if(number<37){
                period = 4;
            }else if(number<55){
                period = 5;
            }else if(number<87){
                period = 6;
            }else if(number<119){
                period = 7;
            }else{
                period = -1;
            }
            switch(number){
                case 1:
                case 3:
                case 11:
                case 19:
                case 37:
                case 55:
                case 87:
                    group = 1;
                    break;
                case 4:
                case 12:
                case 20:
                case 38:
                case 56:
                case 88:
                    group = 2;
                    break;
                case 22:
                case 40:
                case 72:
                case 104:
                    group = 4;
                    break;
                case 23:
                case 41:
                case 73:
                case 105:
                    group = 5;
                    break;
                case 24:
                case 42:
                case 74:
                case 106:
                    group = 6;
                    break;
                case 25:
                case 43:
                case 75:
                case 107:
                    group = 7;
                    break;
                case 26:
                case 44:
                case 76:
                case 108:
                    group = 8;
                    break;
                case 27:
                case 45:
                case 77:
                case 109:
                    group = 9;
                    break;
                case 28:
                case 46:
                case 78:
                case 110:
                    group = 10;
                    break;
                case 29:
                case 47:
                case 79:
                case 111:
                    group = 11;
                    break;
                case 30:
                case 48:
                case 80:
                case 112:
                    group = 12;
                    break;
                case 5:
                case 13:
                case 31:
                case 49:
                case 81:
                case 113:
                    group = 13;
                    break;
                case 6:
                case 14:
                case 32:
                case 50:
                case 82:
                case 114:
                    group = 14;
                    break;
                case 7:
                case 15:
                case 33:
                case 51:
                case 83:
                case 115:
                    group = 15;
                    break;
                case 8:
                case 16:
                case 34:
                case 52:
                case 84:
                case 116:
                    group = 16;
                    break;
                case 9:
                case 17:
                case 35:
                case 53:
                case 85:
                case 117:
                    group = 17;
                    break;
                case 2:
                case 10:
                case 18:
                case 36:
                case 54:
                case 86:
                case 118:
                    group = 18;
                    break;
                default:
                    group = 3;
                    break;
            }
        }
        private void draw(Graphics g, int x, int y, int size){
            //base everything on a standard size of 40
            g.setColor(Color.black);
            g.drawRect(x, y, size, size);
            g.setFont(new Font("Segoe UI", Font.PLAIN, size/4));
            g.drawString(number+"", x+1, y+size/5+1);
            if(mass>-1){
                g.setFont(new Font("Segoe UI", Font.PLAIN, size*6/40));
                g.drawString(approximateMass?"("+(int)mass+")":mass+"", (int)(x+size*.45), y+size*6/40);
            }
            if(oxidations!=null){
                g.setFont(new Font("Segoe UI", Font.PLAIN, size*6/40));
                g.drawString(oxidations, (int) (x+size*.4), y+size*6/40*2);
            }
            g.setFont(new Font("Segoe UI", Font.PLAIN, size*7/40));
            g.drawString(name, x+1, y+size-size*2/40-2);
            g.setFont(new Font("Segoe UI", Font.PLAIN, size/2));
            g.drawString(symbol, x+1, y+size*2/3+1);
        }
        public Element setMass(int mass){
            this.mass = mass;
            approximateMass = true;
            return this;
        }
        public Element setMass(double mass){
            this.mass = Math.round(mass*Math.pow(10, roundMass))/Math.pow(10, roundMass);
            return this;
        }
        private Element setApproxMass(double d){
            setMass(d);
            approximateMass = true;
            return this;
        }
        private Element setOxidationStates(String oxidationStates){
            oxidations = oxidationStates.replaceAll("\\Q+-", "±");
            return this;
        }
    }
    private static enum Phase{
        SOLID(Color.black),LIQUID(Color.blue),GAS(Color.red);
        private final Color color;
        private Phase(Color color){
            this.color = color;
        }
    }
}