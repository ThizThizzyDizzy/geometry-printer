package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedDodecahedron extends PolyhedronNet{
    public AugmentedDodecahedron(){
        this(1);
    }
    public AugmentedDodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Dodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedDodecahedron){
            if(size==((AugmentedDodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedDodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Dodecahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 5, 0, 0, size);
        net.addPolygon(0, 5);
        NetPart next = net.addPolygon(1, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3).addPolygon(0, 3);
        net.addPolygon(2, 5);
        net.addPolygon(4, 5);
        next = net.addPolygon(3, 5).addPolygon(0, 5).addPolygon(4, 5);
        next.addPolygon(0, 5);
        next.addPolygon(1, 5);
        next.addPolygon(3, 5);
        next.addPolygon(4, 5);
    }
}