package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedHexagonalPrism extends PolyhedronNet{
    public AugmentedHexagonalPrism(){
        this(1);
    }
    public AugmentedHexagonalPrism(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Hexagonal Prism";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedHexagonalPrism){
            if(size==((AugmentedHexagonalPrism) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedHexagonalPrism(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Hexagonal Prism";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 6, 0, 0, size);
        net.addPolygon(0, 4);
        net.addPolygon(1, 4).addPolygon(3, 6);
        NetPart next = net.addPolygon(2, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3);
        net.addPolygon(3, 4);
        net.addPolygon(4, 4);
        net.addPolygon(5, 4);
    }
}