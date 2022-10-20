package DAOFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAO.ClientDAO;
import DAO.InvoiceDAO;
import DAO.InvoiceProductDAO;
import DAO.ProductDAO;

/**
 * ConexionMySQL
 * The ConexionMySQL class is used to connect to the database.
 */
public class ConexionMySQL extends AbstractFactory{

	private static Connection conn;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URI = "jdbc:mysql://localhost:3306/entregables_arqui_web";	
	private static final String USER = "root";
	private static final String PASS = "1993";
	
	// FILMINAS 3 PAGINA 7 
	// Este seria el ConcreteCreator
	
	/**
	 * Conectar
	 * The conectar method is used to connect to the database.
	 * @return Connection
	 */
	public static Connection conectar() {
		try {
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		
		try {
			conn = DriverManager.getConnection(URI, USER, PASS);
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public ClientDAO getDAOClient() throws SQLException {
		return new ClientDAO();
	}

	@Override
	public InvoiceDAO getDAOInvoice() throws SQLException {
		return new InvoiceDAO();
	}

	@Override
	public InvoiceProductDAO getDAOInvoiceProduct() throws SQLException {
		return new InvoiceProductDAO();
	}

	@Override
	public ProductDAO getDAOProduct() throws SQLException {
		return new ProductDAO();
	}

	
}
