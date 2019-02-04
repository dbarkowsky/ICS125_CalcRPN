
package calcrpn;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPopupMenu;
import javax.swing.text.JTextComponent;

/**
 *
 * @author SLang
 * Date Created: January 24, 2019
 * Date Updated: NA
 */
public class ContextMenuMouseListener extends MouseAdapter {
    private final JPopupMenu popup = new JPopupMenu();

    //private final Action cutAction;
    private final Action copyAction;
    //private final Action pasteAction;
    //private final Action undoAction;
    private final Action selectAllAction;

    private JTextComponent textComponent;
    private final String savedString = "";
    private Actions lastActionSelected;

    private enum Actions { UNDO, CUT, COPY, PASTE, SELECT_ALL };

    public ContextMenuMouseListener() {
        
        copyAction = new AbstractAction("Copy") {

            @Override
            public void actionPerformed(ActionEvent ae) {
                lastActionSelected = Actions.COPY;
                textComponent.copy();
            }
        };

        popup.add(copyAction);
        
        popup.addSeparator();

        selectAllAction = new AbstractAction("Select All") {

            @Override
            public void actionPerformed(ActionEvent ae) {
                lastActionSelected = Actions.SELECT_ALL;
                textComponent.selectAll();
            }
        };

        popup.add(selectAllAction);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
            if (!(e.getSource() instanceof JTextComponent)) {
                return;
            }

            textComponent = (JTextComponent) e.getSource();
            textComponent.requestFocus();

            boolean enabled = textComponent.isEnabled();
            //boolean editable = textComponent.isEditable();
            boolean nonempty = !(textComponent.getText() == null || textComponent.getText().equals(""));
            boolean marked = textComponent.getSelectedText() != null;

           
            copyAction.setEnabled(enabled && marked);
 
            selectAllAction.setEnabled(enabled && nonempty);

            int nx = e.getX();

            if (nx > 500) {
                nx = nx - popup.getSize().width;
            }

            popup.show(e.getComponent(), nx, e.getY() - popup.getSize().height);
        }
    }
}  // end ContextMenuMouseListener