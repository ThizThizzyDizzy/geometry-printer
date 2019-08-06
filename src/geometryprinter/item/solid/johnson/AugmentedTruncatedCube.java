package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedTruncatedCube extends PolyhedronNet{
    public AugmentedTruncatedCube(){
        this(1);
    }
    public AugmentedTruncatedCube(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Truncated Cube";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedTruncatedCube){
            if(size==((AugmentedTruncatedCube) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedTruncatedCube(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Truncated Cube";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(22.5, 8, 0, 0, size);
        NetPart next = net.addPolygon(0, 3).addPolygon(2, 4).addPolygon(0, 4);
        next.addPolygon(0, 4).addPolygon(2, 3);
        next.addPolygon(2, 4).addPolygon(2, 3);
        next.addPolygon(3, 4).addPolygon(2, 3);
        net.addPolygon(1, 3);
        next = net.addPolygon(2, 8);
        next.addPolygon(0, 3);
        next.addPolygon(6, 3);
        next = next.addPolygon(7, 8);
        next.addPolygon(0, 3);
        next.addPolygon(6, 3);
        net.addPolygon(3, 3);
        net.addPolygon(4, 8);
        net.addPolygon(5, 3);
        net.addPolygon(6, 8);
        net.addPolygon(7, 3);
    }
}