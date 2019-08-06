package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedPentagonalPyramid extends PolyhedronNet{
    public ElongatedPentagonalPyramid(){
        this(1);
    }
    public ElongatedPentagonalPyramid(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Pentagonal Pyramid";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedPentagonalPyramid){
            if(size==((ElongatedPentagonalPyramid) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedPentagonalPyramid(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Pentagonal Pyramid";
    }
    @Override
    protected void buildNet(){
        net = new NetPart(-45, 4, 0, 0, size);
        net.addPolygon(2, 5);
        net.addPolygon(0, 3);
        NetPart next = net.addPolygon(1, 4);
        next.addPolygon(2, 3);
        next.addPolygon(3, 4).addPolygon(2, 3);
        next = net.addPolygon(3, 4);
        next.addPolygon(0, 3);
        next.addPolygon(3, 4).addPolygon(0, 3);
    }
}