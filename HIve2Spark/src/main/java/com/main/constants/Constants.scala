package main.java.com.main.constants

object Constants extends Serializable {

  /* Constants for DataValidationPlusHiveLoad */

  //Metadata
  val METADATA = "MetaData"

  //Data Sep
  val DATA = "DataSep"
  val DELIMITER = "Sep"

  //Non Null Columns
  val NONNULL = "NonNullable"

  //Dataframe Information
  val QUERY = "Query"
  val TEMP_TABLE =  "Temp_Table"
  val MAIN_QUERY =  "Main_Query"

  //exception
  val EXCEPTION = "Exception"


  /*Constants for DatabaseIngestion*/

  val INGESTION = "Ingestion"
  val CONNECTIONSTRING = "connection_string"
  val SOURCEDBNAME = "source_db_name"
  val USERNAME = "username"
  val PASSWORD = "password"
  val SOURCETABLE = "source_table"
  val HIVETABLE = "hive_table"
  val HIVETEMPTABLE = "hive_temp_table"
  val FULLLOAD = "full_load"
  val CHECKCOLUMN = "check_column"
  val HIVEMAXVALUE = "hive_max_value"

}
