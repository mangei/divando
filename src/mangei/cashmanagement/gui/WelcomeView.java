package mangei.cashmanagement.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mangei.cashmanagement.gui.model.BuchungTableModel;
import mangei.cashmanagement.pojo.Buchung;

public class WelcomeView extends JPanel {
	
	public WelcomeView() {
		setLayout(new BorderLayout());
		
		add(new JLabel("Willkommen!"), BorderLayout.CENTER);
		
	}
}
