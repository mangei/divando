package mangei.cashmanagement.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mangei.cashmanagement.gui.model.BuchungTableModel;
import mangei.cashmanagement.pojo.Buchung;
import mangei.cashmanagement.services.BuchungService;

public class BuchungenView extends JPanel {

	private JPanel pButtons;
	private JTable tBuchungen;
	
	public BuchungenView(BuchungService buchungService) {
		setLayout(new BorderLayout());
		
		pButtons = new JPanel(new FlowLayout());
		tBuchungen = new JTable(new BuchungTableModel(buchungService.getBuchungen()));
		
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
				if(selectedRow != -1) {
					Buchung b = ((BuchungTableModel)tBuchungen.getModel()).getBuchungen().get(selectedRow);
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
	
	private void editBuchung(Buchung buchung) {
		JDialog d = new JDialog((Frame)null, true);
		d.add(new EditBuchung(buchung));
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d.pack();
		d.setVisible(true);
	}
}
