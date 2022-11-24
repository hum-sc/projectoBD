#! bin/bash
for f in ~/sqlScripts/setup/*.sql
do
  sqlplus sys/admin@XEPDB1 as sysdba @$f
done