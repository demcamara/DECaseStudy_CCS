# DECaseStudy_CCS
CREDIT CARD MANAGEMENT SYSTEM - CASE STUDY
PLATFORM BY PERSCHOLAS - INSTITUTION

COHORT : DATA ENGINEERING

AUTHOR : MOHAMED CAMARA

OVERVIEW : 
Overview: Students are to create a java program that would take user input and fetch a database for records based on user requests. 
Records must display to the user in an interactive fashion. In the second part of the case study,  students must use big data concepts 
and tools to import records from that database, both existing and newly added ones into the Hadoop Ecosystem.
Students will then manage the data by storing them in tables and creating reports. 

Applications: JAVA, JDBC, MySQL, Sqoop, Hive, Oozie 
To run the programs in the following pages, the applications above must be available on an operating system 
and paths must be created in HDFS where necessary.


------------------------------------------------------------------------
Req 2.1.1 - CORE JAVA
------------------------------------------------------------------------
JDBC Connectivity with RDBMS : Eclipse and MySQL

Eclipse Packages :
DAO - 
CustomerDAO 
TransactionDAO
CustomerDAOImpl
TransactionDAOImpl

ModelClass - 
Customer class 
Transaction class

Runner - 
CustomerRunner
TransactionRunner 
SQLQueries 
Main 
DBConnection

MySQL Database :
Name - 
CDW_SAPP 

Tables - 
CDW_SAPP_CUSTOMER
CDW_SAPP_CREDITCARD
CDW_SAPP_BRANCH


--------------------------------------------------------------------------
Req 2.2.1 - Data Modeling/ETL
--------------------------------------------------------------------------
Data extraction, transformation and transportation : HDFS and Sqoop


HDFS : 
Known as Hadoop Distributed File Management System, data extracted 
using Sqoop was stored in the system at directories specified in each 
Sqoop command.

Sqoop : 
Transfers bulk data between Hadoop and structured datastores 
such as relational databases. (Hortonworks)
Application used on the command line interface

File names
sqoopImportCDW_SAPP_BRANCH.txt
sqoopImportCDW_SAPP_CREDITCARD.txt
sqoopImportCDW_SAPP_CUSTOMER.txt
sqoopImportCDW_SAPP_TIME.txt


----------------------------------------------------------------------------
Req 2.2.2 - Data Loading 
----------------------------------------------------------------------------
Loaded extracted data into tables : HIVE


HIVE :
Datawarehouse software that facilitates reading, writing and managing
large datasets residing in distributed storage using SQL.(hive.apache.org)
Tables were created from the sqoop imports above.

File names
tableCDW_SAPP_BRANCH.txt
tableCDW_SAPP_CREDITCARD.txt 
tableCDW_SAPP_CUSTOMER.txt
tableCDW_SAPP_TIME.txt

----------------------------------------------------------------------------
Req 2.2.3 - Process Automation
----------------------------------------------------------------------------
Automating processes in Req 2.2.1 and Req 2.2.2 : Oozie


1) Oozie Workflow:
Workflow scheduler system to manage Hadoop jobs. Oozie jobs are Directed
Acyclical Graphs (DAGs) of actions.(oozie.apache.org)

1_OozieWorkflows folder : 4 folders
   1 folder for each table  
e.g. 1_OozieWorkflows>OozieWorkflowCDW_SAPP_BRANCH>
     						                                   BranchSqoopJob.txt
     						                                   OozieWorkflowBranch.xml
     						                                   branchJob.properties
     						                                   cdw_sapp_branch.hive
      						                                 copyBranchData.hql
      						                                 internal_table.hive

2) Oozie Coordinator:
Oozie workflow jobs triggered by time(frequency) and data availability.
(oozie.apache.org)

2_CoordinatorWorkflows folder : 5 folders
    WorkflowCombined
      CombinedWorkflow.xml
      Coor_CombinedWorkflowJob.properties
      Coordinator_CombinedWorkflow.xml
    1 folder for each table 
e.g 2_CoordinatorWorkflows>branchCoordinatorWorkflow> 
                                                      OozieBranchCoordinator.xml
                                                      branchCoordinatorJob.properties

------------------------------------------------------------------------------------
Req 2.2.4 - Process Optimization
------------------------------------------------------------------------------------
Optimizing automated processes in Req 2.2.3 : Oozie
Here, only new data is appended to the tables in HIVE.
 

1_OozieAppendWorkflows : 4 folders
   1 folder for each table
e.g. 1_OozieAppendWorkflows>BranchAppendWorkflow>
						                                     AppendBranchWorkflowJob.properties
                                                 OozieAppendBranchCoordinator.xml
                                                 OozieAppendBranchWorkflow.xml
                                                 SqoopAppendBranchJob.txt
                                                 branchAppendCoordJob.properties

2_OptimizedCoordinator : 4 files
Optimizes the process above using one coordinator


File names
CombinedAppendWorkflow.xml
OptimizedCoordinator.xml
combinedAppendWorkflowJob.properties
optimizedCoordinatorJob.properties

------------------------------------------------------------------------------------
Req 2.2.5 - Data Visualization
------------------------------------------------------------------------------------
Use of visualization tool in HIVE to explore data

1 File
HIVEQueryVisualization.txt

2 Screenshots
DataVisualizationTotalTransaction.jpg
DataVisualizationZipCode.png


