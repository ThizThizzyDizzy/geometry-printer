package geometryprinter;
import geometryprinter.item.flat.EquilateralTriangleArray;
import geometryprinter.item.flat.Hexahexaflexagon;
import geometryprinter.item.flat.IsoscelesTriangleArray;
import geometryprinter.item.flat.Polygon;
import geometryprinter.item.flat.Rectangle;
import geometryprinter.item.flat.Trihexaflexagon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class Menu2D extends MenuList{
    public Menu2D(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final Menu2D that = this;
        addButton("Add Equilateral Triangles", "An array of equilateral triangles", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new EquilateralTriangleArray()));
            }
        });
        addButton("Add Isosceles Triangles", "An array of isosceles triangles", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new IsoscelesTriangleArray()));
            }
        });
        addButton("Add Rectangle", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Rectangle()));
            }
        });
        addButton("Add Regular Polygon", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Polygon()));
            }
        });
        addButton("Add Trihexaflexagon", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Trihexaflexagon()));
            }
        });
        addButton("Add Hexahexaflexagon", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Hexahexaflexagon()));
            }
        });
    }
}