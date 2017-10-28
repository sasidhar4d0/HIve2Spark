package com.main

import main.java.com.main.utility.GenericFunctions
import org.apache.spark.sql.hive._
import org.apache.spark._

object SparkConversion {

  def main(args: Array[String]): Unit = {

    // First argument, pass the input file path where the config file is located
    val path = "/user/cloudera/prjconf"//args(0)
    val conf = new SparkConf().setAppName("testing").setMaster("local")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc)
    val genericFunctions = new GenericFunctions()
    val query = genericFunctions.seperateParams(path,sc)
    hiveContext.sql(query("query"))
  }
}