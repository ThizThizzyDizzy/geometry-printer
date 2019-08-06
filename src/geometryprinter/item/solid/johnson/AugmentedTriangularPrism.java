package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedTriangularPrism extends PolyhedronNet{
    public AugmentedTriangularPrism(){
        this(1);
    }
    public AugmentedTriangularPrism(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Triangular Prism";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedTriangularPrism){
            if(size==((AugmentedTriangularPrism) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedTriangularPrism(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Triangular Prism";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        net.addPolygon(0, 3);
        net.addPolygon(1, 4).addPolygon(3, 3);
        net.addPolygon(2, 3);
        NetPart next = net.addPolygon(3, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
    }
}