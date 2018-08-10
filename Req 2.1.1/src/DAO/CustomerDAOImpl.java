package DAO;
import ModelClass.Customer;
import Runner.DBConnection;
import Runner.SQLQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;



public class CustomerDAOImpl  implements CustomerDAO{
	
	int updated = 0;
	
	@Override
	public void checkAccountDetails(int SSN) throws Exception   {
		
		Connection con = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
					 myStmt = con.prepareStatement(SQLQueries.checkAccountDetails);
						
						myStmt.setInt(1, SSN);
						
		   
			// 3. Execute SQL Query
						myRs = myStmt.executeQuery();
						
				
						// 4. Process the result set
					if (myRs.next() == false) {
							System.out.println("NO AVAILABLE RECORDS: Please review details and try again.");
							}
						
					else {
					
								
								
								System.out.println("Name : "  + myRs.getString("FIRST_NAME") + " "  +myRs.getString("MIDDLE_NAME")  + " "+ myRs.getString("LAST_NAME"));
								System.out.println("Address : " + myRs.getString("APT_NO") + " "	+ myRs.getString("STREET_NAME") );
								System.out.println(myRs.getString("CUST_CITY") + " " + myRs.getString("CUST_STATE") + "," + " " + myRs.getInt("CUST_ZIP"));
								System.out.println(myRs.getString("CUST_COUNTRY"));
								System.out.println("Phone: " + myRs.getInt("CUST_PHONE")); 
								System.out.println("Email : " + myRs.getString("CUST_EMAIL"));
								System.out.println("Credit Card Number : " + myRs.getString("CREDIT_CARD_NO")); 
								System.out.println();
								System.out.println();
								//System.out.println("I was here");
								System.out.println("TRANSACTION ID" + "\t" + "DATE"  + "\t" + "\t" + "BRANCH CODE" + "\t" + "TRANSACTION TYPE" + "\t" + "TRANSACTION VALUE");	
								
					while (myRs.next()) {						
							System.out.print(myRs.getString("TRANSACTION_ID") + "\t" + "\t");
							System.out.print( myRs.getString("DAY") + "/" + myRs.getString("MONTH") + "/"+ myRs.getString("YEAR") + "\t");
							System.out.print(myRs.getString("BRANCH_CODE") + "\t" + "\t");
							System.out.print(myRs.getString("TRANSACTION_VALUE") + "\t"+ "\t" + "\t"); 
							System.out.println( myRs.getString("TRANSACTION_TYPE"));
							
							
							}	 		
	
						}	
	
		}			catch (Exception exc) {
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
	public void modifyAccountDetails(String FIRST_NAME, String MIDDLE_NAME, String LAST_NAME, String APT_NO,
			String STREET_NAME, String CUST_CITY, String CUST_STATE, String CUST_COUNTRY, String CUST_ZIP, int CUST_PHONE, String CUST_EMAIL, int SSN) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
				
		PreparedStatement myStmt1 = con.prepareStatement(SQLQueries.modifyAccountDetails );
			
			
		  // 3. Execute SQL Query
			
					
					myStmt1.setString(1, FIRST_NAME);
					myStmt1.setString(2, MIDDLE_NAME);
					myStmt1.setString(3, LAST_NAME);
					myStmt1.setString(4, APT_NO);
					myStmt1.setString(5, STREET_NAME);
					myStmt1.setString(6, CUST_CITY);
					myStmt1.setString(7, CUST_STATE);
					myStmt1.setString(8, CUST_COUNTRY);
					myStmt1.setString(9, CUST_ZIP);
					myStmt1.setInt(10, CUST_PHONE);
					myStmt1.setString(11, CUST_EMAIL);
					myStmt1.setInt(12, SSN);

					
			//	System.out.println("sql query " + myStmt1.toString());
				
					myStmt1.executeUpdate();
							
						updated = myStmt1.executeUpdate();
						if (updated > 0) {
							System.out.println("RECORD UPDATED!");
							
							String query3 = "select * from cdw_sapp_customer where SSN = " + SSN;
							ResultSet rs = myStmt1.executeQuery(query3);
							System.out.println();
							
						
							while (rs.next()) {
								System.out.println("Name : "  + rs.getString("FIRST_NAME") + " "  + rs.getString("MIDDLE_NAME")  + " "+ rs.getString("LAST_NAME"));
								System.out.println("Address : " + rs.getString("APT_NO") + " "	+ rs.getString("STREET_NAME") );
								System.out.println(rs.getString("CUST_CITY") + " " + rs.getString("CUST_STATE") + "," + " " + rs.getInt("CUST_ZIP"));
								System.out.println(rs.getString("CUST_COUNTRY"));
								System.out.println("Phone : " + rs.getInt("CUST_PHONE")); 
								System.out.println("Email : " + rs.getString("CUST_EMAIL"));
								System.out.println("Last Updated : " + rs.getString("LAST_UPDATED"));
								
							}
						
									
									
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

		
		
	

	private void displayCustomer(Connection con, String sSN) {
		// TODO Auto-generated method stub
		
	}




	private void displayCustomer() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void generateBill(String CREDIT_CARD_NO, int MONTH, int YEAR) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			
			System.out.println("Database connection successful!\n");
		// 2. Create a statement
	//	PreparedStatement myStmt1 = con.prepareStatement(SQLQueries.getMonthlyBill);
		PreparedStatement myStmt2 = con.prepareStatement(SQLQueries.getItemizedTrans);
		
			
			myStmt2.setString(1, CREDIT_CARD_NO);
			myStmt2.setInt(2, MONTH);
			myStmt2.setInt(3, YEAR);
			
		//	System.out.println("sql query " + myStmt1.toString());
			
// 3. Execute SQL Query
			//myRs = myStmt1.executeQuery();
			ResultSet myRs2 = myStmt2.executeQuery();
			
			if (myRs2.next() == false) {
				System.out.println("NO AVAILABLE RECORDS: Please review details and try again.");
				}
		
			
		else {
			System.out.println("TRANSACTION ID" + "\t\t" + "TRANSACTION DATE"  + "\t" + "LAST 4 OF SSN" + "\t\t" + "TRANSACTION TYPE" + "\t" + "TRANSACTION VALUE");
			
			while(myRs2.next()) {
				System.out.print(myRs2.getString("Transaction_ID") + "\t\t\t " );
			   System.out.print(myRs2.getInt("DAY") + "/" + myRs2.getInt("MONTH") + "/" + myRs2.getInt("YEAR") + "\t\t " ); 
				System.out.print(myRs2.getString("SSN") + "\t\t\t ");
				System.out.print(myRs2.getString("TRANSACTION_TYPE") + "\t\t\t ");
				System.out.println(myRs2.getString("TRANSACTION_VALUE"));
			}
			
		
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
	public void displayTransaction(int CUST_SSN, int DAY,int DAY1, int MONTH, int MONTH1, int YEAR, int YEAR1) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			
			System.out.println("Database connection successful!\n");
		// 2. Create a statement
		PreparedStatement myStmt1 = con.prepareStatement(SQLQueries.displayTransaction);
			
			//PreparedStatement myStmt1 = con.prepareStatement("select * from cdw_sapp_customer where SSN = ?");
			myStmt1.setInt(1, CUST_SSN);
			myStmt1.setInt(2, DAY); 
			myStmt1.setInt(3, DAY1);
			myStmt1.setInt(4, MONTH);
			myStmt1.setInt(5, MONTH1);
			myStmt1.setInt(6, YEAR);
			myStmt1.setInt(7, YEAR1);
			
		//	System.out.println("sql query " + myStmt1.toString());
// 3. Execute SQL Query
			myRs = myStmt1.executeQuery();
			if (myRs.next() == false) {
				System.out.println("NO AVAILABLE RECORDS: Please review details and try again.");
			}
			else {
				System.out.println("CUSTOMER DETAILS");
				System.out.println();
				System.out.println("Name : "  + myRs.getString("FIRST_NAME") + " "  +myRs.getString("MIDDLE_NAME")  + " "+ myRs.getString("LAST_NAME"));
				System.out.println("Address : " + myRs.getString("APT_NO") + " "	+ myRs.getString("STREET_NAME") );
				System.out.println(myRs.getString("CUST_CITY")  + " " + myRs.getString("CUST_STATE") + "," + " "+ myRs.getInt("CUST_ZIP"));
				System.out.println(myRs.getString("CUST_COUNTRY"));
				System.out.println("Phone: " + myRs.getInt("CUST_PHONE")); 
				System.out.println("Email : " + myRs.getString("CUST_EMAIL"));
				System.out.println("Credit Card Number : " + myRs.getString("CREDIT_CARD_NO")); 
				System.out.println();
				System.out.println("DATE" + "\t\t" + "TRANSACTION VALUE" + "\t" + "TRANSACTION TYPE");
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.print(myRs.getInt("DAY")+ "/" + myRs.getInt("MONTH")+ "/" + myRs.getString("YEAR") + "\t");
				System.out.print("$" + myRs.getString("TRANSACTION_VALUE") + "\t\t\t ");
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
		


	public String verifyAccountDetails(String SSN) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// 1. Get a connection to database
			con = DBConnection.getConnection();
			
			//System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
					//PreparedStatement myStmt2 = con.prepareStatement(SQLQueries.checkAccountDetails);
						PreparedStatement myStmt2 = con.prepareStatement("select FIRST_NAME, MIDDLE_NAME, LAST_NAME from cdw_sapp_customer where SSN = ?");
						myStmt2.setString(1, SSN);
		  // 3. Execute SQL Query
						myRs = myStmt2.executeQuery();
						//System.out.println("Do you wish to update account details for the following customer ?");
						
						// 4. Process the result set
						while (myRs.next()) {
							System.out.println(myRs.getString("FIRST_NAME") + ", " + myRs.getString("MIDDLE_NAME") + ", " + myRs.getString("LAST_NAME") );
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
		return null;
				}

	}
	



	