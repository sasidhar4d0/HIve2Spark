package main.java.com.main

/* Spark version 1.6.0 */
/* Scala version 2.10.5 */

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/*Created by Sasidhar*/

object SparkHqlWrapper {
  def main(args: Array[String]): Unit  = {

    //Creation of Spark Context & Hive Context
    val conf = new SparkConf()
      .set("hive.exec.dynamic.partition.mode", "nonstrict")
      .set("hive.exec.orc.default.buffer.size", "131072")
      .setAppName("SparkHqlWrapper")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc)
    val input_path = args(0)

    //Reading the job execution map into an Array

    val job_metadata = sc.textFile(input_path).filter(!_.isEmpty).map(line => line.split(",").map(_.trim)).collect()

    // Get the HQL from the input file and convert to String

    def paramAssignment(hql_location: String): String = {

      sc.textFile(hql_location).toLocalIterator.toList.mkString
    }

    //Evaluating and executing the hql

    def createTT(TempTableRequired: String, Cached: String, Broadcast: String, TempTableName: String, hql_txt: String) {
      if (TempTableRequired.equalsIgnoreCase("Y")) {
        if (Cached.equalsIgnoreCase("Y")) {
          hiveContext.sql(hql_txt).cache().registerTempTable(TempTableName)
        }
        else {
          hiveContext.sql(hql_txt).registerTempTable(TempTableName)
        }
        if (Broadcast.equalsIgnoreCase("Y")) {
          sc.broadcast(TempTableName)
        }
      }
      else {
        hiveContext.sql(hql_txt)
      }
    }

    //loop to process all lines of input in sequence
    for (i <- job_metadata.indices) {
      createTT(job_metadata(i)(1), job_metadata(i)(2), job_metadata(i)(3), job_metadata(i)(4), paramAssignment(job_metadata(i)(5)))
    }

    sc.stop()
  } //closing main
}