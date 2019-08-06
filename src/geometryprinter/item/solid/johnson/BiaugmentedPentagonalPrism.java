package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class BiaugmentedPentagonalPrism extends PolyhedronNet{
    public BiaugmentedPentagonalPrism(){
        this(1);
    }
    public BiaugmentedPentagonalPrism(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Biaugmented Pentagonal Prism";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof BiaugmentedPentagonalPrism){
            if(size==((BiaugmentedPentagonalPrism) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new BiaugmentedPentagonalPrism(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Biaugmented Pentagonal Prism";
    }
    @Override
    protected void buildNet(){
        //left center
        net = new NetPart(0, 5, 0, 0, size);
        net.addPolygon(0, 4).addPolygon(3, 5);
        NetPart next = net.addPolygon(1, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3);
        net.addPolygon(2, 4);
        net.addPolygon(3, 4);
        next = net.addPolygon(4, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3);
    }
}