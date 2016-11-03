@echo off

rmdir /s /q .\jarjar

REM ***** DBX *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\DBX\DBX*.jar`) do (
rem xcopy "%%A" "jarjar\%%~nA\" /Y
xcopy "%%A" "jarjar\DBX\" /Y
)

REM ***** divcontroller‚Ìjar‚ğƒRƒs[ *****
xcopy .\DB\DBX\standard\divcontroller\target\db#dbx-classes.jar .\jarjar\DBX\ /Y


REM ***** test.jar‚ğíœ *****
mkdir jarjar\tests
for /f "usebackq tokens=*" %%A in (`dir /b /s jarjar\*tests.jar`) do (
echo %%A
move /Y "%%A" "jarjar\tests\" 
)

pause
exit
