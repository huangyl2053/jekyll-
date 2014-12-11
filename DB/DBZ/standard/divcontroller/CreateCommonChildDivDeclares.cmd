@echo off
rem CreateCommonChildDivsDeclares.cmd
echo CreateCommonChildDivsDeclares
call .\BuildSettings.cmd
CD.>$tmp.txt
echo --out ".\%SubGyomuCode%CommonChildDiv.js" --target  ES5  --declaration>>$tmp.txt
:label_main_1
	if "%~1"=="" goto label_main_2
	set targetfilename=%~dpn1
	echo     declare %targetfilename%.ts
	echo  "%targetfilename%.ts">>$tmp.txt
	shift
goto label_main_1

:label_main_2

