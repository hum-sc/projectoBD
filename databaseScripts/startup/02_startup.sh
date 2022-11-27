#! bin/bash
red='\033[31m' NC='\033[0m'
blue='\033[34m'
green='\033[32m'
magenta='\033[35m'
echo -e "${green}startup!!!!!---------------------------------------------${NC}"
for f in ~/sqlScripts/startup/*.sql
do
    echo -e "${magenta}Processing $f----------------${NC}"
    # take action on each file. $f store current file name
    sqlplus dev/dev@XEPDB1 @$f
done
echo -e "${red}........................................................${NC}"