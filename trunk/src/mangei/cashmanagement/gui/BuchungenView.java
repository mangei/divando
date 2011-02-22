package mangei.cashmanagement.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mangei.cashmanagement.ActionManager;
import mangei.cashmanagement.ServiceManager;
import mangei.cashmanagement.gui.action.BuchungAction;

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

        pButtons.add(new JButton(ActionManager.getAction(BuchungAction.NewBuchungAction.class)));
        pButtons.add(new JButton(ActionManager.getAction(BuchungAction.EditBuchungAction.class)));
        pButtons.add(new JButton(new AbstractAction("Stornieren") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        }));

        final BuchungAction.EditBuchungAction editAction = (BuchungAction.EditBuchungAction)ActionManager.getAction(BuchungAction.EditBuchungAction.class);

        tBuchungen.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent lse) {
                int selectedRow = tBuchungen.getSelectedRow();
                if (selectedRow != -1) {
                    Buchung b = ((BuchungTableModel) tBuchungen.getModel()).getBuchungen().get(selectedRow);
                    System.out.println("sad: " + b.getName());
                    editAction.setBuchung(b);
                }
            }
        });
    }

}
