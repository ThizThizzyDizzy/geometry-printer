package geometryprinter;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;
import javax.print.attribute.standard.MediaPrintableArea;
public class CustomPrinting extends Component implements Printable{
    private final ArrayList<Page> pages;
    private final boolean doubleSide;
    private boolean color;
    public CustomPrinting(ArrayList<Page> pages){
        this.pages = new ArrayList<>();
        doubleSide = shouldDoubleSide();
        color = shouldPrintColor();
        for(Page page : pages){
            this.pages.add(page);
            if(doubleSide){
                this.pages.add(page.generateDoubleSidedPage());
            }
        }
    }
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException{
        if(pageIndex<0||pageIndex>=pages.size()){
            return NO_SUCH_PAGE;
        }
        pages.get(pageIndex).print(graphics, pageFormat, 0);
        return PAGE_EXISTS;
    }
    public void printIt(){
        final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
        if(doubleSide){
            attributes.add(Sides.DUPLEX);
        }
        attributes.add(new JobName(Main.applicationName, Locale.US));
        attributes.add(new MediaPrintableArea(5/16f, 1/8f, 7.875F, 10.75F, MediaPrintableArea.INCH));
        if(color){
            attributes.add(Chromaticity.COLOR);
        }else{
            attributes.add(Chromaticity.MONOCHROME);
        }
        if(Page.landscape){
            attributes.add(OrientationRequested.LANDSCAPE);
        }else{
            attributes.add(OrientationRequested.PORTRAIT);
        }
        final PrinterJob j = PrinterJob.getPrinterJob();
        PageFormat format = j.getPageFormat(attributes);
        j.setPrintable(this, format);
        new Thread(new Runnable(){
            @Override
            public void run(){
                Core.helper.setFullscreen(false);
                if(j.printDialog(attributes)){
                    try {
                        j.print(attributes);
                    } catch (PrinterException ex) {
                        Logger.getLogger(CustomPrinting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Core.helper.setFullscreen(true);
            }
        }).start();
    }
    private boolean shouldDoubleSide(){
        for(Page page : pages){
            for(PageObject obj : page.objs){
                if(obj.requiresDoubleSiding()){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean shouldPrintColor(){
        for(Page page : pages){
            for(PageObject obj : page.objs){
                if(obj.requiresColor()){
                    return true;
                }
            }
        }
        return false;
    }
}