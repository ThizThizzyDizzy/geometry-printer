package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedPentagonalRotunda extends PolyhedronNet{
    public ElongatedPentagonalRotunda(){
        this(1);
    }
    public ElongatedPentagonalRotunda(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Pentagonal Rotunda";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedPentagonalRotunda){
            if(size==((ElongatedPentagonalRotunda) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedPentagonalRotunda(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Pentagonal Rotunda";
    }
    @Override
    protected void buildNet(){
        //far left square
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
        next.addPolygon(0, 10);
        next.addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
        next = next.addPolygon(2, 5);
        next.addPolygon(1, 3);
        next = next.addPolygon(0, 3).addPolygon(2, 5);
        next.addPolygon(0, 3).addPolygon(0, 5).addPolygon(3, 3);
        next.addPolygon(1, 3).addPolygon(0, 5).addPolygon(3, 3);
        next.addPolygon(3, 3).addPolygon(0, 5).addPolygon(3, 3);
        next.addPolygon(4, 3).addPolygon(0, 5).addPolygon(3, 3);
    }
}