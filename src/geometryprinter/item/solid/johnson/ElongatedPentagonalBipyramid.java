package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedPentagonalBipyramid extends PolyhedronNet{
    public ElongatedPentagonalBipyramid(){
        this(1);
    }
    public ElongatedPentagonalBipyramid(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Pentagonal Bipyramid";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedPentagonalBipyramid){
            if(size==((ElongatedPentagonalBipyramid) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedPentagonalBipyramid(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Pentagonal Bipyramid";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 3);
        next.addPolygon(2, 3);
        next.addPolygon(0, 3).addPolygon(2, 3).addPolygon(2, 3);
        next = net.addPolygon(2, 3);
        NetPart n = next.addPolygon(0, 3);
        n.addPolygon(0, 3);
        n.addPolygon(2, 3).addPolygon(0, 4);
        n = next.addPolygon(2, 3);
        n.addPolygon(0, 3).addPolygon(2, 4);
        n.addPolygon(2, 4);
    }
}