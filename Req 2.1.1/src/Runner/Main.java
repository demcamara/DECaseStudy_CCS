package Runner;

import java.util.*;
import ModelClass.Customer;

import java.util.Scanner;
import java.sql.*;
import DAO.CustomerDAOImpl;
import DAO.TransactionDAOImpl;
import DAO.CustomerDAOImpl;
import DAO.CustomerDAOImpl;
public class Main {
	
	static Connection myConn = null;
	static CustomerDAOImpl customerDAOImp;
	static TransactionDAOImpl transactionDAOImp;
	

	public static void main(String[] args) throws Exception  {
			
		
		String Option = " ";
		String A;
		int SSN;
		int CUST_SSN;
		int number;
		String FIRST_NAME = "";
		String MIDDLE_NAME = " ";
		String LAST_NAME = " ";
		String CREDIT_CARD_NO = " ";
		String STREET_NAME = " ";
		String CUST_CITY = " ";
		String APT_NO = " ";
		String CUST_STATE = " ";
		String CUST_COUNTRY = " ";
		String CUST_ZIP = " ";
		String CUST_EMAIL = " ";
		String LAST_UPDATED = " ";
		int CUST_PHONE = 0;
		int MONTH, MONTH1 = 0;
		int YEAR, YEAR1 = 0;
		int DAY, DAY1 = 0;
		String BRANCH_STATE = " ";
		String STATE = " ";
		String TRANSACTION_TYPE = " ";
		String BRANCH_CODE = " ";
		String TRANSACTION_VALUE = " ";
		
		// USER MENU************************************************************************************
		
		System.out.println("Welcome to DE Bank!");
		System.out.println();
		System.out.println("To better assist you, please choose from the following options by entering the corresponding number : ");
		System.out.println();
		System.out.println();
		
		
		System.out.println("CUSTOMER INQUIRY ");
		System.out.println("************************************************************************ ");
		System.out.println("1) Retrieve customer account details " );		
		System.out.println("2) Update existing customer details");
		System.out.println("3) Generate customer monthly billing details ");
		System.out.println("4) Display transaction(s) made by a customer between two dates ");
		System.out.println();
		System.out.println("************************************************************************ ");
		System.out.println();
		System.out.println();
		System.out.println("TRANSACTION INQUIRY ");
		System.out.println("************************************************************************ ");
		System.out.println("5) Obtain transaction(s) made by customers in a given zipcode " );		
		System.out.println("6) Display number and total values of transactions for a given type");
		System.out.println("7) Display number and total values of transactions for branches by state ");
		System.out.println();
		System.out.println("************************************************************************ ");
		
		
		//****************************************************************************************************
		System.out.println();
		Scanner in = new Scanner(System.in);
		Option = in.nextLine();
		
		switch(Option) {
		case "1" :
			System.out.println();
			System.out.println("Thank you for the information. You've selected to retrieve customer account details");
			System.out.println();
			System.out.println("Please Enter Customer's SSN");
			Scanner two = new Scanner(System.in);
			SSN = two.nextInt();
			
			CustomerDAOImpl customer = new CustomerDAOImpl();
			customer.checkAccountDetails(SSN);
			
			
			break;
			
		case "2" :
			System.out.println();
			System.out.println("Thank you for the information. You've selected to update customer account details");
			System.out.println();
			System.out.println("To begin, please enter customer SSN");
					
				Scanner five = new Scanner(System.in);
				SSN = five.nextInt();
				boolean isSSN;
				if(Integer.toString(SSN).length() >= 10 || Integer.toString(SSN).length()<= 8) 
				{ 
					System.out.println("Please enter a valid SSN");
					do {
						SSN= five.nextInt();
						isSSN = (Integer.toString(SSN).length()) == 9;
						if(!isSSN) 
						{
							System.out.println("Please enter a valid SSN");
						}
					}while (!isSSN);
				}
					System.out.println();

					System.out.println("OK. Please update customer's First Name");
					Scanner a = new Scanner(System.in);
					FIRST_NAME = a.nextLine();
					
					System.out.println("Please update customer's Middle Name");
					Scanner b = new Scanner(System.in);
					MIDDLE_NAME = b.nextLine();
					System.out.println();
					
					System.out.println("Please update customer's Last Name");
					Scanner c = new Scanner(System.in);
					LAST_NAME = c.nextLine();
					System.out.println();
					
					System.out.println("Please update customer's Apartment Number");
					Scanner d = new Scanner(System.in);
					APT_NO = d.nextLine();
					System.out.println();
					
					System.out.println("Please update customer's Street Name");
					Scanner e = new Scanner(System.in);
					STREET_NAME = e.nextLine();
					System.out.println();
											
					System.out.println("Please update customer's City");
					Scanner f = new Scanner(System.in);
					CUST_CITY = f.nextLine();
					System.out.println();
					
					System.out.println("Please update customer's State");
					Scanner g = new Scanner(System.in);
					CUST_STATE = g.nextLine();
					System.out.println();
										
					System.out.println("Please update customer's Country");
					Scanner h = new Scanner(System.in);
					CUST_COUNTRY = h.nextLine();
					System.out.println();
					
					System.out.println("Please update customer's Zip Code");
					Scanner j = new Scanner(System.in);
					CUST_ZIP = j.nextLine();
					System.out.println();	
					boolean isCUST_ZIP;
					if(CUST_ZIP.length() > 5 || CUST_ZIP.length() < 5) 
					{ 
						System.out.println("Please enter a valid 5-digit zipcode");
						do {
							CUST_ZIP= j.nextLine();
							isCUST_ZIP = (CUST_ZIP.length() == 5);
							if(!isCUST_ZIP) 
							{
								System.out.println("Please enter a valid 5-digit zipcode");
							}
						}while (!isCUST_ZIP);
					}
					
					System.out.println("Please update customer's Phone Number");
					Scanner k = new Scanner(System.in);
					CUST_PHONE =Integer.parseInt(k.nextLine());
					System.out.println();
					
					System.out.println("Please update customer's Email");
					Scanner i = new Scanner(System.in);
					CUST_EMAIL = i.nextLine();
					System.out.println();
					
					System.out.println("Please update customer's SSN");
					SSN = five.nextInt();
					System.out.println();
					boolean isSSN1;
					if(Integer.toString(SSN).length() >= 10 || Integer.toString(SSN).length()<= 8) 
					{ 
						System.out.println("Please enter a valid SSN");
						do {
							SSN= five.nextInt();
							isSSN = (Integer.toString(SSN).length()) == 9;
							if(!isSSN) 
							{
								System.out.println("Please enter a valid SSN");
							}
						}while (!isSSN);
					}
					
					
					
					CustomerDAOImpl updateInfo = new CustomerDAOImpl();
					updateInfo.modifyAccountDetails(FIRST_NAME, MIDDLE_NAME, LAST_NAME, APT_NO, STREET_NAME, CUST_CITY, CUST_STATE, 
							CUST_COUNTRY, CUST_ZIP, CUST_PHONE, CUST_EMAIL, SSN);
					
					break; 
			
					
			
		case "3" :
			System.out.println();
			System.out.println("Thank you for the information. You've selected to look up customer monthly bill");
			System.out.println();
			
			System.out.println("Please Enter Customer's credit card number");
			Scanner six = new Scanner(System.in);
			CREDIT_CARD_NO = six.nextLine();
			
			System.out.println("Please Enter the month");
			Scanner seven = new Scanner(System.in);
			MONTH = seven.nextInt();
			
			System.out.println("Please Enter the year");
			Scanner eight = new Scanner(System.in);
			YEAR = eight.nextInt();
			
			CustomerDAOImpl monthlyBill = new CustomerDAOImpl();
			monthlyBill.generateBill(CREDIT_CARD_NO, MONTH, YEAR);
			break;
			
		case "4" :
			System.out.println();
			System.out.println("Thank you for the information. You've selected to obtain a customer's transactions between two dates");
			System.out.println();
			
			System.out.println("Please Enter Customer's SSN");
		Scanner nine = new Scanner(System.in);
			CUST_SSN = nine.nextInt();
			boolean isCUST_SSN;
			if(Integer.toString(CUST_SSN).length()>= 10 || Integer.toString(CUST_SSN).length()<= 8) 
			{ 
				System.out.println("Please enter a valid customer SSN");
				do {
					CUST_SSN= nine.nextInt();
					isCUST_SSN = (Integer.toString(CUST_SSN).length()) == 9;
					if(!isCUST_SSN) 
					{
						System.out.println("Please enter a valid customer SSN");
					}
				}while (!isCUST_SSN);
			}
			
			System.out.println("Please Enter Beginning day");
			
			 DAY = nine.nextInt();
				boolean isDAY;
				if(DAY >= 32 || DAY <= 0) 
				{ 
					System.out.println("Please enter a valid day");
					do {
						DAY = nine.nextInt();
						isDAY = (DAY >=1 && DAY <= 31);
						if(!isDAY) 
						{
							System.out.println("Please enter a valid day");
						}
					}while (!isDAY);
				}
			System.out.println("Ending day");
			
			DAY1 = nine.nextInt();
			boolean isDAY1;
				if(DAY1 >= 32 || DAY1 <= 0) 
				{ 
					System.out.println("Please enter a valid day");
					do {
						DAY1 = nine.nextInt();
						isDAY1 = (DAY1 >=1 && DAY <= 31);
						if(!isDAY1) 
						{
							System.out.println("Please enter a valid day");
						}
					}while (!isDAY1);
				}
			System.out.println("Please Enter Beginning month");
	
			MONTH = nine.nextInt();
			boolean isMONTH;
			if(MONTH <= 0 || MONTH >= 13) 
			{ 
				System.out.println("Please enter a valid month");
				do {
					MONTH = nine.nextInt();
					isMONTH = (MONTH >= 1 && MONTH <= 12);
					if(!isMONTH) 
					{
						System.out.println("Please enter a valid month");
					}
				}while (!isMONTH);
			}
			System.out.println("Ending month");
			
			MONTH1 = nine.nextInt();
			boolean isMONTH1;
			if(MONTH1 <= 0 || MONTH1 >= 13) 
			{ 
				System.out.println("Please enter a valid month");
				do {
					MONTH1 = nine.nextInt();
					isMONTH1 = (MONTH1 >= 1 && MONTH1 <= 12);
					if(!isMONTH1) 
					{
						System.out.println("Please enter a valid month");
					}
				}while (!isMONTH1);
			}
		
			System.out.println("Please Enter Beginning year(YYYY) ");
			
			YEAR = nine.nextInt();
			boolean isYEAR;
			if(Integer.toString(YEAR).length() <= 3 || Integer.toString(YEAR).length() >= 5) 
			{ 
				System.out.println("Please enter a valid year in the following format YYYY");
				do {
					YEAR = nine.nextInt();
					isYEAR = (Integer.toString(YEAR).length() == 4);
					if(!isYEAR) 
					{
						System.out.println("Please enter a valid year in the following format YYYY");
					}
				}while (!isYEAR);
			}
			System.out.println("Ending year");
			Scanner ten = new Scanner(System.in);
			YEAR1 = ten.nextInt();
			boolean isYEAR1;
			if(Integer.toString(YEAR1).length() <= 3 || Integer.toString(YEAR1).length() >= 5) 
			{ 
				System.out.println("Please enter a valid year in the following format YYYY");
				do {
					YEAR1 = nine.nextInt();
					isYEAR1 = (Integer.toString(YEAR1).length() == 4);
					if(!isYEAR1) 
					{
						System.out.println("Please enter a valid year in the following format YYYY");
					}
				}while (!isYEAR1);
			}
			
			CustomerDAOImpl displayTransaction = new CustomerDAOImpl();
			displayTransaction.displayTransaction(CUST_SSN, DAY, DAY1, MONTH, MONTH1, YEAR, YEAR1);
			
			break;
				
				
				
		case "5" :
			System.out.println();
			System.out.println("Thank you for the information. You've selected to display transactions of customers living in a given zipcode ");
			System.out.println();
			System.out.println("Please enter the zipcode for which you would like to look up");
			Scanner scanner = new Scanner(System.in);
			CUST_ZIP = scanner.nextLine();
			boolean isCUST_ZIP1;
			if(CUST_ZIP.length() > 5 || CUST_ZIP.length() < 5) 
			{ 
				System.out.println("Please enter a valid 5-digit zipcode");
				do {
					CUST_ZIP= scanner.nextLine();
					isCUST_ZIP = (CUST_ZIP.length() == 5);
					if(!isCUST_ZIP) 
					{
						System.out.println("Please enter a valid 5-digit zipcode");
					}
				}while (!isCUST_ZIP);
			}
			
			TransactionDAOImpl transbyzip = new TransactionDAOImpl();
			transbyzip.displayTransByZipCode(CUST_ZIP);
			break;
			
		case "6" :
			System.out.println();
			System.out.println("Thank you for the information. You've selected to display total values based on transaction type ");
			System.out.println();
			System.out.println("Please enter the transaction type for which you would like to look up");
			Scanner scanner1 = new Scanner(System.in);
			TRANSACTION_TYPE = scanner1.nextLine();
			
			TransactionDAOImpl transtype = new TransactionDAOImpl();
			transtype.displayTValuesByTransType(TRANSACTION_VALUE, TRANSACTION_TYPE);
			
			break;
			
		case "7" :
			System.out.println();
			System.out.println("Thank you for the information. You've selected to get the number and total value of transaction for a branch in a given state");
			System.out.println();
			
			System.out.println("Please Enter the branch state");
			Scanner eleven = new Scanner(System.in);
			BRANCH_STATE = eleven.nextLine();
			boolean isBRANCH_STATE;
			if(BRANCH_STATE.length() > 2 || BRANCH_STATE.length() < 2) 
			{ 
				System.out.println("Please enter a valid 2-letter state code");
				do {
					BRANCH_STATE = eleven.nextLine();
					isBRANCH_STATE = (BRANCH_STATE.length() == 2);
					if(!isBRANCH_STATE) 
					{
						System.out.println("Please enter a valid 2-letter state code");
					}
				}while (!isBRANCH_STATE);
			}
			
			
			TransactionDAOImpl transbranch = new TransactionDAOImpl();
			transbranch.getTotalTransByState(BRANCH_STATE, BRANCH_CODE, TRANSACTION_VALUE);
			break;
			
			
				
				
				}
	

	}



	
}




				
				


				
				
				
			
			
		


	




	


