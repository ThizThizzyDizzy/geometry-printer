package geometryprinter;
import geometryprinter.item.chemistry.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
public class MenuChemistry extends MenuList{
    public MenuChemistry(GUI gui, Menu parent){
        super(gui, parent);
    }
    @Override
    protected void addButtons(){
        final MenuChemistry that = this;
        addButton("Add Buckyball", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gui.open(new MenuAddItem(gui, that, new Buckyball()));
            }
        });
//        addButton("Add Periodic Table", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new PeriodicTable()));
//            }
//        });
//        addButton("Add Solubility Rules", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new SolubilityRules()));
//            }
//        });
//        addButton("Add Polyatomic Ion Sheet", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                gui.open(new MenuAddItem(gui, that, new PolyatomicIonSheet()));
//            }
//        });
    }
}