package geometryprinter;
import geometryprinter.item.materials.DiagonalTimber;
import geometryprinter.item.materials.SteelPlate;
import geometryprinter.item.materials.Timber;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuBuildingMaterials extends MenuList{
    public MenuBuildingMaterials(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final MenuBuildingMaterials that = this;
        addButton("Add Timber", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Timber()));
            }
        });
        addButton("Add Diagonal Timber", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new DiagonalTimber()));
            }
        });
        addButton("Add Plate", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new SteelPlate()));
            }
        });
    }
}