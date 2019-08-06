package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class BigyrateDiminishedRhombicosidodecahedron extends PolyhedronNet{
    public BigyrateDiminishedRhombicosidodecahedron(){
        this(1);
    }
    public BigyrateDiminishedRhombicosidodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Bigyrate Diminished Rhombicosidodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof BigyrateDiminishedRhombicosidodecahedron){
            if(size==((BigyrateDiminishedRhombicosidodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new BigyrateDiminishedRhombicosidodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Bigyrate Diminished Rhombicosidodecahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(0, 10, 0, 0, size);
        net.addPolygon(2, 4);
        NetPart next = net.addPolygon(4, 4);
        next.addPolygon(2, 5);
        next.addPolygon(3, 3).addPolygon(2, 4).addPolygon(0, 5);
        net.addPolygon(7, 5);
        net.addPolygon(8, 4);
        next = net.addPolygon(6, 4).addPolygon(3, 4);
        next.addPolygon(2, 3).addPolygon(2, 5);
        next = next.addPolygon(0, 3).addPolygon(2, 4);
        NetPart n = next.addPolygon(0, 4);
        n.addPolygon(2, 5);
        n.addPolygon(3, 3).addPolygon(2, 4);
        next = next.addPolygon(3, 3).addPolygon(2, 4);
        n = next.addPolygon(3, 3).addPolygon(2, 4);
        n.addPolygon(2, 5);
        n.addPolygon(3, 3).addPolygon(2, 4).addPolygon(0, 4);
        next = next.addPolygon(0, 4).addPolygon(3, 4);
        n = next.addPolygon(0, 3).addPolygon(2, 4);
        n.addPolygon(2, 5);
        n = n.addPolygon(3, 3);
        n.addPolygon(0, 5);
        n.addPolygon(2, 4).addPolygon(0, 4);
        next = next.addPolygon(2, 3).addPolygon(0, 4);
        n = next.addPolygon(2, 4);
        n.addPolygon(2, 5);
        n.addPolygon(3, 3).addPolygon(2, 4);
        next = next.addPolygon(3, 3).addPolygon(0, 4);
        next.addPolygon(3, 3).addPolygon(2, 5);
        next = next.addPolygon(2, 4).addPolygon(3, 3).addPolygon(2, 4);
        next.addPolygon(2, 5);
        next.addPolygon(3, 3).addPolygon(2, 4);
    }
}