package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Bilunabirotunda extends PolyhedronNet{
    public Bilunabirotunda(){
        this(1);
    }
    public Bilunabirotunda(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Bilunabirotunda";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Bilunabirotunda){
            if(size==((Bilunabirotunda) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Bilunabirotunda(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Bilunabirotunda";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 3);
        next.addPolygon(0, 5).addPolygon(4, 3);
        next = next.addPolygon(2, 5);
        next.addPolygon(1, 3);
        next.addPolygon(3, 3);
        next = net.addPolygon(3, 3).addPolygon(0, 5);
        next.addPolygon(4, 3);
        next = next.addPolygon(3, 3);
        next.addPolygon(0, 4);
        next.addPolygon(2, 5).addPolygon(4, 3);
    }
}