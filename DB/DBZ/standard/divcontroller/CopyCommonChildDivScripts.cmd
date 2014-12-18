@echo off
rem CopyCommonChildDivScripts.cmd
echo CopyCommonChildDivScripts
call .\BuildSettings.cmd

if not exist "src\main\webapp\WEB-INF\Scripts\CommonChildDiv" mkdir "src\main\webapp\WEB-INF\Scripts\CommonChildDiv"

move /Y ".\%SubGyomuCode%CommonChildDiv.d.ts" "..\d.ts"
move /Y ".\%SubGyomuCode%CommonChildDiv.js" "src\main\webapp\WEB-INF\Scripts\CommonChildDiv"

rem move /Y "..\CommonChildDiv\*.js" "src\main\webapp\WEB-INF\Scripts\CommonChildDiv"
:label_main_1
	if "%~1"=="" goto :eof
	set srcfilename=%~1
	set srcfilename=%srcfilename:.ts=%
	set tgtfilename=%srcfilename%
	set tgtfilename=%tgtfilename:..\CommonChildDiv=CommonChildDiv%
	set tgtfilename=src\main\webapp\WEB-INF\Scripts\%tgtfilename%
	call :sub_get_folder "%tgtfilename%"
	if not exist "%tgtfolder%" mkdir "%tgtfolder%"
	echo     move %srcfilename%.js 
	if exist "%srcfilename%.js" move "%srcfilename%.js" "%tgtfilename%.js"
	if exist "%srcfilename%_Design.js" move "%srcfilename%_Design.js" "%tgtfilename%_Design.js"
	shift
goto label_main_1



:sub_get_folder
	set tgtfolder=%~dp1
goto :eof

