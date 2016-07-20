@echo off

rmdir /s /q .\jarjar

REM ***** DBX *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBX\DBX*.jar`) do (
rem xcopy "%%A" "jarjar\%%~nA\" /Y
xcopy "%%A" "jarjar\DBX\" /Y
)

REM ***** DBZ *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBZ\DBZ*.jar`) do (
xcopy "%%A" "jarjar\DBZ\" /Y
)

REM ***** DBA *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBA\DBA*.jar`) do (
xcopy "%%A" "jarjar\DBA\" /Y
)

REM ***** DBB *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBB\DBB*.jar`) do (
xcopy "%%A" "jarjar\DBB\" /Y
)

REM ***** DBC *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBC\DBC*.jar`) do (
xcopy "%%A" "jarjar\DBC\" /Y
)

REM ***** DBD *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBD\DBD*.jar`) do (
xcopy "%%A" "jarjar\DBD\" /Y
)

REM ***** DBE *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBE\DBE*.jar`) do (
xcopy "%%A" "jarjar\DBE\" /Y
)

REM ***** DBU *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBU\DBU*.jar`) do (
xcopy "%%A" "jarjar\DBU\" /Y
)

REM ***** divcontrollerÇÃjarÇÉRÉsÅ[ *****
xcopy .\DB\DBX\standard\divcontroller\target\db#dbx-classes.jar .\jarjar\DBX\ /Y
xcopy .\DB\DBZ\standard\divcontroller\target\db#dbz-classes.jar .\jarjar\DBZ\ /Y
xcopy .\DB\DBA\standard\divcontroller\target\db#dba-classes.jar .\jarjar\DBA\ /Y
xcopy .\DB\DBB\standard\divcontroller\target\db#dbb-classes.jar .\jarjar\DBB\ /Y
xcopy .\DB\DBC\standard\divcontroller\target\db#dbc-classes.jar .\jarjar\DBC\ /Y
xcopy .\DB\DBD\standard\divcontroller\target\db#dbd-classes.jar .\jarjar\DBD\ /Y
xcopy .\DB\DBE\standard\divcontroller\target\db#dbe-classes.jar .\jarjar\DBE\ /Y
xcopy .\DB\DBU\standard\divcontroller\target\db#dbu-classes.jar .\jarjar\DBU\ /Y


REM ***** test.jarÇçÌèú *****
mkdir jarjar\tests
for /f "usebackq tokens=*" %%A in (`dir /b /s jarjar\*tests.jar`) do (
echo %%A
move /Y "%%A" "jarjar\tests\" 
)

pause
exit
