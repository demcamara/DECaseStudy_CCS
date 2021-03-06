SET hive.exec.dynamic.partition = true; 
SET hive.exec.dynamic.partition.mode = nonstrict;

INSERT OVERWRITE TABLE CDW_SAPPCREDITCARD
PARTITION(TRANSACTION_TYPE) 
select  
CUST_CC_NO,
TIMEID,
CUST_SSN,
BRANCH_CODE, 
TRANSACTION_VALUE, 
TRANSACTION_TYPE FROM STAGING_CDW_SAPP_CREDITCARD;