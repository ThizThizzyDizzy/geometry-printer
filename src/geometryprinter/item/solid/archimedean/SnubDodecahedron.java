package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class SnubDodecahedron extends PolyhedronNet{
    public SnubDodecahedron(){
        this(1);
    }
    public SnubDodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Snub Dodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof SnubDodecahedron){
            if(size==((SnubDodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new SnubDodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Snub Dodecahedron";
    }
    @Override
    protected void buildNet(){
        //right side star thing
        net = new NetPart(0, 5, 0, 0, size);
        for(int i = 0; i<5; i++){
            if(i==3)continue;
            NetPart next = net.addPolygon(i, 3);
            next.addPolygon(0, 3);
            next = next.addPolygon(2, 3).addPolygon(0, 5);
            next.addPolygon(0, 3);
            next.addPolygon(1, 3).addPolygon(2, 3).addPolygon(2, 3);
            next.addPolygon(4, 3);
        }
        NetPart next = net.addPolygon(3, 3);
        next.addPolygon(0, 3);
        next = next.addPolygon(2, 3).addPolygon(0, 5);
        next.addPolygon(4, 3);
        next.addPolygon(1, 3).addPolygon(2, 3);
        next = next.addPolygon(0, 3);
        next.addPolygon(0, 3);
        next = next.addPolygon(2, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 5);
        next.addPolygon(1, 3);
        next.addPolygon(3, 3).addPolygon(2, 3);
        next = next.addPolygon(4, 3).addPolygon(2, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(0, 5);
        for(int i = 0; i<5; i++){
            if(i==2)continue;
            NetPart n = next.addPolygon(i, 3);
            n.addPolygon(0, 3);
            n = n.addPolygon(2, 3).addPolygon(0, 5);
            n.addPolygon(0, 3);
            n.addPolygon(1, 3).addPolygon(2, 3).addPolygon(2, 3);
            n.addPolygon(4, 3);
        }
    }
}