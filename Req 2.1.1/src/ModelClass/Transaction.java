package ModelClass;

public class Transaction {
	
	public String TRANSACTION_TYPE;
	public String TRANSACTION_VALUE;
	public String CREDIT_CARD_NO;
	public String CUST_SSN;
	public String STATE;
	public int MONTH;
	public int YEAR;
	public int TRANSACTION_ID;
	public String BRANCH_CODE;
	public String CUST_ZIP;
	public String BRANCH_STATE;
	
	
	
	
	public String getBRANCH_STATE() {
		return BRANCH_STATE;
	}
	public void setBRANCH_STATE(String bRANCH_STATE) {
		BRANCH_STATE = bRANCH_STATE;
	}
	public String getCUST_ZIP() {
		return CUST_ZIP;
	}
	public void setCUST_ZIP(String cUST_ZIP) {
		CUST_ZIP = cUST_ZIP;
	}
	public String getTRANSACTION_TYPE() {
		return TRANSACTION_TYPE;
	}
	public void setTRANSACTION_TYPE(String tRANSACTION_TYPE) {
		TRANSACTION_TYPE = tRANSACTION_TYPE;
	}
	public String getTRANSACTION_VALUE() {
		return TRANSACTION_VALUE;
	}
	public void setTRANSACTION_VALUE(String tRANSACTION_VALUE) {
		TRANSACTION_VALUE = tRANSACTION_VALUE;
	}
	public String getCREDIT_CARD_NO() {
		return CREDIT_CARD_NO;
	}
	public void setCREDIT_CARD_NO(String cREDIT_CARD_NO) {
		CREDIT_CARD_NO = cREDIT_CARD_NO;
	}
	public String getCUST_SSN() {
		return CUST_SSN;
	}
	
	public String getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(String bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public void setCUST_SSN(String cUST_SSN) {
		CUST_SSN = cUST_SSN;
	}
	public int getMONTH() {
		return MONTH;
	}
	public void setMONTH(int mONTH) {
		MONTH = mONTH;
	}
	public int getYEAR() {
		return YEAR;
	}
	public void setYEAR(int yEAR) {
		YEAR = yEAR;
	}
	public int getTRANSACTION_ID() {
		return TRANSACTION_ID;
	}
	public void setTRANSACTION_ID(int tRANSACTION_ID) {
		TRANSACTION_ID = tRANSACTION_ID;
	}
	
	

}
