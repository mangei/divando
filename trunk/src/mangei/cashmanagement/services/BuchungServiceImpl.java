package mangei.cashmanagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import mangei.cashmanagement.ExceptionManager;

import mangei.cashmanagement.dao.BuchungDAO;
import mangei.cashmanagement.dao.BuchungDAOMysqlImpl;
import mangei.cashmanagement.pojo.Buchung;
import mangei.cashmanagement.pojo.Buchungskategorie;
import mangei.cashmanagement.pojo.Konto;
import mangei.cashmanagement.pojo.Kontokategorie;

public class BuchungServiceImpl implements BuchungService {
	
	private static BuchungServiceImpl singletonInstance;
	
	private BuchungDAO buchungDAO;
	
	private BuchungServiceImpl() {
		initDAOs();
	}
	
	private void initDAOs() {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch( ClassNotFoundException e ) {
			System.out.println( "JDBC Driver could not be loaded!" );
			
		}
		// get a Connection object
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cashmanagementdb","root","");
		} catch (SQLException e) {
			ExceptionManager.logException(e);
		}

		buchungDAO = new BuchungDAOMysqlImpl(con);
	}
	
	public static BuchungServiceImpl getInstance() {
		if(singletonInstance == null) {
			singletonInstance = new BuchungServiceImpl();
		}
		return singletonInstance;
	}
	
	@Override
	public Buchung saveBuchung(Buchung buchung) {
            if(buchung.getId() == null) {
                return buchungDAO.insert(buchung);
            } else {
                return buchungDAO.update(buchung);
            }
	}

	@Override
	public Buchungskategorie saveBuchungskategorie(Buchungskategorie kategorie) {
            return null;
	}

	@Override
	public Konto saveKonto(Konto konto) {
            return null;
	}

	@Override
	public Kontokategorie saveKontokategorie(Kontokategorie kategorie) {
            return null;
	}

	@Override
	public List<Kontokategorie> getKontokategorien() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Konto> getKonten() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Buchungskategorie> getBuchungskategorien() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Buchung> getBuchungen() {
		return buchungDAO.getAll();
	}

}
