package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedTridiminishedIcosahedron extends PolyhedronNet{
    public AugmentedTridiminishedIcosahedron(){
        this(1);
    }
    public AugmentedTridiminishedIcosahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Tridiminished Icosahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedTridiminishedIcosahedron){
            if(size==((AugmentedTridiminishedIcosahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedTridiminishedIcosahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Tridiminished Icosahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 5, 0, 0, size);
        NetPart next = net.addPolygon(0, 5);
        next.addPolygon(1, 3);
        next.addPolygon(4, 3);
        next.addPolygon(1, 3);
        next.addPolygon(2, 5).addPolygon(3, 3);
        next.addPolygon(3, 3).addPolygon(0, 3);
        next.addPolygon(4, 3);
    }
}