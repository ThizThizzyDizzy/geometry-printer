package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class DiminishedRhombicosidodecahedron extends PolyhedronNet{
    public DiminishedRhombicosidodecahedron(){
        this(1);
    }
    public DiminishedRhombicosidodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Diminished Rhombicosidodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof DiminishedRhombicosidodecahedron){
            if(size==((DiminishedRhombicosidodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new DiminishedRhombicosidodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Diminished Rhombicosidodecahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-18, 10, 0, 0, size);
        NetPart next = net.addPolygon(9, 5).addPolygon(0, 4).addPolygon(0, 3).addPolygon(0, 4).addPolygon(2, 5).addPolygon(4, 4).addPolygon(0, 3).addPolygon(0, 4).addPolygon(2, 5).addPolygon(4, 4);
        next.addPolygon(0, 3).addPolygon(0, 4).addPolygon(2, 5).addPolygon(4, 4).addPolygon(0, 3).addPolygon(0, 4).addPolygon(2, 5).addPolygon(4, 4).addPolygon(0, 3).addPolygon(0, 4);
        next = next.addPolygon(2, 3);
        next.addPolygon(2, 4);
        next = next.addPolygon(0, 4);
        next.addPolygon(3, 3);
        NetPart n = next.addPolygon(2, 5);
        n.addPolygon(1, 4);
        n = n.addPolygon(0, 4);
        n.addPolygon(0, 3);
        n.addPolygon(2, 3).addPolygon(0, 4);
        n.addPolygon(3, 5).addPolygon(1, 4);
        next = next.addPolygon(0, 5);
        next.addPolygon(3, 4);
        next = next.addPolygon(4, 4);
        next.addPolygon(0, 3).addPolygon(0, 4);
        next.addPolygon(2, 3);
        next = next.addPolygon(1, 5);
        next.addPolygon(3, 4);
        next = next.addPolygon(4, 4);
        next.addPolygon(0, 3).addPolygon(0, 4);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 5);
        next.addPolygon(3, 4).addPolygon(3, 5);
        next = next.addPolygon(4, 4);
        next.addPolygon(0, 3).addPolygon(0, 4);
        next.addPolygon(2, 3);
    }
}