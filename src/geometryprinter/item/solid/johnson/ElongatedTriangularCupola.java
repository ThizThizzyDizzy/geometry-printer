package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedTriangularCupola extends PolyhedronNet{
    public ElongatedTriangularCupola(){
        this(1);
    }
    public ElongatedTriangularCupola(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Triangular Cupola";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedTriangularCupola){
            if(size==((ElongatedTriangularCupola) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedTriangularCupola(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Triangular Cupola";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 4).addPolygon(3, 4);
        next.addPolygon(0, 6);
        next.addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
        next = next.addPolygon(2, 4);
        next.addPolygon(0, 3);
        next = next.addPolygon(3, 3);
        next.addPolygon(0, 4).addPolygon(2, 3);
        next.addPolygon(2, 4).addPolygon(2, 3);
    }
}