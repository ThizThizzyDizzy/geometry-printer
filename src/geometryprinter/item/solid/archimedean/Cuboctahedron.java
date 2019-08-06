package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Cuboctahedron extends PolyhedronNet{
    public Cuboctahedron(){
        this(1);
    }
    public Cuboctahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Cuboctahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Cuboctahedron){
            if(size==((Cuboctahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Cuboctahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Cuboctahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 3, 0, 0, size);
        NetPart bottom = net.addPolygon(1, 4);
        bottom.addPolygon(0, 3);
        bottom.addPolygon(2, 3);
        net.addPolygon(0, 4).addPolygon(3, 3).addPolygon(0, 4).addPolygon(3, 3);
        NetPart next = net.addPolygon(2, 4).addPolygon(3, 3);
        next.addPolygon(2, 4);
        next = next.addPolygon(0, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
    }
}