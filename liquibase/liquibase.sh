#
# Trudato liquibase script
#

echo "========================================"
echo "Trudato liquibase shell helper script"
echo "========================================"

run_help() {

    echo "Usage: $0 [options] action "		
	echo "Actions:"
	echo "    update               : Updates the DB with the latest changesets"
	echo "    rollbackTag [tag]    : Rollback the DB to the tag specified in [tag]"
	echo "    clear                : Clear the checksums"
}

run_liquibase() {

	CURR_DIR=$(pwd)
	BASEDIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

	LIQUIBASE_DIR=$BASEDIR/bin
	DEFAULTS_FILE=$LIQUIBASE_DIR/conf/liquibase.properties
	CLASSPATH=$LIQUIBASE_DIR/driver/mysql-connector-java-5.1.43-bin.jar
	CHANGELOGFILE=liquibase-changeLog.xml

	LIQUIBASE_CMD="java -jar $LIQUIBASE_DIR/liquibase.jar  --defaultsFile=$DEFAULTS_FILE --changeLogFile=$CHANGELOGFILE --classpath=$CLASSPATH"

	if [ "$1" == "update" ]; then
 		$LIQUIBASE_CMD update
	  
	elif [ "$1" == "rollbackTag" ]; then
	  	TAG=$2
	  	$LIQUIBASE_CMD rollback $TAG
  	elif [ "$1" == "clear" ]; then
	  	$LIQUIBASE_CMD clearCheckSums
	else	
	   echo "Unknown action [$1]. Use --help to check available actions. "
	fi

	cd $CURR_DIR
}

if [ $# == 0 ] || ([ $# == 1 ] && [ $1 == "--help" ]); then
   	run_help
   	exit 1
else
	run_liquibase $1 $2
fi	

echo " Action: $1"
echo ""
echo "Finished Liquibase script execution."
echo "========================================"