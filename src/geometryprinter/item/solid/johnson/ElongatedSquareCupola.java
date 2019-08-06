package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedSquareCupola extends PolyhedronNet{
    public ElongatedSquareCupola(){
        this(1);
    }
    public ElongatedSquareCupola(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Square Cupola";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedSquareCupola){
            if(size==((ElongatedSquareCupola) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedSquareCupola(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Square Cupola";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 4).addPolygon(3, 4).addPolygon(3, 4);
        next.addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
        next.addPolygon(0, 8);
        next = next.addPolygon(2, 4);
        next.addPolygon(0, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 4).addPolygon(2, 3);
        next.addPolygon(2, 4).addPolygon(2, 3);
        next.addPolygon(3, 4).addPolygon(2, 3);
    }
}