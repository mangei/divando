package mangei.cashmanagement.gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mangei.cashmanagement.pojo.Buchung;

public class EditBuchung extends JPanel {

	private Buchung pBuchung;
	
	private JTextField tfName;
	private JTextField tfBetrag;
	private JComboBox cbKategorie;
	private JComboBox cbKonto;
	
	public EditBuchung(Buchung pBuchung) {
		this.pBuchung = pBuchung;
		initComponents();
		initLayout();
	}
	
	private void initComponents() {
		tfName = new JTextField(pBuchung.getName());
		tfBetrag = new JTextField(pBuchung.getBetrag().toString());
		cbKategorie = new JComboBox();
		cbKonto = new JComboBox();
	}
	
	private void initLayout() {
		setLayout(new GridLayout(2,2));
		add(new JLabel("Name: "));
		add(tfName);
		add(new JLabel("Betrag: "));
		add(tfBetrag);
		add(new JLabel("Kategorie: "));
		add(cbKategorie);
		add(new JLabel("Konto: "));
		add(cbKonto);
	}
}
