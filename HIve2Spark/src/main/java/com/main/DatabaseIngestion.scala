package main.java.com.main

// Spark version - 1.6.0
// Scala version - 2.10.5

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import main.java.com.main.utility.GenericFunctions
import main.java.com.main.constants.{Constants=>const}

/* Created by Sasidhar */

object DatabaseIngestion {

  def main(args: Array[String]): Unit = {

    val genericFunctions = new GenericFunctions

    val paramspath = args(0)

    val conf = new SparkConf().setAppName("RDBMS2HiveIngestion")
    val sc = new SparkContext(conf)
    val sq = new HiveContext(sc)

    val paramsMap = genericFunctions.getProperyMap(paramspath,const.INGESTION,sc,(1,2))

    val connection = paramsMap(const.CONNECTIONSTRING)
    val databasename = paramsMap(const.SOURCEDBNAME)
    val sourcetable = paramsMap(const.SOURCETABLE)
    val username = paramsMap(const.USERNAME)
    val password = paramsMap(const.PASSWORD)
    val hivetable = paramsMap(const.HIVETABLE)
    val hivetemptable = paramsMap(const.HIVETEMPTABLE)
    val checkloadtype = paramsMap(const.FULLLOAD)
    val checkcolumn = paramsMap(const.CHECKCOLUMN)
    val max_value = hivetable+paramsMap(const.HIVEMAXVALUE)
    val temptable = hivetable+"_temp"

    val properties = new java.util.Properties()
    properties.setProperty("user",username)
    properties.setProperty("password",password)

    val ordersDF = sq.read.jdbc(connection+"/"+databasename,sourcetable,properties)

    ordersDF.registerTempTable(hivetemptable)

    if(checkloadtype.equalsIgnoreCase("yes")) {
      sq.sql("create table if not exists " + hivetable + " as select * from " + hivetemptable)
      sq.sql("create table if not exists "+ max_value +" as select "+checkcolumn+ " from "+ hivetable+ " where 1 = 2")
      sq.sql("insert overwrite table "+max_value+" select MAX("+checkcolumn+") from " + hivetemptable)
    }
    else {
      sq.sql("create table if not exists "+temptable+" as select * from " + hivetable + " where 1 = 2")
      sq.sql("insert overwrite table "+temptable+" select t1.* from "+ hivetemptable + " t1 join (select MAX("+checkcolumn+") as max1 from "+max_value+") t2 where t1."+checkcolumn+" > t2.max1")
      sq.sql("insert into table " + hivetable + " select * from "+temptable)
      sq.sql("create table if not exists "+max_value+" ("+checkcolumn+" int)")
      sq.sql("insert overwrite table "+max_value+" select MAX("+checkcolumn+") from " + hivetemptable)
      sq.sql("drop table "+temptable)
    }
  }
}

//Below is the command to execute the job

/*spark-submit --class main.java.com.main.DatabaseIngestion --deploy-mode client
 --master local --driver-memory 1G --executor-memory 1G
  /home/cloudera/Desktop/Sasidhar/spark-jars/dmac-2.0.jar /user/cloudera/selfproject/dbparams */