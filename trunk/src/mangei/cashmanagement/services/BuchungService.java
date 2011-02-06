package mangei.cashmanagement.services;

import java.util.List;

import mangei.cashmanagement.pojo.Buchung;
import mangei.cashmanagement.pojo.Buchungskategorie;
import mangei.cashmanagement.pojo.Konto;
import mangei.cashmanagement.pojo.Kontokategorie;

public interface BuchungService {

	public Buchung saveBuchung(Buchung buchung);
	public Konto saveKonto(Konto konto);
	public Buchungskategorie saveBuchungskategorie(Buchungskategorie kategorie);
	public Kontokategorie saveKontokategorie(Kontokategorie kategorie);
	
	public List<Kontokategorie> getKontokategorien();
	public List<Konto> getKonten();
	public List<Buchungskategorie> getBuchungskategorien();
	public List<Buchung> getBuchungen();
}
