package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class SnubCube extends PolyhedronNet{
    public SnubCube(){
        this(1);
    }
    public SnubCube(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Snub Cube";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof SnubCube){
            if(size==((SnubCube) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new SnubCube(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Snub Cube";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(0, 3).addPolygon(0, 3).addPolygon(2, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next.addPolygon(3, 3);
        next = net.addPolygon(1, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0, 3);
        next = next.addPolygon(2, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0, 3);
        next = next.addPolygon(2, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next.addPolygon(3, 3).addPolygon(2, 3);
        next = net.addPolygon(2, 3).addPolygon(0, 3).addPolygon(2, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next.addPolygon(3, 3);
        next = net.addPolygon(3, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0, 3);
        next = next.addPolygon(2, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next.addPolygon(3, 3).addPolygon(2, 3);
    }
}