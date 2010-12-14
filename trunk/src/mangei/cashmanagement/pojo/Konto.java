package mangei.cashmanagement.pojo;

import java.util.ArrayList;
import java.util.List;

public class Konto {

	private Long id;
	private String name;
	private Kontokategorie kontokategorie;
	private List<Buchung> buchungen = new ArrayList<Buchung>();
	
	public Konto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kontokategorie getKontokategorie() {
		return kontokategorie;
	}

	public void setKontokategorie(Kontokategorie kontokategorie) {
		this.kontokategorie = kontokategorie;
	}
	
	public List<Buchung> getBuchungen() {
		return buchungen;
	}
	
	public void setBuchungen(List<Buchung> buchungen) {
		this.buchungen = buchungen;
	}
	
}
