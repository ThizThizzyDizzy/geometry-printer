package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedSquarePyramid extends PolyhedronNet{
    public ElongatedSquarePyramid(){
        this(1);
    }
    public ElongatedSquarePyramid(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Square Pyramid";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedSquarePyramid){
            if(size==((ElongatedSquarePyramid) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedSquarePyramid(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Square Pyramid";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        net.addPolygon(0, 3);
        NetPart next = net.addPolygon(1, 4);
        next.addPolygon(0, 4);
        next.addPolygon(1, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(2, 3);
        next.addPolygon(3, 4).addPolygon(2, 3);
    }
}