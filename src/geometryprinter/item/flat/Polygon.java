package geometryprinter.item.flat;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.Setting;
import geometryprinter.item.SettingInt;
import geometryprinter.item.SettingLength;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.util.ArrayList;
public class Polygon extends Item{
    private static final boolean drawTriangles = false;
    private int sides, radius;
    public Polygon(){
        this(5, 1);
    }
    public Polygon(int sides, int radius){
        this.sides = sides;
        this.radius = radius;
    }
    public Polygon(int sides, int value, boolean sideLength){
        this(sides, sideLength?((int)((1/Math.cos(Math.toRadians(90-(180/sides))))*(value/2d))):value);
    }
    @Override
    public void draw(Graphics g, PageFormat format){
        if(sides<3){
            return;
        }
        double angle = 0;
        int x = radius;
        int y = radius;
        int[] vert1, vert2, vert3;
        for(int i = 0; i<sides; i++){
            vert1 = new int[]{x,y};
            int X = (int)Math.round(x+Math.cos(Math.toRadians(angle-90))*radius);
            int Y = (int)Math.round(y+Math.sin(Math.toRadians(angle-90))*radius);
            vert2 = new int[]{X,Y};
            angle+=(360D/sides);
            X = (int)Math.round(x+Math.cos(Math.toRadians(angle-90))*radius);
            Y = (int)Math.round(y+Math.sin(Math.toRadians(angle-90))*radius);
            vert3 = new int[]{X,Y};
            if(drawTriangles){
                g.drawLine(vert1[0], vert1[1], vert2[0], vert2[1]);
                g.drawLine(vert3[0], vert3[1], vert1[0], vert1[1]);
            }
            g.drawLine(vert2[0], vert2[1], vert3[0], vert3[1]);
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
        String size = radius*2+" pixel";
        if(sides<3){
            return size+" Impossible "+sides+"-gon";
        }
        switch(sides){
            case 3:
                return size+" Equilateral Triangle";
            case 4:
                return size+" Square";
            case 5:
                return size+" Pentagon";
            case 6:
                return size+" Hexagon";
            case 7:
                return size+" Heptagon";
            case 8:
                return size+" Octagon";
            case 9:
                return size+" Nonagon";
            case 10:
                return size+" Decagon";
            case 11:
                return size+" Hendecagon";
            case 12:
                return size+" Dodecagon";
            case 13:
                return size+" Tridecagon";
            case 14:
                return size+" Tetradecagon";
            case 15:
                return size+" Pentadecagon";
            case 16:
                return size+" Hexadecagon";
            case 17:
                return size+" Heptadecagon";
            case 18:
                return size+" Octadecagon";
            case 19:
                return size+" Enneadecagon";
            case 20:
                return size+" Icosagon";
            case 50:
                return size+" Pentadecaduodecahexaoctanonagon";
            default:
                return size+" "+sides+"-gon";
        }
    }
    @Override
    public void set(String property, Object value){
        switch(property.toLowerCase()){
            case "sides":
                sides = (int)value;
                break;
            case "radius":
                radius = (int)value;
                break;
            case "side length":
            case "sidelength":
            case "length":
                radius = (int)((1/Math.cos(Math.toRadians(90-(180/sides))))*((int)value/2d));
        }
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Polygon){
            if(sides==((Polygon) item).sides&&radius==((Polygon) item).radius){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList<Setting> getSettings(){
        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new SettingInt("Sides", 3, 20));
        settings.add(new SettingLength("Side Length"));
        return settings;
    }
    @Override
    public boolean canSplit(){
        return false;
    }
    @Override
    protected Dimension getItemSize(){
        return new Dimension(radius*2+1, radius*2+1);
    }
    @Override
    public PageObject replicate(){
        return new Polygon(sides, radius);
    }
    @Override
    public String getCategoryName(){
        return "Flat";
    }
    @Override
    public String getItemName(){
        return "Polygon";
    }
}