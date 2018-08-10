package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public interface TransactionDAO {
	
	public void displayTransByZipCode(String CUST_ZIP) throws SQLException;
	public void displayTValuesByTransType (String TRANSACTION_VALUE, String TRANSACTION_TYPE) throws SQLException;
	public void getTotalTransByState(String BRANCH_STATE, String BRANCH_CODE, String TRANSACTION_VALUE) throws SQLException;

}
