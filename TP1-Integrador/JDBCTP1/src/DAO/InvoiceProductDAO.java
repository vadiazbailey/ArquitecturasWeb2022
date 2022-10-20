package DAO;
import Model.InvoiceProductModel;
import DAOFactory.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * InvoiceProductDAO
 * The invoice product DAO is used to manage the invoice products in the database.
 * @author vadiazbailey {@Link  https://github.com/vadiazbailey}
 * @version 1.0
 */
public class InvoiceProductDAO implements DAO <InvoiceProductModel>{
     private Connection connection;

    /**
     * Create
     * The create method is used to create a new record in the database.
     * @param csvParser The CSVParser object that contains the data to be inserted.
     * @throws SQLException
     */
    @Override
    public void cargar(CSVParser datos) throws SQLException {
        connection = ConexionMySQL.conectar();
		String insert = "INSERT INTO invoice_product "+
                        "(invoiceId, productId, quantity) "+ 
                        "VALUES (?, ?, ?)"; 
		for(CSVRecord fila: datos) {
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setInt(1, Integer.parseInt(fila.get("idFactura")));
			ps.setInt(2, Integer.parseInt(fila.get("idProducto")));
			ps.setInt(3, Integer.parseInt(fila.get("cantidad")));
			ps.executeUpdate();
			connection.commit();
			ps.close();
		}
		connection.close();
    }

    /**
     * Create Table
     * The create table method is used to create a table in the database.
     * @throws SQLException
     */
    @Override
    public void createTable() throws SQLException {
        connection = ConexionMySQL.conectar();
 
		String invoiceProduct = "CREATE TABLE invoice_product(" +
                                "invoiceId INT," +
                                "productId INT," +
                                "quantity INT," +
                                "PRIMARY KEY (invoiceId, productId), "+
                                "FOREIGN KEY(invoiceId)" +
                                "references invoice(invoiceId)," +
                                "FOREIGN KEY(productId)" +
                                "references product(productId))";
		connection.prepareStatement(invoiceProduct).execute();
		connection.commit();
		connection.close();
    }
}
