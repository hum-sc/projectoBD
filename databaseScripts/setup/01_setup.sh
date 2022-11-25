#! bin/bash
red='\033[31m' NC='\033[0m'
green='\033[32m'
magenta='\033[35m'

./setPassword.sh admin
echo -e "${green}setup---------------${NC}"
echo -e "${red}admin---------------${NC}"
echo -e ${NC}
for f in ~/sqlScripts/setup/admin/*.sql
do
    echo -e "${magenta}Processing $f---------------${NC}"
    sqlplus sys/admin@XEPDB1 as sysdba @$f
    echo -e "${magenta}---------------${NC}"
done
echo -e "${red}dev---------------${NC}"
for f in ~/sqlScripts/setup/*.sql
do
    echo -e "${magenta}Processing $f file---------------${NC}"
    # take action on each file. $f store current file name
    sqlplus dev/dev@XEPDB1 @$f
done
echo -e "${red}---------------${NC}"