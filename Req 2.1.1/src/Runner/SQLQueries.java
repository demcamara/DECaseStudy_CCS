package Runner;

public class SQLQueries {
	
	//CODE WORKS//
	public static final String checkAccountDetails =" select * from cdw_sapp_creditcard\r\n" + 
			"left join cdw_sapp_customer\r\n" + 
			"on cdw_sapp_customer.SSN = cdw_sapp_creditcard.CUST_SSN\r\n" + 
			"where CUST_SSN = ? ";
			
			/*" select cdw_sapp_customer.FIRST_NAME, cdw_sapp_customer.MIDDLE_NAME, cdw_sapp_customer.LAST_NAME, \r\n" + 
			"substring(SSN, 5, 4) AS 'SSN', cdw_sapp_customer.CREDIT_CARD_NO,\r\n" + 
			"cdw_sapp_customer.APT_NO, cdw_sapp_customer.STREET_NAME, cdw_sapp_customer.CUST_CITY,\r\n" + 
			"cdw_sapp_customer.CUST_STATE,cdw_sapp_customer.CUST_COUNTRY, cdw_sapp_customer.CUST_ZIP,\r\n" + 
			"cdw_sapp_customer.CUST_PHONE, cdw_sapp_customer.CUST_EMAIL, sum(transaction_value) as 'Transactions YTD',\r\n" + 
			"cdw_sapp_customer.LAST_UPDATED from cdw_sapp_creditcard\r\n" + 
			"left join cdw_sapp_customer\r\n" + 
			"on cdw_sapp_customer.SSN = cdw_sapp_creditcard.CUST_SSN\r\n" + 
			"where CUST_SSN = ? ";*/
	
	public static final String modifyAccountDetails = "update cdw_sapp_customer\r\n"
			+ "set FIRST_NAME = ?, MIDDLE_NAME = ?, LAST_NAME = ?, APT_NO = ?, "
			+ "STREET_NAME = ?, CUST_CITY = ?, CUST_STATE = ?, CUST_COUNTRY = ?, CUST_ZIP = ?, CUST_PHONE = ?, CUST_EMAIL = ?  where SSN = ?";
	//CODE WORKS//
	public static final String getMonthlyBill = "select sum(TRANSACTION_VALUE) as 'Total Value', \r\n" + 
			"CREDIT_CARD_NO, MONTH, YEAR FROM cdw_sapp_creditcard WHERE\r\n" + 
			" CREDIT_CARD_NO = ? AND MONTH = ? AND YEAR = ?\r\n" + 
			"			GROUP BY CREDIT_CARD_NO, MONTH, YEAR";
	
	public static final String getItemizedTrans = " select TRANSACTION_ID, DAY, MONTH, YEAR, substring(CUST_SSN, 5, 4) AS 'SSN', TRANSACTION_TYPE, TRANSACTION_VALUE\r\n" + 
			"from cdw_sapp_creditcard\r\n" + 
			"WHERE CREDIT_CARD_NO = ? " + 
			"AND MONTH = ? AND YEAR = ?";
	//CODE WORKS//
	public static final String displayTransaction = "select cdw_sapp_customer.FIRST_NAME, cdw_sapp_customer.MIDDLE_NAME, cdw_sapp_customer.APT_NO, cdw_sapp_customer.STREET_NAME,cdw_sapp_customer.CUST_CITY,\r\n" + 
			"cdw_sapp_customer.CUST_STATE, cdw_sapp_customer.CUST_ZIP, cdw_sapp_customer.CUST_COUNTRY, cdw_sapp_customer.CUST_EMAIL,\r\n" + 
			"cdw_sapp_customer.CUST_PHONE,cdw_sapp_customer.LAST_NAME, \r\n" + 
			"       cdw_sapp_creditcard.CUST_SSN,cdw_sapp_creditcard.TRANSACTION_TYPE,cdw_sapp_creditcard.CREDIT_CARD_NO,cdw_sapp_creditcard.TRANSACTION_VALUE,cdw_sapp_creditcard.DAY, cdw_sapp_creditcard.MONTH, cdw_sapp_creditcard.YEAR				 \r\n" + 
			"from cdw_sapp_creditcard \r\n" + 
			"LEFT JOIN cdw_sapp_customer \r\n" + 
			"ON cdw_sapp_creditcard.CUST_SSN = cdw_sapp_customer.SSN\r\n" + 
			"where CUST_SSN = ?  AND DAY between ?  AND ? AND MONTH BETWEEN ? AND ? AND YEAR BETWEEN ? AND ?\r\n" + 
			"ORDER BY YEAR, MONTH, DAY DESC";
	
	//CODE WORKS//
	public static final String displayTransByZipCode = "select cdw_sapp_customer.FIRST_NAME, cdw_sapp_customer.MIDDLE_NAME,cdw_sapp_customer.LAST_NAME, cdw_sapp_creditcard.CUST_SSN, cdw_sapp_customer.CUST_ZIP,\r\n" + 
			"			cdw_sapp_creditcard.TRANSACTION_TYPE, cdw_sapp_creditcard.TRANSACTION_VALUE, cdw_sapp_creditcard.BRANCH_CODE, cdw_sapp_creditcard.MONTH, cdw_sapp_creditcard.YEAR  \r\n" + 
			"			from cdw_sapp_creditcard \r\n" + 
			"			left join cdw_sapp_customer \r\n" + 
			"			on cdw_sapp_creditcard.CREDIT_CARD_NO = cdw_sapp_customer.CREDIT_CARD_NO \r\n" + 
			"			WHERE CUST_ZIP = ? order by MONTH DESC";
	
	//CODE WORKS//
	public static final String displayTValuesByTransType = "select TRANSACTION_TYPE, SUM(TRANSACTION_VALUE) as 'Total Values', count(TRANSACTION_TYPE) as 'Number Of Transactions'\r\n" + 
			"from cdw_sapp_creditcard where\r\n" + 
			"TRANSACTION_TYPE = ? group by TRANSACTION_TYPE";
	//CODE WORKS//
	public static final String getTotalTransByState = "SELECT cdw_sapp_branch.BRANCH_STATE, cdw_sapp_creditcard.BRANCH_CODE, SUM(cdw_sapp_creditcard.TRANSACTION_VALUE) AS 'TOTAL VALUE OF TRANSACTIONS', "
		  + "COUNT(cdw_sapp_creditcard.BRANCH_CODE) AS 'NUMBER OF TRANSACTIONS' \r\n" + 
			"FROM cdw_sapp_creditcard \r\n" + 
			"LEFT JOIN cdw_sapp_branch\r\n" + 
			"ON cdw_sapp_branch.BRANCH_CODE = cdw_sapp_creditcard.BRANCH_CODE\r\n" + 
			"where BRANCH_STATE = ?";
	
	

}
