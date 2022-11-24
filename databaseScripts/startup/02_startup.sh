#! bin/bash
red='\e[0;31m' NC='\e[0m'
echo "startup!!!!!-------------------------------------------------------------------------------------"
for f in ~/sqlScripts/startup/*.sql
do
    echo"${red}Processing $f${NC}"
    # take action on each file. $f store current file name
    sqlplus dev/dev@XEPDB1 @$f
done
echo "${red}........................................................${NC}"