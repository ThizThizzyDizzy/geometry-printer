package geometryprinter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class Menu3D extends MenuList{
    public Menu3D(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final Menu3D that = this;
        addButton("Platonic Solids", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuPlatonicSolids(gui, that));
            }
        });
        addButton("Johnson Solids", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuJohnsonSolids(gui, that));
            }
        });
        addButton("Archimedean Solids", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuArchimedeanSolids(gui, that));
            }
        });
        addButton("Other", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuOther3D(gui, that));
            }
        });
    }
}