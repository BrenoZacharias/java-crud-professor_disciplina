package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

	private Connection c;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String hostName = "localhost";
		String dbName = "dbvideojavafx";

		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		
//		jdbc:jtds:sqlserver://dbserver.domain.tld:1433/ApplicationDB;USENTLMV2=true 
//		jdbc:jtds:<server_type>://<server>[:<port>][/<database>][;<property>=<value>[;...]] 
			
//integratedSecurity=True;
		
		c = DriverManager.getConnection(
				String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=sa;password=123456", 
						hostName, dbName));

		return c;
		
//		“jdbc:jtds:sqlserver://NOTE/database;instance=instancia”
		
		
	}
	
	
}
