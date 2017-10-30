package main.java.com.main.utility

import org.apache.spark.SparkContext

class GenericFunctions {

  //convert the input file which contains the hive query information into map of string
  def separateParams(path: String, sc : SparkContext, pos: Tuple2[Int, Int]) : scala.collection.Map[String,String] = {
    val rdd = sc.textFile(path).toLocalIterator.toList
    val sectionMap = scala.collection.mutable.LinkedHashMap[String, String]()
    rdd.map(x=>sectionMap.put(x.split("=")(pos._1).trim(),x.split("=")(pos._2).trim()))
    sectionMap
  }
  //convert the input file which decides the job config into map of string
//  def getJobTypeConfig(path: String, sc: SparkContext, pos: Tuple2[Int, Int]) : scala.collection.Map[String, String] = {
//    val rdd = sc.textFile(path).toLocalIterator.toList
//    val propertyMap = scala.collection.mutable.LinkedHashMap[String, String]()
//    rdd.map(x=>propertyMap.put(x.split("=")(pos._1),x.split("=")(pos._2)))
//    propertyMap
//  }

}
