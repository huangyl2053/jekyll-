@echo off

rmdir /s /q .\warwar

REM ***** DBX *****
for /f "usebackq tokens=*" %%A in (`dir /b /s .\DB\*.war`) do (
xcopy "%%A" "warwar\" /Y
)


pause
exit
