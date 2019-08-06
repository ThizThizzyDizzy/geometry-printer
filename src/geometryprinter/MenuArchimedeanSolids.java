package geometryprinter;
import geometryprinter.item.solid.archimedean.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuArchimedeanSolids extends MenuList{
    public MenuArchimedeanSolids(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final MenuArchimedeanSolids that = this;
        addButton("Add Truncated Tetrahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TruncatedTetrahedron()));
            }
        });
        addButton("Add Truncated Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TruncatedCube()));
            }
        });
        addButton("Add Truncated Cuboctahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TruncatedCuboctahedron()));
            }
        });
        addButton("Add Truncated Octahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TruncatedOctahedron()));
            }
        });
        addButton("Add Truncated Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TruncatedDodecahedron()));
            }
        });
        addButton("Add Truncated Icosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TruncatedIcosidodecahedron()));
            }
        });
        addButton("Add Truncated Icosahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new TruncatedIcosahedron()));
            }
        });
        addButton("Add Cuboctahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Cuboctahedron()));
            }
        });
        addButton("Add Icosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Icosidodecahedron()));
            }
        });
        addButton("Add Rhombicuboctahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Rhombicuboctahedron()));
            }
        });
        addButton("Add Rhombicosidodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Rhombicosidodecahedron()));
            }
        });
        addButton("Add Snub Cube", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SnubCube()));
            }
        });
        addButton("Add Snub Dodecahedron", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SnubDodecahedron()));
            }
        });
    }
}