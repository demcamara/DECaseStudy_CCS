SET hive.exec.dynamic.partition = true; 
SET hive.exec.dynamic.partition.mode = nonstrict;

INSERT OVERWRITE TABLE CDW_SAPPTIME
PARTITION(QUARTER) 
select  
TIMEID,
DAY,
MONTH,
YEAR, 
QUARTER FROM STAGING_CDW_SAPP_TIME;