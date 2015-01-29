@echo off
rem CreateProjectFiles.cmd ver.20141112
echo CreateProjectFiles
cd .\tstools
call .\BuildSettings.cmd

echo WebScriptsプロジェクトファイルを生成中...
dir /s/b "..\src\main\webapp\WEB-INF\standard\WebScripts\*.ts">$tmp1.txt
cscript /Nologo .\CreateProjectFile.vbs "%SubGyomuCode%" "WebScripts" $tmp1.txt
del $tmp1.txt

echo 共有子Divプロジェクトファイルを生成中...
dir /s/b "..\src\main\webapp\WEB-INF\standard\CommonChildDiv\*.ts">$tmp1.txt
cscript /Nologo .\CreateProjectFile.vbs "%SubGyomuCode%" "CommonChildDiv" $tmp1.txt
del $tmp1.txt

echo 親Divプロジェクトファイルを生成中...
dir /s/b "..\src\main\webapp\WEB-INF\standard\View\*.ts">$tmp1.txt
cscript /Nologo .\CreateProjectFile.vbs "%SubGyomuCode%" "View" $tmp1.txt
del $tmp1.txt

echo 生成完了しました
pause
