#!/bin/bash
clear
#######################################################################################################
#### Created By TCS v1.0 , 14th Dec 2016
#### This script called the spark submit to launch te spark job
#######################################################################################################

SHELL_SCRIPTPATH="/users/hdpcps/scripts/shell_scripts"
SPARK_JAR="/hdfs/app/HadoopCPS/ETL/bin"
SPARK_CORE="/opt/mapr/spark/spark-1.6.1/bin"
file=$1
job_name=${2:-"CPS_SPARKJOB"}
port=${3:-4060}
confType=$4
hadop_extn="/hdfs"
conf_file="/hdfs/app/HadoopCPS/ETL/conf/cps-spark-clustermode-defaults.conf"

function check_param
{
    if [ -z "$file" ]; then
    echo "Please provide the required xml file:"
	exit 1
fi

}   # end of check param

function file_avilable
{
   if [ -f "$file" ]
   then
     echo "$file found."
   else
    echo "$file not found please check the location:"
    exit 1
   fi
}

function config_type
{
case $confType in 
"ncl") conf_file="/hdfs/app/HadoopCPS/ETL/conf/cps-spark-clientmode-defaults.conf"
	;;
"ncu") conf_file="/hdfs/app/HadoopCPS/ETL/conf/cps-spark-clustermode-defaults.conf"
	;;
"lcl") conf_file="/hdfs/app/HadoopCPS/ETL/conf/cps-spark-clientmode-large.conf"
echo "worked"
	;; 
"lcu") conf_file="/hdfs/app/HadoopCPS/ETL/conf/cps-spark-clustermode-large.conf"
	;;
"xcl") conf_file="/hdfs/app/HadoopCPS/ETL/conf/cps-spark-clientmode-xlarge.conf"
	;;
"xcu") conf_file="/hdfs/app/HadoopCPS/ETL/conf/cps-spark-clustermode-xlarge.conf"
	;;
*) echo $confType 
echo "config_type not found running in clustermode-default. 
The options are:
ncl for normal client mode
ncu for normal cluster mode
lcl for large client mode
lcu for large cluster mode
xcl for xlarge client mode
xcu for xlarge cluster mode"
	;;
esac
}



function invoke_spark
{
 $SPARK_CORE/spark-submit 	--class SparkHqlWrapper \
				--properties-file $conf_file \
				--files /opt/mapr/spark/spark-1.6.1/conf/hive-site.xml \
				--conf spark.ui.port=$port --name $job_name \
				$SPARK_JAR/sparkhqlwrapper_2.10-0.7.jar /hdfs/app/HadoopCPS/ETL/logs/"$job_name".log $file /hdfs/app/HadoopCPS/ETL/conf/parameters.txt
}   # end of invoke_spark

###
# Main body of script starts here
###
echo "---------Starting Script at `date` ---------"
START=$(date +%k%M%S)
check_param
file_avilable
config_type
invoke_spark
if [ $? -eq 0 ]
then
	echo "Job Ended Successfully"
	echo "---------Ending Script at `date` -------------"
	END=$(date +%k%M%S)
	time_taken=$((END - START))
	mins=${time_taken:0:${#time_taken}-2}
	secs=${time_taken:len-2:2}
	echo "--------Total Time Taken was $mins minutes and $secs seconds------------"
	exit 0
else
	echo "Job Failed" >&2
	echo "---------Ending Script at `date` -------------"
	END=$(date +%k%M%S)
	time_taken=$((END - START))
	mins=${time_taken:0:${#time_taken}-2}
	secs=${time_taken:len-2:2}
	echo "--------Total Time Taken was $mins minutes and $secs seconds------------"
	exit 1
fi
