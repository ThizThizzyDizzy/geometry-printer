package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class TruncatedIcosidodecahedron extends PolyhedronNet{
    public TruncatedIcosidodecahedron(){
        this(1);
    }
    public TruncatedIcosidodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Truncated Icosidodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof TruncatedIcosidodecahedron){
            if(size==((TruncatedIcosidodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new TruncatedIcosidodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Truncated Icosidodecahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-18, 10, 0, 0, size);
        net.addPolygon(0, 4);
        NetPart next = net.addPolygon(1, 6);
        next.addPolygon(5, 4);
        next = next.addPolygon(4, 10);
        next.addPolygon(0, 6).addPolygon(5, 4);
        next.addPolygon(1, 4);
        next.addPolygon(8, 4);
        net.addPolygon(2, 4);
        next = net.addPolygon(3, 6);
        next.addPolygon(5, 4);
        next = next.addPolygon(4, 10);
        next.addPolygon(1, 4);
        next.addPolygon(8, 6);
        next.addPolygon(9, 4);
        next = next.addPolygon(0, 6);
        next.addPolygon(4, 10).addPolygon(1, 4);
        next.addPolygon(5, 4);
        net.addPolygon(4, 4);
        next = net.addPolygon(5, 6);
        next.addPolygon(5, 4);
        next = next.addPolygon(4, 10);
        next.addPolygon(1, 4);
        next.addPolygon(8, 6);
        next.addPolygon(9, 4);
        next = next.addPolygon(0, 6);
        next.addPolygon(5, 4);
        next = next.addPolygon(4, 10);
        next.addPolygon(0, 6);
        next.addPolygon(1, 4);
        net.addPolygon(6, 4);
        NetPart n = net.addPolygon(7, 6);
        next = n.addPolygon(4, 10);
        next.addPolygon(1, 4);
        next.addPolygon(8, 6);
        next.addPolygon(9, 4);
        next = next.addPolygon(0, 6);
        next.addPolygon(5, 4);
        next = next.addPolygon(4, 10);
        next.addPolygon(0, 6);
        next.addPolygon(1, 4);
        n.addPolygon(5, 4);
        n = n.addPolygon(0, 10);
        next = n.addPolygon(0, 6);
        next = next.addPolygon(4, 10);
        next.addPolygon(0, 6);
        next.addPolygon(9, 4);
        next = n.addPolygon(6, 6).addPolygon(0, 10);
        next.addPolygon(0, 6).addPolygon(4, 10);
        next.addPolygon(9, 4);
        next.addPolygon(8, 6);
        n.addPolygon(7, 4);
        n.addPolygon(8, 6).addPolygon(5, 4);
        n.addPolygon(9, 4);
        
    }
}