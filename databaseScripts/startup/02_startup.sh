#! bin/bash
for f in ~/sqlScripts/startup/*.sql
do
    echo "Processing $f file..."
    # take action on each file. $f store current file name
    sqlplus dev/dev@XEPDB1 @$f
done