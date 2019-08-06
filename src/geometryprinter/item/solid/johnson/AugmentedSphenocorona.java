package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class AugmentedSphenocorona extends PolyhedronNet{
    public AugmentedSphenocorona(){
        this(1);
    }
    public AugmentedSphenocorona(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Augmented Sphenocorona";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof AugmentedSphenocorona){
            if(size==((AugmentedSphenocorona) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new AugmentedSphenocorona(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Augmented Sphenocorona";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        net.addPolygon(0, 3).addPolygon(2, 3);
        NetPart next = net.addPolygon(1, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3);
        net.addPolygon(2, 3).addPolygon(0, 3);
        next = net.addPolygon(3, 3).addPolygon(0, 3).addPolygon(2, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3);
    }
}