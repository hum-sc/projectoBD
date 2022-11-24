#! bin/bash
for f in ~/sqlScripts/startup/*.sql
do
    echo "Processing $f file..."
    # take action on each file. $f store current file name
    sqlplus dev/dev@1522/XEPDB1 @$f
done