SET hive.exec.dynamic.partition = true; 
SET hive.exec.dynamic.partition.mode = nonstrict;

INSERT OVERWRITE TABLE CDW_SAPPCUSTOMER
PARTITION(CUST_STATE) 
select 
CUST_SSN,
CUST_F_NAME,
CUST_M_NAME,
CUST_L_NAME,
CUST_CC_NO,
CUST_STREET,
CUST_CITY,
CUST_COUNTRY, 
CUST_ZIP,
CUST_PHONE,
CUST_EMAIL,
LAST_UPDATED,
CUST_STATE FROM STAGING_CDW_SAPPCUSTOMER;