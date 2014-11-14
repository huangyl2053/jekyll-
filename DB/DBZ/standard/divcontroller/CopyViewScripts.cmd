@echo off
rem CopyViewScripts.cmd
echo CopyViewScripts
call .\BuildSettings.cmd

if not exist "src\main\webapp\WEB-INF\Scripts\View" mkdir "src\main\webapp\WEB-INF\Scripts\View"

rem move /Y "..\View\*.js" "src\main\webapp\WEB-INF\Scripts\View"
:label_main_1
	if "%~1"=="" goto :eof
	set srcfilename=%~1
	set srcfilename=%srcfilename:.ts=%
	set tgtfilename=%srcfilename%
	set tgtfilename=%tgtfilename:..\View=View%
	set tgtfilename=src\main\webapp\WEB-INF\Scripts\%tgtfilename%
	call :sub_get_folder "%tgtfilename%"
	if not exist "%tgtfolder%" mkdir "%tgtfolder%"
	echo     move %srcfilename%.js 
	if exist "%srcfilename%.js" move "%srcfilename%.js" "%tgtfilename%.js"
	set srcfilename=%srcfilename:_Script=%
	set tgtfilename=%tgtfilename:_Script=%
	if exist "%srcfilename%.js" move "%srcfilename%.js" "%tgtfilename%.js"
	shift
goto label_main_1



:sub_get_folder
	set tgtfolder=%~dp1
goto :eof

