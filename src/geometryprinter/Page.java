package geometryprinter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class Page extends JPanel implements Printable{
    public static boolean landscape = true;
    public static int pageWidth = landscape?720:576;
    public static int pageHeight = landscape?576:720;
    ArrayList<PageObject> objs = new ArrayList<>();
    static void switchOrientation(){
        landscape = !landscape;
        pageWidth = landscape?720:576;
        pageHeight = landscape?576:720;
    }
    public Page(){
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.BLACK));
        setSize(new Dimension(pageWidth, pageHeight));
        setPreferredSize(new Dimension(pageWidth, pageHeight));
        setLayout(null);
    }
    public boolean add(PageObject obj){
        int xVariance = pageWidth-obj.getWidth();
        int yVariance = pageHeight-obj.getHeight();
        int width = obj.getWidth();
        int height = obj.getHeight();
        for(int y = 0; y<yVariance; y++){
            X:for(int x = 0; x<xVariance; x++){
                Rectangle rect = new Rectangle(x, y, width, height);
                for(PageObject anobj : objs){
                    if(anobj.getBounds().intersects(rect)){
                        x = Math.max(x, anobj.getX()+anobj.getWidth()-1);
                        continue X;
                    }
                }
                obj.setLocation(x, y);
                objs.add(obj);
                add((Component)obj);
                return true;
            }
        }
        if(objs.isEmpty()){
            if(xVariance>=0&&yVariance>=0){
                obj.setLocation(0,0);
                objs.add(obj);
                add((Component)obj);
                return true;
            }
            if(!obj.canSplit()){
                System.err.println("Object too big to fit on page!\nSpace Needed:"+(xVariance<=0?"\nX: "+-xVariance:"")+(yVariance<=0?"\nY: "+-yVariance:""));
            }
        }
        return false;
    }
    public boolean fits(PageObject obj){
        int xVariance = pageWidth-obj.getWidth();
        int yVariance = pageHeight-obj.getHeight();
        int width = obj.getWidth();
        int height = obj.getHeight();
        for(int y = 0; y<yVariance; y++){
            X:for(int x = 0; x<xVariance; x++){
                Rectangle rect = new Rectangle(x, y, width, height);
                for(PageObject anobj : objs){
                    if(anobj.getBounds().intersects(rect)){
                        continue X;
                    }
                }
                return true;
            }
        }
        return false;
    }
    public int print(Graphics g, PageFormat format, int page){
        if(page!=0){
            return NO_SUCH_PAGE;
        }
        ((Graphics2D)g).translate(format.getImageableX(), format.getImageableY());
        draw(g);
        return PAGE_EXISTS;
    }
    public Page generateDoubleSidedPage(){
        Page page = new Page();
        for(PageObject obj : objs){
            if(obj.requiresDoubleSiding()){
                PageObject obj2 = obj.replicate();
                obj2.setBounds(obj.getX(), pageHeight-obj.getY()-obj.getHeight(), obj.getWidth(), obj.getHeight());
                page.add((Component)obj2);
                page.objs.add(obj2);
            }
        }
        return page;
    }
    public void draw(Graphics g){
        for(PageObject obj : objs){
            g.translate(obj.getX(), obj.getY());
            obj.print(g);
            g.translate(-obj.getX(), -obj.getY());
        }
    }
    @Override
    public void removeAll(){
        super.removeAll();
        objs.clear();
    }
}