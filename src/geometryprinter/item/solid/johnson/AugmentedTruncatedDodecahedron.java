package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedTruncatedDodecahedron extends PolyhedronNet{
    public AugmentedTruncatedDodecahedron(){
        this(1);
    }
    public AugmentedTruncatedDodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Truncated Dodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedTruncatedDodecahedron){
            if(size==((AugmentedTruncatedDodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedTruncatedDodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Truncated Dodecahedron";
    }
    @Override
    protected void buildNet(){
        //left center
        net = new NetPart(-18, 10, 0, 0, size);
        net.addPolygon(0, 10).addPolygon(1, 3);
        net.addPolygon(1, 3);
        net.addPolygon(3, 3);
        net.addPolygon(4, 10).addPolygon(1, 3);
        net.addPolygon(5, 3);
        net.addPolygon(6, 10).addPolygon(1, 3);
        net.addPolygon(7, 3);
        net.addPolygon(8, 10).addPolygon(1, 3);
        net.addPolygon(9, 3);
        NetPart next = net.addPolygon(2, 10);
        next.addPolygon(1, 3);
        next = next.addPolygon(0, 10);
        next.addPolygon(5, 3);
        next = next.addPolygon(9, 10);//<right center
        next.addPolygon(9, 3);
        NetPart n = next.addPolygon(0, 10);
        n.addPolygon(1, 3);
        n.addPolygon(7, 3);
        next.addPolygon(1, 3);
        next.addPolygon(2, 10).addPolygon(1, 3);
        next.addPolygon(3, 3);
        next.addPolygon(4, 10).addPolygon(1, 3);
        next.addPolygon(5, 3);
        next.addPolygon(6, 10).addPolygon(1, 3);
        next.addPolygon(7, 3);
        next = next.addPolygon(8, 3).addPolygon(2, 4);
        next.addPolygon(3, 3);
        next = next.addPolygon(0, 5);
        next.addPolygon(0, 4).addPolygon(2, 3);
        next.addPolygon(1, 4).addPolygon(2, 3);
        next.addPolygon(3, 4);
        next.addPolygon(4, 4).addPolygon(2, 3);
    }
}