package mangei.cashmanagement.dao;

import java.sql.Connection;
import java.util.List;

public interface AbstractDAO <T> {

	public Connection getConnection();	
	public void setConnection(Connection connection);
	
	public List<T> getAll();
	public T get(Long id);
	public T save();
	public void delete(T t);
	
}
