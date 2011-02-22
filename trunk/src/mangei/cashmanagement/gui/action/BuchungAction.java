package mangei.cashmanagement.gui.action;

import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import mangei.cashmanagement.ServiceManager;
import mangei.cashmanagement.gui.EditBuchungPresentationModel;
import mangei.cashmanagement.gui.EditBuchungView;
import mangei.cashmanagement.pojo.Buchung;

/**
 *
 * @author manuel.geier
 */
public class BuchungAction {

    private BuchungAction() {
    }

    public static class NewBuchungAction extends AbstractAction {

        public NewBuchungAction() {
            super("Neu");
        }

        public void actionPerformed(ActionEvent ae) {
            editBuchung(new Buchung());
        }

    }

    public static class EditBuchungAction extends AbstractAction {

        private ValueModel buchungModel;

        public EditBuchungAction() {
            super("Bearbeiten");
            this.buchungModel = new ValueHolder();
        }

        public void actionPerformed(ActionEvent ae) {
            Buchung buchung;
            if (buchungModel.getValue() != null) {
                buchung = (Buchung) buchungModel.getValue();
            } else {
                throw new RuntimeException("ValueModel is empty");
            }
            editBuchung(buchung);
        }

        public void setBuchung(Buchung buchung) {
            buchungModel.setValue(buchung);
        }
    }

    private static void editBuchung(final Buchung buchung) {
        final JDialog d = new JDialog((Frame) null, true);
        EditBuchungView v = new EditBuchungView(new EditBuchungPresentationModel(buchung));
        v.getButtonOk().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                System.out.println("2");
                ServiceManager.getBuchungService().saveBuchung(buchung);
                d.setVisible(false);
                d.dispose();
            }
        });
        v.getButtonCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                d.setVisible(false);
                d.dispose();
            }
        });
        d.add(v);
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.pack();
        d.setVisible(true);
    }
}
