package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

import Runner.DBConnection;
import Runner.SQLQueries;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public void displayTransByZipCode(String CUST_ZIP) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			
			System.out.println("Database connection successful!\n");
		// 2. Create a statement
		PreparedStatement myStmt1 = con.prepareStatement(SQLQueries.displayTransByZipCode);
			
			myStmt1.setString(1, CUST_ZIP);
			
			
			
// 3. Execute SQL Query
			myRs = myStmt1.executeQuery();
			if (myRs.next() == false) {
				System.out.println("NO AVAILABLE RECORDS: Please review details and try again.");
				}
			
		else {
			System.out.println("CUSTOMER SSN" + "\t\t" + "CUSTOMER ZIP" 
									 + "\t\t" + "BRANCH CODE" + "\t" + "DATE" + "\t\t" + "TRANSACTION VALUE"+ "\t\t" + "TRANSACTION TYPE");	
				
			} 
				// 4. Process the result set
			while (myRs.next()) {
				System.out.print(myRs.getString("CUST_SSN") + "\t\t");  
				//System.out.print(myRs.getString("CUST_SSN") + "\t\t");
				System.out.print(myRs.getString("CUST_ZIP") + "\t\t\t"); 
				
				//System.out.print(myRs.getString("FIRST_NAME") + " " + myRs.getString("LAST_NAME") + "\t\t\t");
				System.out.print(myRs.getString("BRANCH_CODE") + "\t\t");
				System.out.print(myRs.getString("MONTH") + "/" + myRs.getString("YEAR") + "\t\t");
				System.out.print("$" + myRs.getString("TRANSACTION_VALUE") + "\t\t\t\t");
				System.out.println(myRs.getString("TRANSACTION_TYPE"));
			
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (con != null) {
				con.close();
			}
		}
	}
		
		
	

	@Override
	public void displayTValuesByTransType(String TRANSACTION_VALUE, String TRANSACTION_TYPE) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			System.out.println();
			System.out.println("Database connection successful!\n");
		// 2. Create a statement
		PreparedStatement myStmt1 = con.prepareStatement(SQLQueries.displayTValuesByTransType);
			
			myStmt1.setString(1, TRANSACTION_TYPE);
			
			
			
			
			System.out.println();
// 3. Execute SQL Query
			myRs = myStmt1.executeQuery();
			
			if (myRs.next() == false) {
				System.out.println("NO AVAILABLE RECORDS: Please review details and try again.");
			} 
			else {
				System.out.println("TRANSACTION TYPE" + "\t" + "TOTAL VALUE" + "\t\t" + " TOTAL TRANSACTION TYPE");
				System.out.print(myRs.getString("TRANSACTION_TYPE") + "\t\t\t");
				System.out.println("$" + myRs.getString("Total Values") + "\t\t " + myRs.getString("Number Of Transactions"));
				} 
		
			// 4. Process the result set
				while (myRs.next()) {
				//System.out.println("TRANSACTION TYPE" + "\t" + "TOTAL VALUE" + "\t" + " TOTAL TRANSACTION TYPE");
				System.out.print(myRs.getString("TRANSACTION_TYPE") + "\t\t\t");
				System.out.println("$" + myRs.getString("Total Values") + "\t\t " + myRs.getString("Number Of Transactions"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (con != null) {
				con.close();
			}
		}
	}
		
		
		
	

	private String count(String tRANSACTION_TYPE) {
		// TODO Auto-generated method stub
		return null;
	}




	private String sum(String tRANSACTION_VALUE) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void getTotalTransByState(String BRANCH_STATE, String BRANCH_CODE, String TRANSACTION_VALUE) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			
			System.out.println("Database connection successful!\n");
		// 2. Create a statement
		PreparedStatement myStmt1 = con.prepareStatement(SQLQueries.getTotalTransByState);
			
			myStmt1.setString(1, BRANCH_STATE);
			
	
			
			
// 3. Execute SQL Query
			myRs = myStmt1.executeQuery();			
			
			System.out.println("BRANCH_STATE" + "\tBRANCH_CODE" + "\tTOTAL VALUE OF TRANSACTIONS" + "\tNUMBER OF TRANSACTIONS");
			while (myRs.next()) {
				
				System.out.print(myRs.getString("BRANCH_STATE")  + "\t\t");
				System.out.print(myRs.getString("BRANCH_CODE")  + "\t\t"); 
				System.out.print( "$" + myRs.getString("Total Value Of Transactions") + "\t\t\t");
				 System.out.println(myRs.getString("Number Of Transactions"));
				}
				
			}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (con != null) {
				con.close();
			}
		}
	}
		
		
		
	}


