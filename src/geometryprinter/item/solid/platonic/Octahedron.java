package geometryprinter.item.solid.platonic;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Octahedron extends PolyhedronNet{
    public Octahedron(){
        this(1);
    }
    public Octahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Octahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Octahedron){
            if(size==((Octahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Octahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Platonic Solids";
    }
    @Override
    public String getItemName(){
        return "Octahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(90, 3, 0, 0, size);
        net.addPolygon(0, 3);
        NetPart back = net.addPolygon(1, 3);
        back.addPolygon(0, 3).addPolygon(2, 3);
        back.addPolygon(2, 3);
        net.addPolygon(2, 3).addPolygon(0, 3);
    }
}