package main.java.com.main.utility

import org.apache.spark.SparkContext
import main.java.com.main.constants.Constants

class GenericFunctions extends Serializable {

  //convert the input file which contains the hive query information into map of string
  def separateParams(path: String, sc : SparkContext, pos: Tuple2[Int, Int]) : scala.collection.Map[String,String] = {
    val rdd = sc.textFile(path).toLocalIterator.toList
    val sectionMap = scala.collection.mutable.LinkedHashMap[String, String]()
    rdd.map(x=>sectionMap.put(x.split("=")(pos._1).trim(),x.split("=")(pos._2).trim()))
    sectionMap
  }

  def getProperyMap(path: String, section: String, sc: SparkContext,pos:Tuple2[Int,Int]): scala.collection.Map[String, String] = {
    val rdd: List[String] = sc.textFile(path).toLocalIterator.toList
    val sectionMap = scala.collection.mutable.LinkedHashMap[String, String]()
    rdd.filter(x => x.contains(section.toString())).map(y => sectionMap.put(y.split("=")(pos._1).trim(), y.split("=")(pos._2).trim()))
    sectionMap
  }

  def validateInputColumnCount(length: Int, expectedLength : Int) : Boolean ={
    if (length==expectedLength) true else false
  }

  def validateNonNullColumns(rdd: Array[String], columns: List[String]) : Boolean ={    var bRef:Boolean = true
    for (i <- 0 until columns.size) {
      var index = columns(i)
      if( rdd(index.toInt).isEmpty() || rdd(index.toInt).equalsIgnoreCase("null")){
        bRef = false
      }
    }
    return bRef
  }

  def validateDataTypes(rdd: String) : Boolean = {
    if(true) true else false //
  }
}
