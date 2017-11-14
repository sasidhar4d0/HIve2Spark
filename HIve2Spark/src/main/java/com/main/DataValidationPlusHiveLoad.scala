package com.main

// Spark version - 1.6.0
// Scala version - 2.10.5

import main.java.com.main.utility.GenericFunctions
import org.apache.spark.sql.hive._
import org.apache.spark._
import main.java.com.main.constants.Constants
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.sql.hive.{HiveContext => HC}
import org.apache.spark.rdd.{RDD => mainRDD}
import org.apache.spark.sql.types.{StructType => structType}

/* Created by Sasidhar */

object DataValidationPlusHiveLoad {

  def main(args: Array[String]): Unit = {

    // Input Parameters
    val paramspath = args(0)
    val inputpath = args(1)
    val datatypemismatch = args(2)
    val invalidrecords = args(3)

    //Spark Context and Hive Context Creation
    val conf = new SparkConf().setAppName("File to Hive Ingestion")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc)

    //Object creation for GenericFunctions class
    val genericFunctions = new GenericFunctions()

    //Fetching the parameters from the input file
    val metadataMap = genericFunctions.getProperyMap(paramspath,Constants.METADATA,sc,(1,2))
    val nonNullColumnsMap = genericFunctions.getProperyMap(paramspath,Constants.NONNULL,sc,(1,2))
    val delimiterMap = genericFunctions.getProperyMap(paramspath,Constants.DATA,sc,(1,2))
    val queryMap = genericFunctions.getProperyMap(paramspath,Constants.QUERY,sc,(1,2))

    //Deriving the variables needed for dataframe creation
    val rowLength = metadataMap.size
    val dataTypes = metadataMap.map(x=> x._2).toList
    val nonNullColumns = nonNullColumnsMap.map(x=>x._2).toList
    var exceptionRecords : RDD[String] = null
    val schema: structType = genericFunctions.getSchemaFromPropertyFile(metadataMap,sc)
    val temp_table = queryMap(Constants.TEMP_TABLE)
    val mainQuery = queryMap(Constants.MAIN_QUERY)

    //Function to create dataframe
    def createSourceDataFrame(sc:SparkContext,hiveContext: HiveContext,inputRDD:mainRDD[Array[String]], schema:structType,tempTable:String,datatypesList:List[String], actualRDD : RDD[String]) = {

      val transInputRDD: RDD[Row] = inputRDD.map(row => genericFunctions.ConvertRowtoTuple(row, datatypesList))
      val transformedInputRDD = transInputRDD.filter(x=>genericFunctions.validateLineLength(x.length,rowLength))

      //catch the records with data type mismatch
      exceptionRecords = transInputRDD.filter(row => row.mkString("").contains(Constants.EXCEPTION)).map(x => x.mkString(","))

      //Convert the input file into dataframe
      val sourceDataFrame = hiveContext.createDataFrame(transformedInputRDD,schema)

      //register temp table
      sourceDataFrame.registerTempTable(tempTable)

      //Run the main query
      hiveContext.sql(mainQuery)
    }

    //Creating the initial RDD from the input file
    val inputRDD = sc.textFile(inputpath)

    //Split the RDD into array to do data cleansing operations
    val splitRDD = inputRDD.map(x=>x.split(delimiterMap(Constants.DELIMITER),-1))

    //Start the data validation process
    val filteredRDD = splitRDD.filter(x=> {
      genericFunctions.validateInputColumnCount(x,rowLength) && genericFunctions.validateNonNullColumns(x,nonNullColumns)
    })

    val garbageRDD = inputRDD.filter(x=> {
      val y = x.split(delimiterMap(Constants.DELIMITER),-1)
      genericFunctions.getLessLengthElements(y,rowLength) || genericFunctions.getNullElements(y,nonNullColumns)
    })

    //Create the source dataframe
    createSourceDataFrame(sc,hiveContext,filteredRDD,schema,temp_table,dataTypes,inputRDD)

    //Collect data type mismatch records
    exceptionRecords.saveAsTextFile(datatypemismatch)

    //Collect null and less length records from input file
    garbageRDD.saveAsTextFile(invalidrecords)

  }
}

//Command to run this job
/*
spark-submit --class com.main.DataValidationPlusHiveLoad --deploy-mode client --master local --driver-memory 1G
--executor-memory 1G /home/cloudera/Desktop/Sasidhar/spark-jars/dmac-2.0.jar
/user/cloudera/selfproject/params
/user/cloudera/selfproject/input
/user/cloudera/selfproject/datatypemismatch
/user/cloudera/selfproject/invalidrecords
*/


// First argument, pass the job type - small, average, complex
//val jobtype = "small" //args(0)
//var hc : org.apache.spark.sql.hive.HiveContext = null
// Second argument, pass the input file path where the config file is located

/*if (jobtype.matches(Constants.SMALL))
{
  val jobtypepath = "/home/cloudera/selfproject/conf"
  val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
  hc = new HiveContext(sc)
  hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
  println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
}
else if (jobtype.matches(Constants.AVERAGE))
{
  val jobtypepath = "/user/cloudera/project/average" //pass correct
  val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
  hc = new HiveContext(sc)
  hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
  println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
}
else if (jobtype.matches(Constants.COMPLEX))
{
  val jobtypepath = "/user/cloudera/project/complex" //pass correct
  val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
  hc = new HiveContext(sc)
  hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
  println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
}
else
{
  val jobtypepath = "/home/cloudera/selfproject/conf"
  val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
  hc = new HiveContext(sc)
  hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
  println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
}*/