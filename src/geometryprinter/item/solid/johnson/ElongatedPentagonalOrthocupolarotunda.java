package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedPentagonalOrthocupolarotunda extends PolyhedronNet{
    public ElongatedPentagonalOrthocupolarotunda(){
        this(1);
    }
    public ElongatedPentagonalOrthocupolarotunda(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Pentagonal Orthocupolarotunda";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedPentagonalOrthocupolarotunda){
            if(size==((ElongatedPentagonalOrthocupolarotunda) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedPentagonalOrthocupolarotunda(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Pentagonal Orthocupolarotunda";
    }
    @Override
    protected void buildNet(){
        //far left square
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
        NetPart n = next.addPolygon(0, 5);
        n.addPolygon(1, 3);
        n = n.addPolygon(0, 3).addPolygon(2, 5);
        n.addPolygon(0, 3).addPolygon(0, 5).addPolygon(3, 3);
        n.addPolygon(1, 3).addPolygon(0, 5).addPolygon(3, 3);
        n.addPolygon(3, 3).addPolygon(0, 5).addPolygon(3, 3);
        n.addPolygon(4, 3).addPolygon(0, 5).addPolygon(3, 3);
        next = next.addPolygon(3, 4);
        n = next.addPolygon(2, 4);
        n.addPolygon(0, 3);
        n = n.addPolygon(3, 5);
        n.addPolygon(0, 4).addPolygon(2, 3);
        n.addPolygon(1, 4).addPolygon(2, 3);
        n.addPolygon(3, 4).addPolygon(2, 3);
        n.addPolygon(4, 4).addPolygon(2, 3);
        next.addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
    }
}