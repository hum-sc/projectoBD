#! bin/bash

# Execute the SQL scripts in /sqlScripts/setup
# The SQL scripts are executed in alphabetical order
for f in ~/sqlScripts/startup/*.sql
do
  echo "Processing $f file..."
  sqlplus dev/dev@XEPDB1 @$f
done
echo "StartUp complete"