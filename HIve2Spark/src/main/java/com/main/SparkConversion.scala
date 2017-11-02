package com.main

import main.java.com.main.utility.GenericFunctions
import org.apache.spark.sql.hive._
import org.apache.spark._
import main.java.com.main.constants.Constants

object SparkConversion {

  def main(args: Array[String]): Unit = {

    val genericFunctions = new GenericFunctions()
    val paramspath = "/home/cloudera/selfproject/params"//args(1)
    val inputpath = "/home/cloudera/selfproject/input" //args(2)
    val conf = new SparkConf().setAppName("testing").setMaster("local")
    val sc = new SparkContext(conf)
    val metadataMap = genericFunctions.getProperyMap(paramspath,Constants.METADATA,sc,(1,2))
    val nonNullColumnsMap = genericFunctions.getProperyMap(paramspath,Constants.NONNULL,sc,(1,2))
    val delimiterMap = genericFunctions.getProperyMap(paramspath,Constants.DATA,sc,(1,2))
    val expectedColumnCount = metadataMap.size
    val dataTypes = metadataMap.map(x=> x._2).toList
    val nonNullColumns = nonNullColumnsMap.map(x=>x._2).toList

    val inputRDD = sc.textFile(inputpath).repartition(1)

    println(expectedColumnCount)
    println(dataTypes)
    println(nonNullColumns)
    println(delimiterMap(Constants.DELIMITER))

    val filteredRDD = inputRDD.filter(x=>{
      genericFunctions.validateInputColumnCount(x,expectedColumnCount) && genericFunctions.validateNonNullColumns(x,nonNullColumns)
    })
    filteredRDD.saveAsTextFile("/home/cloudera/selfproject/outputfilter")
    inputRDD.saveAsTextFile("/home/cloudera/selfproject/inputfilter")
  }
}

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