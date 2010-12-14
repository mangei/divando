package mangei.cashmanagement.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mangei.cashmanagement.pojo.Buchung;

public class BuchungDAOMysqlImpl
	extends AbstractDAOImpl<Buchung>
	implements BuchungDAO {

	private static final String TABLENAME = "buchung";
	
	public BuchungDAOMysqlImpl(Connection connection) {
		this.connection = connection;
	}
	
	public List<Buchung> getAll() {
		List<Buchung> list = new ArrayList<Buchung>();
		
		try {
			Statement s = connection.createStatement();
			s.execute("SELECT * FROM "+TABLENAME+";");
			ResultSet rs = s.getResultSet();
			while(rs.next()) {
				list.add(resultSet2Object(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Buchung get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Buchung save() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Buchung b) {
		// TODO Auto-generated method stub

	}

	private Buchung resultSet2Object(ResultSet rs) throws SQLException {
		Buchung b = new Buchung();
		
		b.setName(rs.getString("name"));
		b.setBetrag(rs.getLong("betrag"));
		
		return b;
	}
}
