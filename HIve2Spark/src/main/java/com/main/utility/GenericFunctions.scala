package main.java.com.main.utility

import org.apache.spark.SparkContext

class GenericFunctions {

  def seperateParams(path: String, sc : SparkContext) : scala.collection.Map[String,String] = {
    val rdd = sc.textFile(path).toLocalIterator.toList
    val sectionMap = scala.collection.mutable.LinkedHashMap[String, String]()
    rdd.map(x=>sectionMap.put(x.split("=")(0),x.split("=")(1)))
    sectionMap
  }

}
