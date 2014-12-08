@echo off
rem CopyWebScripts.cmd
echo CopyWebScripts
call .\BuildSettings.cmd

if not exist "src\main\webapp\WEB-INF\Scripts\WebScripts" mkdir "src\main\webapp\WEB-INF\Scripts\WebScripts"

rem move /Y "..\WebScripts\*.js" "src\main\webapp\WEB-INF\Scripts\WebScripts"
:label_main_1
	if "%~1"=="" goto :eof
	set srcfilename=%~1
	set srcfilename=%srcfilename:.ts=%
	set tgtfilename=%srcfilename%
	set tgtfilename=%tgtfilename:..\WebScripts=WebScripts%
	set tgtfilename=src\main\webapp\WEB-INF\Scripts\%tgtfilename%
	call :sub_get_folder "%tgtfilename%"
	if not exist "%tgtfolder%" mkdir "%tgtfolder%"
	echo     move %srcfilename%.js 
	if exist "%srcfilename%.js" move "%srcfilename%.js" "%tgtfilename%.js"
	shift
goto label_main_1



:sub_get_folder
	set tgtfolder=%~dp1
goto :eof

