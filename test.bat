@echo off

REM Compile the Java file
javac -d . *.java

REM Normal case
echo Testing normal case...
java Main assignm.arxml
echo ----------------------------------------------------------------------------------
REM Not valid Autosar file case
echo Testing not valid Autosar file case...
java Main laab6.txt
echo ----------------------------------------------------------------------------------
REM Empty file case
echo Testing empty file case...
java Main empty.arxml
echo ----------------------------------------------------------------------------------

REM Clean up compiled Java files
del assignment6adv\*.class

pause