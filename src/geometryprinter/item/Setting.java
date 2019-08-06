package geometryprinter.item;
import simplelibraryextended.opengl.gui.components.MenuComponentPanel;
public interface Setting{
    public abstract String getName();
    public abstract MenuComponentPanel getSettings(double width, double height);
    public abstract Object getValue();
    public abstract Object getRandomValue();
    public abstract Setting replicate();
    public abstract int getSize();
}