#! bin/bash

# Execute the SQL scripts in /sqlScripts/setup
# The SQL scripts are executed in alphabetical order

for f in ~/sqlScripts/setup/*.sql
do
  echo "Processing $f file..."
  sqlplus sys/admin@XEPDB1 as sysdba @$f
done

echo "Setup complete"