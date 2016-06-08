@echo off
rem BuildViewScripts.cmd
echo BuildViewScripts
:label_main_1
	if "%~1"=="" goto :eof
	set targetfilename=%~dpn1
	echo     build %targetfilename%.ts
	tsc --target ES5 --out "%targetfilename%.js" "%targetfilename%.ts"
	shift
goto label_main_1
