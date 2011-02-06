package mangei.cashmanagement;

import com.jgoodies.binding.value.ValueModel;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author manuel.geier
 */
public class ComponentFactory {

    public static JTextField createTextField(ValueModel model) {
        return new JTextField();
    }

    public static JComboBox createComboBox(ComboBoxModel model) {
        return new JComboBox();
    }

    public static JButton createButton(Action action) {
        return new JButton(action);
    }

}
