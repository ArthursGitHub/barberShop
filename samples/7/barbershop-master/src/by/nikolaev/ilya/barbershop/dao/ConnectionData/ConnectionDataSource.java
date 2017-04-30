package by.nikolaev.ilya.barbershop.dao.Connectiondata;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDataSource {
	private final static String CONTEXT_LOOK_UP = "java:comp/env/jdbc/nikolaev";
	static Connection connection = null;
	static {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(CONTEXT_LOOK_UP);
			connection = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
