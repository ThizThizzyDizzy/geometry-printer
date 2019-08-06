package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class TruncatedIcosahedron extends PolyhedronNet{
    public TruncatedIcosahedron(){
        this(1);
    }
    public TruncatedIcosahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Truncated Icosahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof TruncatedIcosahedron){
            if(size==((TruncatedIcosahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new TruncatedIcosahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Truncated Icosahedron";
    }
    @Override
    protected void buildNet(){
        //far left central hexagon
        net = new NetPart(-30, 6, 0, 0, size);
        net.addPolygon(0, 5);
        net.addPolygon(3, 6);
        NetPart next = net.addPolygon(1, 6);
        next.addPolygon(1, 5);
        next.addPolygon(4, 6).addPolygon(5, 5);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6).addPolygon(5, 5);
        next.addPolygon(3, 5);
        next = next.addPolygon(4, 6);
        next.addPolygon(1, 5);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6);
        next.addPolygon(3, 5);
        next = next.addPolygon(4, 6);
        next.addPolygon(1, 5);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6);
        next.addPolygon(3, 5);
        next = next.addPolygon(4, 6);
        next.addPolygon(1, 5);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6);
        next.addPolygon(3, 5);
        next = next.addPolygon(4, 6);
        next.addPolygon(1, 5);
        next.addPolygon(4, 6);
    }
}