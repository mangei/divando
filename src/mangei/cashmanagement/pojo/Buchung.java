package mangei.cashmanagement.pojo;

public class Buchung {

	private Long id;
	private String name;
	private Long betrag = (long) 0;
	private Buchungskategorie buchungskategorie;
	private Konto konto;
	
	public Buchung() {
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
	
	public Long getBetrag() {
		return betrag;
	}
	
	public void setBetrag(Long betrag) {
		this.betrag = betrag;
	}

	public Buchungskategorie getBuchungskategorie() {
		return buchungskategorie;
	}

	public void setBuchungskategorie(Buchungskategorie buchungskategorie) {
		this.buchungskategorie = buchungskategorie;
	}
	
	public Konto getKonto() {
		return konto;
	}
	
	public void setKonto(Konto konto) {
		this.konto = konto;
	}
	
}
