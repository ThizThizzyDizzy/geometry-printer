package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class ElongatedPentagonalOrthobirotunda extends PolyhedronNet{
    public ElongatedPentagonalOrthobirotunda(){
        this(1);
    }
    public ElongatedPentagonalOrthobirotunda(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Elongated Pentagonal Orthobirotunda";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof ElongatedPentagonalOrthobirotunda){
            if(size==((ElongatedPentagonalOrthobirotunda) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new ElongatedPentagonalOrthobirotunda(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Elongated Pentagonal Orthobirotunda";
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
        n = next.addPolygon(2, 5);
        n.addPolygon(1, 3);
        n = n.addPolygon(0, 3).addPolygon(2, 5);
        n.addPolygon(0, 3).addPolygon(0, 5).addPolygon(3, 3);
        n.addPolygon(1, 3).addPolygon(0, 5).addPolygon(3, 3);
        n.addPolygon(3, 3).addPolygon(0, 5).addPolygon(3, 3);
        n.addPolygon(4, 3).addPolygon(0, 5).addPolygon(3, 3);
        next.addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4).addPolygon(3, 4);
    }
}