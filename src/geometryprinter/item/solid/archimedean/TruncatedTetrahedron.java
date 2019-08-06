package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class TruncatedTetrahedron extends PolyhedronNet{
    public TruncatedTetrahedron(){
        this(1);
    }
    public TruncatedTetrahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Truncated Tetrahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof TruncatedTetrahedron){
            if(size==((TruncatedTetrahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new TruncatedTetrahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Truncated Tetrahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-30, 6, 0, 0, size);
        net.addPolygon(0, 6);
        net.addPolygon(1, 3);
        net.addPolygon(2, 6);
        net.addPolygon(3, 3);
        net.addPolygon(4, 6).addPolygon(5, 3);
        net.addPolygon(5, 3);
    }
}