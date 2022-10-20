package DAO;

import java.sql.SQLException;
import org.apache.commons.csv.CSVParser;

/**
 * DAO
 * The DAO interface is used to define the methods that the DAO classes must implement.
 * @author vadiazbailey {@Link https://github.com/vadiazbailey}
 * @version 1.0
 */ 
public interface DAO<T>{
    /**
     * Create
     * The create method is used to create a new record in the database.
     * @param csvParser The CSVParser object that contains the data to be inserted.
     * @throws SQLException
     */
    public void cargar(CSVParser datos) throws SQLException;
    /**
     * Create Table
     * The create table method is used to create a table in the database.
     * @throws SQLException
     */
	public void createTable() throws SQLException;
}
