package singleton;

// Database Connector which connects one time
class DatabaseConnector {
	// Static Instance method to hold the global static DatabaseConnector
	private static DatabaseConnector instance;

	private String _connectionstring;

	// Private Constructor can only be called by Method only
	private DatabaseConnector(String connectionstring) {
		this._connectionstring = connectionstring;
	}

	@Override
	public String toString() {
		return "DatabaseConnector [_connectionstring=" + _connectionstring + "]";
	}

	// Method with Synchronized so that it will never get into the Race condition
	public static synchronized DatabaseConnector getInstance() {
		// Returns the Instance.
		if (instance == null) {
			return new DatabaseConnector("PostgresSQL");
		}
		return instance;
	}
	
	

}

public class SingletonPattern {

	public static void main(String[] args) {
		// Getting the Instance
		DatabaseConnector conn1 = DatabaseConnector.getInstance();
		System.out.println(conn1);
		
		// Getting the Second Instance
		DatabaseConnector conn2 = DatabaseConnector.getInstance();
		System.out.println(conn2);
	}

}
