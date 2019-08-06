package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedSquareGyrobicupola extends PolyhedronNet{
    public ElongatedSquareGyrobicupola(){
        this(1);
    }
    public ElongatedSquareGyrobicupola(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Square Gyrobicupola";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedSquareGyrobicupola){
            if(size==((ElongatedSquareGyrobicupola) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedSquareGyrobicupola(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Square Gyrobicupola";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 4).addPolygon(3, 4).addPolygon(3, 4);
        next.addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
        NetPart n = next.addPolygon(0, 3).addPolygon(2, 4).addPolygon(0, 4);
        n.addPolygon(0, 4).addPolygon(2, 3);
        n.addPolygon(2, 4).addPolygon(2, 3);
        n.addPolygon(3, 4).addPolygon(2, 3);
        n = next.addPolygon(2, 4);
        n.addPolygon(0, 3);
        n = n.addPolygon(3, 4);
        n.addPolygon(0, 4).addPolygon(2, 3);
        n.addPolygon(2, 4).addPolygon(2, 3);
        n.addPolygon(3, 4).addPolygon(2, 3);
    }
}