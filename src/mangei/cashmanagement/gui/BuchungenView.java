package mangei.cashmanagement.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import mangei.cashmanagement.ServiceManager;

import mangei.cashmanagement.gui.model.BuchungTableModel;
import mangei.cashmanagement.pojo.Buchung;

public class BuchungenView extends JPanel {

    private JPanel pButtons;
    private JTable tBuchungen;

    public BuchungenView() {
        setLayout(new BorderLayout());

        pButtons = new JPanel(new FlowLayout());
        tBuchungen = new JTable(new BuchungTableModel(ServiceManager.getBuchungService().getBuchungen()));

        add(pButtons, BorderLayout.NORTH);
        add(new JScrollPane(tBuchungen), BorderLayout.CENTER);

        pButtons.add(new JButton(new AbstractAction("Neu") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                editBuchung(new Buchung());
            }
        }));

        pButtons.add(new JButton(new AbstractAction("Bearbeiten") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int selectedRow = tBuchungen.getSelectedRow();
                if (selectedRow != -1) {
                    Buchung b = ((BuchungTableModel) tBuchungen.getModel()).getBuchungen().get(selectedRow);
                    editBuchung(b);
                }
            }
        }));

        pButtons.add(new JButton(new AbstractAction("Stornieren") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        }));
    }

    private void editBuchung(final Buchung buchung) {
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
