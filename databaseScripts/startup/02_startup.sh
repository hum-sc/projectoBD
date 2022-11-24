#! bin/bash
for f in ~/sqlScripts/startup/*.sql
do
  echo "Processing $f file..."
  sqlplus dev/dev@XEPDB1 @$f
done
echo "StartUp complete"