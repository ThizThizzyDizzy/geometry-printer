package geometryprinter.item.chemistry;
import geometryprinter.PageObject;
import geometryprinter.item.Item;
import geometryprinter.item.PolyhedronNet;
public class Buckyball extends PolyhedronNet{
    public Buckyball(){
        this(1);
    }
    public Buckyball(int size){
        this.size = size;
    }
    @Override
    public String getDisplayName(){
        return size+" Pixel Buckyball";
    }
    @Override
    public boolean isEqual(Item item){
        if(item instanceof Buckyball){
            if(size==((Buckyball) item).size){
                return true;
            }
        }
        return false;
    }
    @Override
    public PageObject replicate(){
        return new Buckyball(size);
    }
    @Override
    public String getCategoryName(){
        return "Chemistry";
    }
    @Override
    public String getItemName(){
        return "Buckyball";
    }
    @Override
    protected void buildNet(){
        //far left central hexagon
        net = new NetPart(-30, 6, 0, 0, size);
        net.addPolygon(3, 6);
        NetPart next = net.addPolygon(1, 6);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6);
        next = next.addPolygon(4, 6);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6);
        next = next.addPolygon(4, 6);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6);
        next = next.addPolygon(4, 6);
        next.addPolygon(4, 6);
        next = next.addPolygon(0, 6);
        next.addPolygon(0, 6);
        next = next.addPolygon(4, 6);
        next.addPolygon(4, 6);
    }
}