@echo off
rem CreateDeclareScript.cmd ver.20141112
echo CreateDeclareScript
set arg=%~1
cd .\tstools

call .\BuildSettings.cmd

echo ���L�qDiv�^��`�t�@�C���𐶐���...
echo     �r���h����
dir /s/b "..\src\main\webapp\WEB-INF\standard\CommonChildDiv\*.ts">$tmp1.txt
cscript /Nologo .\CreateDeclareScript.vbs "%SubGyomuCode%" "CommonChildDiv" $tmp1.txt
if not "%ERRORLEVEL%"=="0" goto :l_err
echo     �r���h
tsc @$tmp2.txt
if not "%ERRORLEVEL%"=="0" goto :l_err
echo     �z�z
copy ".\CommonChildDivReferences.txt"+".\%SubGyomuCode%CommonChildDiv.d.ts" /b $tmp3.txt
del ".\%SubGyomuCode%CommonChildDiv.d.ts"
copy $tmp3.txt /b ".\%SubGyomuCode%CommonChildDiv.d.ts"

move /Y ".\%SubGyomuCode%CommonChildDiv.d.ts" "..\src\main\webapp\WEB-INF\standard\d.ts"
if not "%ERRORLEVEL%"=="0" goto :l_err
echo �����������܂���
goto l_end
:l_err
echo �G���[���������܂���
:l_end
if "%arg%"=="" pause
call :sub_deleteWorkFiles
goto :eof



:sub_deleteWorkFiles
	del $tmp1.txt
	del $tmp2.txt
	del $tmp3.txt
	del ".\%SubGyomuCode%CommonChildDiv.js"
goto :eof

