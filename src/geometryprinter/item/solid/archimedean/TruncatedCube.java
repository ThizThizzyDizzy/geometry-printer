package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class TruncatedCube extends PolyhedronNet{
    public TruncatedCube(){
        this(1);
    }
    public TruncatedCube(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Truncated Cube";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof TruncatedCube){
            if(size==((TruncatedCube) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new TruncatedCube(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Truncated Cube";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-22.5, 8, 0, 0, size);
        net.addPolygon(0, 8);
        net.addPolygon(1, 3);
        net.addPolygon(3, 3);
        net.addPolygon(4, 8);
        net.addPolygon(5, 3);
        net.addPolygon(6, 8);
        net.addPolygon(7, 3);
        NetPart next = net.addPolygon(2, 8);
        next.addPolygon(0, 3);
        next.addPolygon(6, 3);
        next = next.addPolygon(7, 8);
        next.addPolygon(0, 3);
        next.addPolygon(6, 3);
    }
}