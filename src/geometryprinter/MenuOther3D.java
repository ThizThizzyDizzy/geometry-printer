package geometryprinter;
import geometryprinter.item.solid.other.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuOther3D extends MenuList{
    public MenuOther3D(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final MenuOther3D that = this;
        addButton("Add Box", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Box()));
            }
        });
        addButton("Add Cubic Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new CubicPyramid()));
            }
        });
        addButton("Add Pyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Pyramid()));
            }
        });
        addButton("Add Bipyramid", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Bipyramid()));
            }
        });
        addButton("Add Star Pyramid", false, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new StarPyramid()));
            }
        });
        addButton("Add Star Bipyramid", false, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new StarBipyramid()));
            }
        });
        addButton("Add Trapezohedron", false, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new Trapezohedron()));
            }
        });
        addButton("Add Star Trapezohedron", false, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new StarTrapezohedron()));
            }
        });
        addButton("Add Prism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Prism()));
            }
        });
        addButton("Add Antiprism", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Antiprism()));
            }
        });
        addButton("Add Star Prism", false, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new StarPrism()));
            }
        });
        addButton("Add Star Antiprism", false, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new StarAntiprism()));
            }
        });
        addButton("Add Text", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Text()));
            }
        });
        addButton("Add Inverted Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new InvertedCube()));
            }
        });
        addButton("Add Folding Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new FoldingCube()));
            }
        });
        addButton("Add Inverted Folding Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new InvertedFoldingCube()));
            }
        });
        addButton("Add Rhombic Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new RhombicDodecahedron()));
            }
        });
        addButton("Add Cubing Rhombic Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new CubingRhombicDodecahedron()));
            }
        });
    }
}