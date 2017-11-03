package main.java.com.main.utility

import java.lang.Integer
import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.SparkContext
import main.java.com.main.constants.Constants
import org.apache.spark.sql.types.DataTypes.{DoubleType, FloatType, IntegerType, StringType}
import org.apache.spark.sql.types._
import org.apache.spark.sql.types.StructType
import scala.collection.Map

import scala.collection.immutable.Range
import scala.collection.mutable.ArrayBuffer

class GenericFunctions extends Serializable {

  //convert the input file which contains the hive query information into map of string
  def getProperyMap(path: String, section: String, sc: SparkContext,pos:Tuple2[Int,Int]): scala.collection.Map[String, String] = {
    val rdd: List[String] = sc.textFile(path).toLocalIterator.toList
    val sectionMap = scala.collection.mutable.LinkedHashMap[String, String]()
    rdd.filter(x => x.contains(section.toString())).map(y => sectionMap.put(y.split(":=")(pos._1).trim(), y.split(":=")(pos._2).trim()))
    sectionMap
  }

  def validateInputColumnCount(rdd: Array[String], expectedLength : Int) : Boolean ={
    if (rdd.length == expectedLength) true else false
  }

  def validateNonNullColumns(rdd: Array[String], nonNullColumns: List[String]) : Boolean ={
    var bRef = true
    for(i <- 0 until nonNullColumns.size)
      {
        var index = nonNullColumns(i).trim
        if(rdd(index.toInt-1).isEmpty || rdd(index.toInt-1).equalsIgnoreCase("null"))
          {
            bRef = false
          }
      }
    bRef
  }

  def getNullElements(rdd: Array[String], nonNullColumns: List[String]) : Boolean ={
    var bRef = false
    for(i <- 0 until nonNullColumns.size)
    {
      var index = nonNullColumns(i).trim
      if(rdd(index.toInt-1).isEmpty || rdd(index.toInt-1).equalsIgnoreCase("null"))
      {
        bRef = true
      }
    }
    bRef
  }

  def getLessLengthElements(rdd: Array[String], expectedLength : Int) : Boolean ={
    if (rdd.length != expectedLength) true else false
  }

  def getSchemaFromPropertyFile(metadata: Map[String,String], sc: SparkContext) : StructType = {
    StructType(metadata.map(x=>StructField(x._1,getDataType(x._2),true)).toArray)
  }

  def getDataType(s: String) : DataType ={
    val columnType: DataType =  s match {
      case "StringType" => StringType
      case "IntegerType" => IntegerType
      case "FloatType" => FloatType
      case "DoubleType" => DoubleType
      case _ => StringType
    }
    columnType
  }

  def ConvertRowtoTuple(row: Array[String], metadata: List[String]) = {
    var bRef = true
    var message:String = null
    val length = metadata.size
    var singleRowElements: ArrayBuffer[Any] = new ArrayBuffer[Any]()

    try {
      for (i <- 0 until metadata.size) {
        val rowData =StringToDataType(row(i), metadata(i))
        singleRowElements.append(rowData)
      }
    }
    catch {
      case e: NumberFormatException => {println(e.printStackTrace()); bRef = false; message = "Exception " + e.getMessage() }
      case e: ClassCastException => {println(e.printStackTrace()); bRef = false; message = "Exception " + e.getMessage() }
      case e: SimpleDateFormat => {println(e.printStackTrace()); bRef = false; message = "Exception " + e.getMessage() }
      case e: Exception => {println(e.printStackTrace()); bRef = false; message = "Exception " + e.getMessage() }

    }

    if(bRef) org.apache.spark.sql.Row.fromSeq(singleRowElements)
    else {
      val updateRow: Array[String] = row :+ message
      //UpdateExceptionRows(updateRow)
      org.apache.spark.sql.Row.fromSeq(updateRow)
    }
  }

  def StringToDataType(rowElement: String, rowElementType: String): Any = {
    val data: Any = rowElementType match {
      case "StringType" => rowElement.toString()
      case "IntegerType" => rowElement.toInt
      case "FloatType" => rowElement.toFloat
      case "DoubleType" => rowElement.toDouble
      case _ => rowElement.toString()
    }
    data
  }

  def GetTodaysDate(): String = {
    val simpleDateFormat: SimpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    String.valueOf(simpleDateFormat.format(new Date()))
  }

  def validateLineLength(x: Int, y: Int) : Boolean = {
    if(x == y ) true else false
  }
}
