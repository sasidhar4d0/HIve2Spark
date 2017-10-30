package com.main

import main.java.com.main.utility.GenericFunctions
import org.apache.spark.sql.hive._
import org.apache.spark._
import main.java.com.main.constants.Constants

object SparkConversion {

  def main(args: Array[String]): Unit = {

    val genericFunctions = new GenericFunctions()
    // First argument, pass the job type - small, average, complex
    val jobtype = args(0)
    var hc : org.apache.spark.sql.hive.HiveContext = null
    // Second argument, pass the input file path where the config file is located
    val path = "/user/cloudera/prjconf"//args(1)
    val conf = new SparkConf().setAppName("testing").setMaster("local")
    val sc = new SparkContext(conf)
    if (jobtype.matches(Constants.SMALL))
    {
      val jobtypepath = "/user/cloudera/project/small"
      val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
      hc = new HiveContext(sc)
      hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
      println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
    }
    else if (jobtype.matches(Constants.AVERAGE))
    {
      val jobtypepath = "/user/cloudera/project/average"
      val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
      hc = new HiveContext(sc)
      hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
      println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
    }
    else if (jobtype.matches(Constants.COMPLEX))
    {
      val jobtypepath = "/user/cloudera/project/complex"
      val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
      hc = new HiveContext(sc)
      hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
      println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
    }
    else
    {
      val jobtypepath = "/user/cloudera/project/small"
      val paramMap = genericFunctions.separateParams(jobtypepath,sc,(0,1))
      hc = new HiveContext(sc)
      hc.setConf(Constants.DRIVERMEMORY,paramMap(Constants.DRIVERMEMORYVALUE))
      println(Constants.EXECUTORMEMORY,paramMap(Constants.EXECUTORMEMORYVALUE))
    }
    val queryMap = genericFunctions.separateParams(path,sc,(0,1))
    val hiveContext = hc
    println(queryMap(Constants.QUERY))
    hiveContext.sql(queryMap(Constants.QUERY)).rdd.saveAsTextFile("/user/cloudera/myprojecttest1")
  }
}