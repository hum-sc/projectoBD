#! bin/bash
for f in ~/sqlScripts/startup/*.sql
do
  sqlplus dev/dev@XEPDB1 @$f
done