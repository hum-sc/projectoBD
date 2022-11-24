#! bin/bash
red='\e[0;31m' NC='\e[0m'

./setPassword.sh admin
echo "${red}setup-------------------------------------${NC}"
for f in ~/sqlScripts/setup/admin/*.sql
do
    echo "${red}Processing $f${NC}"
    sqlplus sys/admin@XEPDB1 as sysdba @$f
done
echo "${red}admin end----------------------------------------${NC}"
for f in ~/sqlScripts/setup/*.sql
do
    echo "${red}Processing $f file.................................${NC}"
    # take action on each file. $f store current file name
    sqlplus dev/dev@XEPDB1 @$f
done
echo "${red}........................................................${NC}"