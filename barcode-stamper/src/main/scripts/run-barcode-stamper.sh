#!/bin/ksh
#############################################################################
#
# Starter script for Barcode Stamper
#
# Modification History
# 20150731 jpm creation
#
#############################################################################

INSTALLDIR=`dirname $0`
LIBDIR=$INSTALLDIR/lib
CONFDIR=$INSTALLDIR/conf

test -z "$INSTALLDIR" && INSTALLDIR=.

#####################
# Arguments
# 1 - source/orig PDF
# 2 - barcode image to stamp
# 3 - destination PDF
#####################
PROGARGS="$1 $2 $3"

# set config files
PROPS=barcode-stamper.properties
LOGPROPS=barcode-stamper-log.properties

# set class path
CLASSPATH=$INSTALLDIR
for j in `find $LIBDIR -type f -name '*'.jar -print`
do
	CLASSPATH="$CLASSPATH:$j"
done
export CLASSPATH

# initiate export
COMMAND="$JAVA_HOME/bin/java 
	-Djava.util.logging.config.file=$CONFDIR/$LOGPROPS
	com.atex.h11.newsday.barcode.BarcodeStamper -p $CONFDIR/$PROPS $PROGARGS"
echo $COMMAND
exec $COMMAND
