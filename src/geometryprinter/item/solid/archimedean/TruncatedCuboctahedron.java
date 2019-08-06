package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class TruncatedCuboctahedron extends PolyhedronNet{
    public TruncatedCuboctahedron(){
        this(1);
    }
    public TruncatedCuboctahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Truncated Cuboctahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof TruncatedCuboctahedron){
            if(size==((TruncatedCuboctahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new TruncatedCuboctahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Truncated Cuboctahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-22.5, 8, 0, 0, size);
        net.addPolygon(0, 4).addPolygon(3, 8);
        net.addPolygon(4, 4).addPolygon(3, 8);
        NetPart next = net.addPolygon(2, 4);
        next.addPolygon(0, 6);
        next.addPolygon(2, 6);
        next = next.addPolygon(3, 8);
        next.addPolygon(1, 4);
        next.addPolygon(5, 4);
        next = next.addPolygon(7, 4);
        next.addPolygon(0, 6);
        next.addPolygon(2, 6);
        next = next.addPolygon(3, 8);
        next.addPolygon(1, 4);
        next.addPolygon(5, 4);
        next = net.addPolygon(6, 4);
        next.addPolygon(0, 6);
        next.addPolygon(2, 6);
        next = next.addPolygon(3, 8);
        next.addPolygon(1, 4);
        next.addPolygon(5, 4);
        next = next.addPolygon(7, 4);
        next.addPolygon(0, 6);
        next.addPolygon(2, 6);
    }
}