package mangei.cashmanagement.gui;

import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.Validatable;
import com.jgoodies.validation.ValidationResult;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import mangei.cashmanagement.pojo.Buchung;

/**
 *
 * @author manuel.geier
 */
public class EditBuchungPresentationModel
    implements Validatable {

    private Buchung buchung;

    private ValueModel nameValueModel;
    private ValueModel betragValueModel;
    private ComboBoxModel kategorieComboBoxModel;
    private ComboBoxModel kontoComboBoxModel;
    private Action okAction;
    private Action cancelAction;

    public EditBuchungPresentationModel(Buchung buchung) {
        this.buchung = buchung;
        initModels();
    }

    private void initModels() {
        nameValueModel = new ValueHolder(buchung.getName());
        betragValueModel = new ValueHolder(buchung.getBetrag().toString());
        kategorieComboBoxModel = new DefaultComboBoxModel();
        kontoComboBoxModel = new DefaultComboBoxModel();
        okAction = new OkAction("Ok");
        cancelAction = new CancelAction("Abbrechen");
    }

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();



        return result;
    }

    private class OkAction extends AbstractAction {

        public OkAction(String name) {
            super(name);
        }

        public void actionPerformed(ActionEvent ae) {
System.out.println("1");
        }
    }

    private class CancelAction extends AbstractAction {

        public CancelAction(String name) {
            super(name);
        }

        public void actionPerformed(ActionEvent ae) {
System.out.println("1");
        }
    }

    public ValueModel getNameValueModel() {
        return nameValueModel;
    }

    public ValueModel getBetragValueModel() {
        return betragValueModel;
    }

    public ComboBoxModel getKategorieComboBoxModel() {
        return kategorieComboBoxModel;
    }

    public ComboBoxModel getKontoComboBoxModel() {
        return kontoComboBoxModel;
    }

    public Action getOkAction() {
        return okAction;
    }

    public Action getCancelAction() {
        return cancelAction;
    }

}
