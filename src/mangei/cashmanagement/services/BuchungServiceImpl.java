package mangei.cashmanagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import mangei.cashmanagement.doa.BuchungDAO;
import mangei.cashmanagement.doa.BuchungDAOMysqlImpl;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void addBuchung(Buchung buchung) {
		
	}

	@Override
	public void addBuchungskategorie(Buchungskategorie kategorie) {
		
	}

	@Override
	public void addKonto(Konto konto) {
		
	}

	@Override
	public void addKontokategorie(Kontokategorie kategorie) {
		
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
