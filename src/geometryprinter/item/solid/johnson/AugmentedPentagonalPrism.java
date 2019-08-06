package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedPentagonalPrism extends PolyhedronNet{
    public AugmentedPentagonalPrism(){
        this(1);
    }
    public AugmentedPentagonalPrism(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Pentagonal Prism";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedPentagonalPrism){
            if(size==((AugmentedPentagonalPrism) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedPentagonalPrism(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Pentagonal Prism";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 5, 0, 0, size);
        net.addPolygon(0, 4).addPolygon(3, 5);
        NetPart next = net.addPolygon(1, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3);
        net.addPolygon(2, 4);
        net.addPolygon(3, 4);
        net.addPolygon(4, 4);
    }
}