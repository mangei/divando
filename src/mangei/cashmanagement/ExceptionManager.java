package mangei.cashmanagement;

import javax.swing.JOptionPane;

/**
 *
 * @author manuel.geier
 */
public class ExceptionManager {

    public static void logException(Exception ex) {
        ex.printStackTrace();
        showException(ex);
    }

    private static void showException(Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getName(), JOptionPane.ERROR_MESSAGE);
    }

}
