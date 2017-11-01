package com.main

import main.java.com.main.utility.GenericFunctions
import org.apache.spark.sql.hive._
import org.apache.spark._
import main.java.com.main.constants.Constants

object SparkConversion {

  def main(args: Array[String]): Unit = {

    val genericFunctions = new GenericFunctions()
    // First argument, pass the job type - small, average, complex
    //val jobtype = "small" //args(0)
    //var hc : org.apache.spark.sql.hive.HiveContext = null
    // Second argument, pass the input file path where the config file is located
    val paramspath = "/home/cloudera/selfproject/params"//args(1)
    val inputpath = "/home/cloudera/selfproject/inputpath" //args(2)
    val conf = new SparkConf().setAppName("testing").setMaster("local")
    val sc = new SparkContext(conf)
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
    val metadataMap = genericFunctions.getProperyMap(paramspath,Constants.METADATA,sc,(1,2))
    val nonNullColumnsMap = genericFunctions.getProperyMap(paramspath,Constants.NONNULL,sc,(1,2))
    val delimiterMap = genericFunctions.getProperyMap(paramspath,Constants.DELIMITER,sc,(1,2))
    val expectedColumnCount = metadataMap.size
    val nonNullColumns = nonNullColumnsMap.map(x=>x._1).toList

    val inputRDD = sc.textFile(inputpath)
    val splitRDD = inputRDD.map(x=>x.split(delimiterMap(Constants.DELIMITER),-1))

    println(metadataMap)
    println(expectedColumnCount)
    println(nonNullColumnsMap)
    println(nonNullColumns)
    println(delimiterMap)
    println(delimiterMap(Constants.DELIMITER))

    val filteredRDD = splitRDD.filter(x=> {
      genericFunctions.validateInputColumnCount(x.length,expectedColumnCount) && genericFunctions.validateNonNullColumns(x,nonNullColumns)
    })
    //filteredRDD.coalesce(1).saveAsTextFile("/home/cloudera/selfproject/outputfilter")
    //splitRDD.saveAsTextFile("/home/cloudera/selfproject/output")
    //val hiveContext = hc
  }
}

case class orderDetails (order_id: Int, order_date : String, ord_cust_id : Int, order_status : String )