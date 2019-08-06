package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedPentagonalCupola extends PolyhedronNet{
    public ElongatedPentagonalCupola(){
        this(1);
    }
    public ElongatedPentagonalCupola(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Pentagonal Cupola";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedPentagonalCupola){
            if(size==((ElongatedPentagonalCupola) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedPentagonalCupola(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Pentagonal Cupola";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-18, 10, 0, 0, size);
        NetPart next = net.addPolygon(0, 4).addPolygon(3, 4);
        next.addPolygon(0, 3);
        next = next.addPolygon(3, 5);
        next.addPolygon(0, 4).addPolygon(2, 3);
        next.addPolygon(1, 4).addPolygon(2, 3);
        next.addPolygon(3, 4).addPolygon(2, 3);
        next.addPolygon(4, 4).addPolygon(2, 3);
        net.addPolygon(1, 4);
        net.addPolygon(2, 4);
        net.addPolygon(3, 4);
        net.addPolygon(4, 4);
        net.addPolygon(5, 4);
        net.addPolygon(6, 4);
        net.addPolygon(7, 4);
        net.addPolygon(8, 4);
        net.addPolygon(9, 4);
    }
}