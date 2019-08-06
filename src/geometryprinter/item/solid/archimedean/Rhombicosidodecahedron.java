package geometryprinter.item.solid.archimedean;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Rhombicosidodecahedron extends PolyhedronNet{
    public Rhombicosidodecahedron(){
        this(1);
    }
    public Rhombicosidodecahedron(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Rhombicosidodecahedron";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Rhombicosidodecahedron){
            if(size==((Rhombicosidodecahedron) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Rhombicosidodecahedron(size);
    }
    @Override
    public String getCategoryName(){
        return "Archimedean Solids";
    }
    @Override
    public String getItemName(){
        return "Rhombicosidodecahedron";
    }
    @Override
    protected void buildNet(){
        //left side
        net = new NetPart(0, 5, 0, 0, size);
        for(int i = 0; i<5; i++){
            NetPart next = net.addPolygon(i, 4);
            next.addPolygon(0, 3);
            next = next.addPolygon(3, 5);
            next.addPolygon(1, 4);
            next = next.addPolygon(0, 4);
            next.addPolygon(0, 3);
            next = next.addPolygon(3, 5);
            next.addPolygon(0, 4).addPolygon(0, 3);
            next.addPolygon(1, 4);
            if(i==0){
                next = next.addPolygon(4, 4);
                next.addPolygon(0, 3);
                next.addPolygon(3, 5);
            }else{
                next.addPolygon(4, 4).addPolygon(0, 3);
            }
        }
    }
}