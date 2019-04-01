package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	private String url = "jdbc:mysql://localhost:3306/vehicule";
	private String username = "root";
	private String password = "root";
	private static Connexion instance = null;
	private Connection cn;
	public static Connexion getInstance() {
	if (instance == null) {
	instance = new Connexion();
	}
	return instance;
	}
	public Connexion() {
	this.connect();
	}
	public void connect() {
	 try {
	Class.forName("com.mysql.jdbc.Driver");

	cn = DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
	}
	}
	public Connection getCnx() {
	return cn;
	}
	public void disconnect() {
	try {
	if (cn != null)
	((Connection) cn).close();
	} catch (Exception e) {
	}
	}

}
