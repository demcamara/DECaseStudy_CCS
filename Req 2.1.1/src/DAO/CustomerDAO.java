package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerDAO {
	

	public void generateBill(String CREDIT_CARD_NO, int MONTH, int YEAR) throws SQLException;
	public void displayTransaction(int CUST_SSN, int DAY, int DAY1, int MONTH,int MONTH1,int YEAR, int YEAR1) throws SQLException;
	public void checkAccountDetails(int SSN) throws Exception;
	public void modifyAccountDetails(String FIRST_NAME, String MIDDLE_NAME, String LAST_NAME, String APT_NO,
			String STREET_NAME, String CUST_CITY, String CUST_STATE, String CUST_COUNTRY,String CUST_ZIP, int CUST_PHONE,
			String CUST_EMAIL, int SSN) throws SQLException;

}
