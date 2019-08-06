package geometryprinter.item.solid.platonic;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Icosahedron extends PolyhedronNet{
    public Icosahedron(){
        this(1);
    }
    public Icosahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Icosahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Icosahedron){
            if(size==((Icosahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Icosahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Platonic Solids";
    }
    @Override
    public String getItemName(){
        return "Icosahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 3, 0, 0, size);//far left
        net.addPolygon(1, 3);
        NetPart next = net.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0,3);
        next = next.addPolygon(2, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0,3);
        next = next.addPolygon(2, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0,3);
        next = next.addPolygon(2, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0,3);
        next = next.addPolygon(2, 3);
        next.addPolygon(2, 3);
    }
}