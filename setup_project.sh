if [ "$1" = "" ] ; then
  echo "First parameter must be defined and must point to a jposee project directory"  2>&1
  echo "If you dont have it, you can get it doing" 2>&1
  echo "mkdir jposee && svn checkout http://jposee.googlecode.com/svn/trunk/ jposee" 2>&1
  exit 1
fi

JPOSEE=$1
SCRIPT=$(readlink -f $0)
GOAL=`dirname $SCRIPT`

if [ "${JPOSEE:0:1}" != "/" ] ; then
    echo "jposee path must be absolute" 2>&1
    exit 1
fi


if [ ! -f $JPOSEE/build.xml ] ; then
  echo "jposee is not installed on the selected directory" 2>&1
  exit 1
fi 

if [ ! -d $JPOSEE/bin ] ; then
  echo "jposee is not installed on the selected directory" 2>&1
  exit 1
fi 

if [ ! -d $JPOSEE/opt ] ; then
  echo "jposee is not installed on the selected directory" 2>&1
  exit 1
fi 

if [ ! -d $JPOSEE/modules ] ; then
  echo "jposee is not installed on the selected directory" 2>&1
  exit 1
fi 

ln -s $JPOSEE/opt/commons $GOAL/modules/
ln -s $JPOSEE/opt/constants $GOAL/modules/
ln -s $JPOSEE/opt/jetty6 $GOAL/modules/
ln -s $JPOSEE/modules/jpos $GOAL/modules/
ln -s $JPOSEE/modules/system $GOAL/modules/

echo "Done."
