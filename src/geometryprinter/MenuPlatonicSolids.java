package geometryprinter;
import geometryprinter.item.solid.platonic.Cube;
import geometryprinter.item.solid.platonic.Dodecahedron;
import geometryprinter.item.solid.platonic.Icosahedron;
import geometryprinter.item.solid.platonic.Octahedron;
import geometryprinter.item.solid.platonic.Tetrahedron;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuPlatonicSolids extends MenuList{
    public MenuPlatonicSolids(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final MenuPlatonicSolids that = this;
        addButton("Add Tetrahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Tetrahedron()));
            }
        });
        addButton("Add Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Cube()));
            }
        });
        addButton("Add Octahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Octahedron()));
            }
        });
        addButton("Add Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Dodecahedron()));
            }
        });
        addButton("Add Icosahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Icosahedron()));
            }
        });
    }
}