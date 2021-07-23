package pacchetto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {
	
	private static List<Connection> freecon;
	
	static {
		freecon= new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println ("Error: " + e.getMessage());
		}
	}
	
	private static synchronized Connection createDBConnection () throws SQLException{
		
		Connection con= null;
		String ip = "localhost";
		String port = "3306";
		String db = "progetto";
		String username = "root";
		String password = "12345678";
		
		con= DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
		
		con.setAutoCommit(false);
		
		return con;
		
	}
	
	public static synchronized Connection getConnection () throws SQLException {
		
		Connection con;
		
		if (!freecon.isEmpty()) {
			con= (Connection) freecon.get(0);
			freecon.remove(0);
			
			try {
				if (con.isClosed())
					con= getConnection ();
			}
			catch (SQLException e) {
				con.close();
				con= getConnection();
			}
		}
		else {
			con= createDBConnection ();
		}
		
		return con;
		
	}
	
	public static synchronized void relaseConnection (Connection c) throws SQLException{
		if (c != null)
			freecon.add(c);
	}

}