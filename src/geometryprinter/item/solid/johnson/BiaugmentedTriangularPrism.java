package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class BiaugmentedTriangularPrism extends PolyhedronNet{
    public BiaugmentedTriangularPrism(){
        this(1);
    }
    public BiaugmentedTriangularPrism(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Biaugmented Triangular Prism";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof BiaugmentedTriangularPrism){
            if(size==((BiaugmentedTriangularPrism) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new BiaugmentedTriangularPrism(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Biaugmented Triangular Prism";
    }
    @Override
    protected void buildNet(){
        //left center
        net = new NetPart(-45, 4, 0, 0, size);
        net.addPolygon(0, 3);
        NetPart next = net.addPolygon(1, 3);
        next.addPolygon(2, 3);
        next.addPolygon(0, 3).addPolygon(2, 3);
        net.addPolygon(2, 3);
        next = net.addPolygon(3, 3);
        next.addPolygon(2, 3);
        next.addPolygon(0, 3).addPolygon(2, 3);
    }
}