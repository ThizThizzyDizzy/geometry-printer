package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedTruncatedTetrahedron extends PolyhedronNet{
    public AugmentedTruncatedTetrahedron(){
        this(1);
    }
    public AugmentedTruncatedTetrahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Truncated Tetrahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedTruncatedTetrahedron){
            if(size==((AugmentedTruncatedTetrahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedTruncatedTetrahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Truncated Tetrahedron";
    }
    @Override
    protected void buildNet(){
        //left center
        net = new NetPart(-30, 6, 0, 0, size);
        net.addPolygon(0, 3).addPolygon(2, 4);
        net.addPolygon(1, 3);
        NetPart next = net.addPolygon(2, 6);
        next.addPolygon(1, 3);
        next.addPolygon(4, 3).addPolygon(2, 4).addPolygon(0, 3);
        next.addPolygon(5, 3);
        net.addPolygon(4, 6).addPolygon(0, 3).addPolygon(2, 4);
    }
}