#! bin/bash
for f in ~/sqlScripts/setup/*.sql
do
    echo "Processing $f file..."
    # take action on each file. $f store current file name
    sqlplus sys/admin@1522/XEPDB1 as sysdba @$f
done