package mangei.cashmanagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mangei.cashmanagement.ExceptionManager;

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
            s.execute("SELECT * FROM " + TABLENAME + ";");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                list.add(resultSet2Object(rs));
            }

        } catch (SQLException e) {
            ExceptionManager.logException(e);
        }

        return list;
    }

    public Buchung get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Buchung insert(Buchung b) {
        try {
            Statement s = connection.createStatement();
            int i;
            i = s.executeUpdate("INSERT INTO " + TABLENAME + " (name,betrag) VALUES ('"
                    +b.getName()+"','"+b.getBetrag()+"');", Statement.RETURN_GENERATED_KEYS);

            // Receive key
            int autoIncKeyFromApi = -1;
            ResultSet rs = s.getGeneratedKeys();
            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
                b.setId((long) autoIncKeyFromApi);
            } else {
                ExceptionManager.logException(new Exception("Missing key"));
            }
            System.out.println("key: " + autoIncKeyFromApi);

        } catch (SQLException e) {
            ExceptionManager.logException(e);
        }
        return b;
    }

    public Buchung update(Buchung b) {
        // TODO Auto-generated method stub
        return null;
    }

    public void delete(Buchung b) {
        // TODO Auto-generated method stub
    }

    private Buchung resultSet2Object(ResultSet rs) throws SQLException {
        Buchung b = new Buchung();

        b.setId(rs.getLong("id"));
        b.setName(rs.getString("name"));
        b.setBetrag(rs.getLong("betrag"));

        return b;
    }
}
