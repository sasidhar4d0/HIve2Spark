#!/bin/bash
clear
#######################################################################################################
# Script Written to Call Spark Jobs 
# All locations have been parametrized for easy updating of the script
# The script takes 3 parameters, the last two being optional
# The first parameter is the name of the job to run, this would be the file name of the csv (without .csv)
# The second parameter is the type of configuration that should be used to run the job if none is given it defaults to normal cluster mode
# The third parameter is the port number to run on for monitoring Spark Jobs, this defaults to 4069 if no port is given
# An example run configuration of the job is sh invoke_spark.sh m_frt_spark ncl 4049
#######################################################################################################

SHELL_SCRIPTPATH="/hdfs/app/ASBI/ETL/bin"
SPARK_JAR="/hdfs/app/ASBI/ETL/bin/sparkhqlwrapper_2.11-0.8.jar"
SPARK_CORE="/opt/mapr/spark/spark-2.1.0"
file_name=$1
file="/hdfs/app/ASBI/ETL/hql/$file_name/$file_name.csv"
port=${3:-4069}
confType=$2
hadop_extn="/hdfs"
conf_file="/hdfs/app/ASBI/ETL/conf/spark-clustermode-defaults.conf"
parameters_file='/hdfs/app/ASBI/ETL/conf/asbi.properties'
log4jconf="/hdfs/app/ASBI/ETL/conf/log4j.properties"
log4jfile="-Dlog4j.configuration=file:$log4jconf -Dlogfile.name=${file_name}_$(date +%Y-%m-%d_%H.%M.%S)"
function check_param
{
    if [ -z "$file" ]; then
    echo "Please provide the required csv file:"
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
"ncl") conf_file="/hdfs/app/ASBI/ETL/conf/spark-clientmode-defaults.conf"
	;;
"ncu") conf_file="/hdfs/app/ASBI/ETL/conf/spark-clustermode-defaults.conf"
	;;
"lcl") conf_file="/hdfs/app/ASBI/ETL/conf/spark-clientmode-large.conf"
echo "worked"
	;; 
"lcu") conf_file="/hdfs/app/ASBI/ETL/conf/spark-clustermode-large.conf"
	;;
"xcl") conf_file="/hdfs/app/ASBI/ETL/conf/spark-clientmode-xlarge.conf"
	;;
"xcu") conf_file="/hdfs/app/ASBI/ETL/conf/spark-clustermode-xlarge.conf"
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
 $SPARK_CORE/bin/spark-submit 	--class com.cisco.services.asbi.SparkHqlWrapper \
				--properties-file $conf_file \
				--files $SPARK_CORE/conf/hive-site.xml \
				--conf spark.ui.port=$port \
				--name $file_name \
				--driver-java-options "-Dlog4j.configuration=file:$log4jconf -Dlogfile.name=${file_name}_$(date +%Y-%m-%d_%H.%M.%S)" \
				$SPARK_JAR $parameters_file $file
}   # end of invoke_spark

###
# Main body of script starts here
###
echo "---------Starting Script at `date` ---------"
check_param
file_avilable
config_type
invoke_spark
if [ $? -eq 0 ]
then
	echo "---------Ending Script at `date` -------------"
	echo "Job Succeeded"
	exit 0
else
	echo "Job Failed" >&2
	echo "---------Ending Script at `date` -------------"
	exit 1
fi
