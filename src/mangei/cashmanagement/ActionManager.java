package mangei.cashmanagement;

import java.util.HashMap;
import javax.swing.Action;
import mangei.cashmanagement.gui.action.BuchungAction;

/**
 *
 * @author manuel.geier
 */
public class ActionManager {

    private static HashMap<Class, Action> actionMap = new HashMap<Class, Action>();
    static {
        actionMap.put(BuchungAction.NewBuchungAction.class, new BuchungAction.NewBuchungAction());
        actionMap.put(BuchungAction.EditBuchungAction.class, new BuchungAction.EditBuchungAction());
    }

    private ActionManager() {}

    public static Action getAction(Class clazz) {
        return actionMap.get(clazz);
    }

}
