package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Rhombicuboctahedron extends PolyhedronNet{
    public Rhombicuboctahedron(){
        this(1);
    }
    public Rhombicuboctahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Rhombicuboctahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Rhombicuboctahedron){
            if(size==((Rhombicuboctahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Rhombicuboctahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Rhombicuboctahedron";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        net.addPolygon(0, 4).addPolygon(3, 4);
        net.addPolygon(2, 4).addPolygon(3, 4);
        NetPart next = net.addPolygon(1, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 4);
        next.addPolygon(2, 4);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = net.addPolygon(3, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 4);
        next.addPolygon(2, 4);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 4);
        next.addPolygon(2, 4);
    }
}