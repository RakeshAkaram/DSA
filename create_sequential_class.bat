@echo off
setlocal EnableDelayedExpansion

:: Prompt for class name and package
set /p classname=Enter class name (e.g., UserManager):
set /p package=Enter package name (e.g., com.example.project):

:: Replace dots with backslashes for folder path
set "packagepath=%package:.=\%"
set "fullpath=src\%packagepath%"
:: Create package folder if it doesn't exist
if not exist "%fullpath%" mkdir "%fullpath%"

:: Initialize max LL number
set maxnum=0

:: Scan existing files with LL pattern
for %%f in (%fullpath%\LL*.java) do (
    set fname=%%~nxf
    set prefix=!fname:~2,3!
    for /f "tokens=* delims=0123456789" %%a in ("!prefix!") do if "!prefix!" neq "%%a" (
        set /a num=1!prefix! - 1000
        if !num! gtr !maxnum! set maxnum=!num!
    )
)

:: Calculate next number and format
set /a nextnum=maxnum+1
set "nextnum=00!nextnum!"
set "nextnum=!nextnum:~-3!"

:: Final filename
set "filename=LL%nextnum%_%classname%.java"

:: Create the Java file
echo package %package%; > "%fullpath%\%filename%"
echo. >> "%fullpath%\%filename%"
echo public class LL%nextnum%_%classname% { >> "%fullpath%\%filename%"
echo     public static void main(String[] args) { >> "%fullpath%\%filename%"
echo         System.out.println("LL%nextnum%_%classname% created."); >> "%fullpath%\%filename%"
echo     } >> "%fullpath%\%filename%"
echo } >> "%fullpath%\%filename%"

echo File '%filename%' created in package '%package%'.
pause
