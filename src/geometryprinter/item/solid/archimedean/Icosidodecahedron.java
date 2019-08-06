package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Icosidodecahedron extends PolyhedronNet{
    public Icosidodecahedron(){
        this(1);
    }
    public Icosidodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Icosidodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Icosidodecahedron){
            if(size==((Icosidodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Icosidodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Icosidodecahedron";
    }
    @Override
    protected void buildNet(){
        //left side
        net = new NetPart(0, 5, 0, 0, size);
        NetPart right = net.addPolygon(0, 3).addPolygon(0, 5);
        right.addPolygon(0, 3);
        right = right.addPolygon(4, 3).addPolygon(0, 5).addPolygon(4, 3).addPolygon(2, 5);
        right.addPolygon(0, 3).addPolygon(0, 5).addPolygon(0, 3);
        right.addPolygon(1, 3).addPolygon(0, 5).addPolygon(0, 3);
        right.addPolygon(3, 3).addPolygon(0, 5).addPolygon(0, 3);
        right.addPolygon(4, 3).addPolygon(0, 5).addPolygon(0, 3);
        net.addPolygon(1, 3).addPolygon(0, 5).addPolygon(0, 3);
        net.addPolygon(2, 3).addPolygon(0, 5).addPolygon(0, 3);
        net.addPolygon(3, 3).addPolygon(0, 5).addPolygon(0, 3);
        net.addPolygon(4, 3).addPolygon(0, 5).addPolygon(0, 3);
    }
}