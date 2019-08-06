package geometryprinter;
import java.awt.event.ActionListener;
import org.lwjgl.opengl.Display;
import simplelibrary.Queue;
import simplelibrary.game.GameHelper;
import simplelibrary.opengl.gui.GUI;
import simplelibrary.opengl.gui.Menu;
import simplelibraryextended.opengl.gui.components.MenuComponentAdvancedButton;
import simplelibraryextended.opengl.gui.components.MenuComponentAdvancedMulticolumnList;
import simplelibraryextended.opengl.gui.menu.AdvancedMenu;
public abstract class MenuList extends AdvancedMenu{
    protected final MenuComponentAdvancedMulticolumnList list;
    protected final PrintingList printlist;
    private Queue<ActionListener> actions = new Queue<>();
    public MenuList(GUI gui, Menu parent){
        super(gui, parent, Core.is3D?GameHelper.MODE_3D:GameHelper.MODE_2D);
        list = add(new MenuComponentAdvancedMulticolumnList(0, 0, Display.getWidth()-400, Display.getHeight(), (Display.getWidth()-420)/2, (Display.getWidth()-420)/20, 20, true));
        printlist = add(new PrintingList());
        addButtons();
    }
    @Override
    public void mouseEvent(int button, boolean pressed, float x, float y, float xChange, float yChange, int wheelChange){
        if(button==1&&pressed){
            gui.open(parent);
        }
        super.mouseEvent(button, pressed, x, y, xChange, yChange, wheelChange);
    }
    protected abstract void addButtons();
    protected void addButton(String label, ActionListener action){
        addButton(label, null, true, action);
    }
    protected void addButton(String label, String tooltip, ActionListener action){
        addButton(label, tooltip, true, action);
    }
    protected void addButton(String label, boolean enabled, ActionListener action){
        addButton(label, null, enabled, action);
    }
    protected void addButton(String label, String tooltip, boolean enabled, ActionListener action){
        MenuComponentAdvancedButton button = new MenuComponentAdvancedButton(0, 0, list.columnWidth, list.rowHeight, label, enabled, true, "/textures/gui/button");
        if(tooltip!=null){
            button.setTooltip(tooltip);
            button.setTooltipType(MenuComponentAdvancedButton.TOOLTIP_SLIDE_DOWN);
            button.setTooltipDelay(0);
            button.setTooltipTime(5);
        }
        actions.enqueue(action);
        button.addActionListener(action);
        list.add(button);
    }
    @Override
    public void renderBackground(){}
    public void loadItems(){
        for(ActionListener l : actions){
            l.actionPerformed(null);
        }
    }
}