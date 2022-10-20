package DAO;
import Model.ProductModel;
import DAOFactory.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * ProductDAO
 * The product DAO is used to manage the products in the database.
 * @author vadiazbailey {@Link  https://github.com/vadiazbailey}
 * @version 1.0
 */
public class ProductDAO implements DAO <ProductModel>{
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
		String insert = "INSERT INTO product "+
                        "(productId, name, value) "+ 
                        "VALUES (?, ?, ?)"; 
		for(CSVRecord fila: datos) {
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setInt(1, Integer.parseInt(fila.get("idProducto")));
			ps.setString(2, fila.get("nombre"));
			ps.setFloat(3, Float.parseFloat(fila.get("valor")));
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

		String product = "CREATE TABLE product(" +
                                "productId INT," +
                                "name VARCHAR(45)," +
                                "value FLOAT," +
                                "PRIMARY KEY (productId))";
		connection.prepareStatement(product).execute();
		connection.commit();
		connection.close();
    }

    /**
     * This function shows the product that raised the most 
     * @return the product that collects the most
     * @throws SQLException
     */
    public ProductModel highestGrossingProduct () throws SQLException{
        //we established the connection
        connection = ConexionMySQL.conectar();

        //I create a variable to save the product that I collect the most
        ProductModel highestGrossingProduct = null;

        String product = "select p.productId, p.name, sum(p.value * ip.quantity) as recaudo "+
                         "from product p "+
                         "inner join invoice_product ip "+
                         "group by p.productId "+
                         "order by recaudo desc "+
                         "limit 1 ";

        PreparedStatement query = connection.prepareStatement(product);
        ResultSet result = query.executeQuery();

        while(result.next()) {
			      highestGrossingProduct = new ProductModel(result.getInt(1), 
                                                      result.getString(2), 
                                                      result.getFloat(3));
		    }
		
		query.close();
		result.close();
		connection.close();
		return highestGrossingProduct;
    }
} 
