package mangei.cashmanagement.services;

import java.util.List;

import mangei.cashmanagement.pojo.Buchung;
import mangei.cashmanagement.pojo.Buchungskategorie;
import mangei.cashmanagement.pojo.Konto;
import mangei.cashmanagement.pojo.Kontokategorie;

public interface BuchungService {

	public void addBuchung(Buchung buchung);
	public void addKonto(Konto konto);
	public void addBuchungskategorie(Buchungskategorie kategorie);
	public void addKontokategorie(Kontokategorie kategorie);
	
	public List<Kontokategorie> getKontokategorien();
	public List<Konto> getKonten();
	public List<Buchungskategorie> getBuchungskategorien();
	public List<Buchung> getBuchungen();
}
