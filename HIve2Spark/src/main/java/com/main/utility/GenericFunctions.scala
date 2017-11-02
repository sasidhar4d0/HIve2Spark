package main.java.com.main.utility

import java.lang.Integer

import org.apache.spark.SparkContext
import main.java.com.main.constants.Constants
import org.apache.spark.sql.types.IntegerType

import scala.collection.immutable.Range

class GenericFunctions extends Serializable {

  //convert the input file which contains the hive query information into map of string
  def getProperyMap(path: String, section: String, sc: SparkContext,pos:Tuple2[Int,Int]): scala.collection.Map[String, String] = {
    val rdd: List[String] = sc.textFile(path).toLocalIterator.toList
    val sectionMap = scala.collection.mutable.LinkedHashMap[String, String]()
    rdd.filter(x => x.contains(section.toString())).map(y => sectionMap.put(y.split(":=")(pos._1).trim(), y.split(":=")(pos._2).trim()))
    sectionMap
  }

  def validateInputColumnCount(rddElement:String, expectedLength : Int) : Boolean ={
    val y = rddElement.split(",",-1)
    if (y.length == expectedLength) true else false
  }

  def validateNonNullColumns(rddElement: String, nonNullColumns: List[String]) : Boolean ={
    val y = rddElement.split(",",-1)
    var bRef = true
    for(i <- 0 until nonNullColumns.size)
      {
        var index = nonNullColumns(i)
        if(y(index.toInt-1).isEmpty || y(index.toInt-1).equalsIgnoreCase("null"))
          {
            bRef = false
          }
      }
    bRef
  }

  def validateColumnDataType(rddElement: String, dataTypes: List[String]) : Boolean ={
    val y = rddElement.split(",",-1)
    var bRef = true
    for(i<-0 until y.length)
      {
        true
      }

    true
  }
}
