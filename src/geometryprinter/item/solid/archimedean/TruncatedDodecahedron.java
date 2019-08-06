package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class TruncatedDodecahedron extends PolyhedronNet{
    public TruncatedDodecahedron(){
        this(1);
    }
    public TruncatedDodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Truncated Dodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof TruncatedDodecahedron){
            if(size==((TruncatedDodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new TruncatedDodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Truncated Dodecahedron";
    }
    @Override
    protected void buildNet(){
        //left
        net = new NetPart(-18, 10, 0, 0, size);
        net.addPolygon(0, 10).addPolygon(1, 3);
        net.addPolygon(1, 3);
        NetPart next = net.addPolygon(2, 10).addPolygon(0, 10);
        next.addPolygon(3,3);
        next.addPolygon(5,3);
        next = next.addPolygon(8, 10);//<--right
        next.addPolygon(0, 10).addPolygon(1, 3);
        next.addPolygon(1, 3);
        next.addPolygon(2, 10).addPolygon(1, 3);
        next.addPolygon(3, 3);
        next.addPolygon(5, 3);
        next.addPolygon(6, 10).addPolygon(1, 3);
        next.addPolygon(7, 3);
        next.addPolygon(8, 10).addPolygon(1, 3);
        next.addPolygon(9, 3);
        net.addPolygon(3, 3);
        net.addPolygon(4, 10).addPolygon(1, 3);
        net.addPolygon(5, 3);
        net.addPolygon(6, 10).addPolygon(1, 3);
        net.addPolygon(7, 3);
        net.addPolygon(8, 10).addPolygon(1, 3);
        net.addPolygon(9, 3);
    }
}