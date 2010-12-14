package mangei.cashmanagement.gui.model;

import java.util.EventListener;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import mangei.cashmanagement.pojo.Buchung;

public class BuchungTableModel extends AbstractTableModel {

	private List<Buchung> buchungen;
	
	public BuchungTableModel(List<Buchung> buchungen) {
		this.buchungen = buchungen;
	}
	
	public List<Buchung> getBuchungen() {
		return buchungen;
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return buchungen.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column) {
			case 0: return "Name";
			case 1: return "Betrag";
			case 2: return "Kategorie";
			case 3: return "Konto";
			default: return "";
		}
	}

	@Override
	public Object getValueAt(int index, int col) {
		switch(col) {
			case 0: return buchungen.get(index).getName();
			case 1: return buchungen.get(index).getBetrag();
			case 2: return buchungen.get(index).getBuchungskategorie();
			case 3: return buchungen.get(index).getKonto();
			default: return "";
		}
	}

}
