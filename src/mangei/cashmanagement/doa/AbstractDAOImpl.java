package mangei.cashmanagement.doa;

import java.sql.Connection;

public abstract class AbstractDAOImpl<T>
	implements AbstractDAO<T> {

	protected Connection connection;

	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
