package main.java.com.main

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
import org.apache.spark.sql.types.DataTypes.{DoubleType,IntegerType,StringType,BooleanType,FloatType}
import org.apache.spark.sql.types.{StructType,StructField}
import org.apache.spark.sql.Row

object Test {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .set("spark.driver.memory","1G")
      .set("spark.executor.memory","1G")
      .setMaster("local")
      .setAppName("Testing")
    val sc = new SparkContext(conf)
    val hc = new HiveContext(sc)
    val df1 = hc.sql("select * from udf").registerTempTable("temp1")

    def colgen = (s:String, i:Int) => {
      val time = "20171120202020"
      if(i>=2000) s+time
      else {
        if(s.equals("A") || s.equals("B") || s.equals("C")) "ABCD"
        else "NULL"
      }
    }

    hc.udf.register("colgen",colgen)

    val df2 = hc.sql("select f1,f2,colgen(f1,f2) from temp1").rdd.saveAsTextFile("/user/cloudera/udf_test")
  }
}
