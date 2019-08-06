package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class TruncatedOctahedron extends PolyhedronNet{
    public TruncatedOctahedron(){
        this(1);
    }
    public TruncatedOctahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Truncated Octahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof TruncatedOctahedron){
            if(size==((TruncatedOctahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new TruncatedOctahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Truncated Octahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-30, 6, 0, 0, size);
        net.addPolygon(0, 6);
        NetPart next = net.addPolygon(2, 6);
        next.addPolygon(3, 4);
        next.addPolygon(4, 6).addPolygon(1, 4);
        net.addPolygon(3, 4);
        next = net.addPolygon(4, 6);
        next.addPolygon(1, 4);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(3, 4);
        next.addPolygon(4, 6).addPolygon(1, 4);
    }
}