package geometryprinter.item.solid.johnson;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Disphenocingulum extends PolyhedronNet{
    public Disphenocingulum(){
        this(1);
    }
    public Disphenocingulum(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Disphenocingulum";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Disphenocingulum){
            if(size==((Disphenocingulum) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Disphenocingulum(size);
    }
    @Override
    public String getCategoryName(){
        return "Johnson Solids";
    }
    @Override
    public String getItemName(){
        return "Disphenocingulum";
    }
    @Override
    protected void buildNet(){
        //middle square
        net = new NetPart(-45, 4, 0, 0, size);
        NetPart next = net.addPolygon(1, 4);
        next.addPolygon(0, 3).addPolygon(2, 3).addPolygon(0, 3);
        next.addPolygon(2, 3).addPolygon(0, 3);
        next = next.addPolygon(3, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        net.addPolygon(2, 3).addPolygon(0, 3);
        next = net.addPolygon(3, 3);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = net.addPolygon(0, 3).addPolygon(2, 3).addPolygon(0, 3).addPolygon(2, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
        next = next.addPolygon(3, 4);
        next.addPolygon(0, 3);
        next.addPolygon(2, 3);
    }
}