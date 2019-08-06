package geometryprinter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuCategories extends MenuList{
    public MenuCategories(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final MenuList that = this;
        addButton("2D Geometries", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new Menu2D(gui, that));
            }
        });
        addButton("3D Geometries", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new Menu3D(gui, that));
            }
        });
        addButton("Building Materials", "Beams and Plates for construction of sturdy structures.", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuBuildingMaterials(gui, that));
            }
        });
        addButton("Chemistry", "Various Chemistry-related geometries.", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuChemistry(gui, that));
            }
        });
    }
}