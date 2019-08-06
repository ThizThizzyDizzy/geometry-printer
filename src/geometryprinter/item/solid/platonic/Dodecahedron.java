package geometryprinter.item.solid.platonic;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Dodecahedron extends PolyhedronNet{
    public Dodecahedron(){
        this(1);
    }
    public Dodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Dodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Dodecahedron){
            if(size==((Dodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Dodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Platonic Solids";
    }
    @Override
    public String getItemName(){
        return "Dodecahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 5, 0, 0, size);
        net.addPolygon(0, 5);
        net.addPolygon(1, 5);
        NetPart back = net.addPolygon(2, 5).addPolygon(4, 5).addPolygon(0, 5);
        net.addPolygon(3, 5);
        net.addPolygon(4, 5);
        back.addPolygon(0, 5);
        back.addPolygon(1, 5);
        back.addPolygon(3, 5);
        back.addPolygon(4, 5);
    }
}