package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedSquareBipyramid extends PolyhedronNet{
    public ElongatedSquareBipyramid(){
        this(1);
    }
    public ElongatedSquareBipyramid(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Square Bipyramid";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedSquareBipyramid){
            if(size==((ElongatedSquareBipyramid) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedSquareBipyramid(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Square Bipyramid";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        net.addPolygon(0, 3);
        net.addPolygon(2, 3);
        NetPart next = net.addPolygon(1, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
    }
}