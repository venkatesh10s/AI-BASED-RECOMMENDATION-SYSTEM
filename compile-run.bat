@echo off
echo Compiling Java files...
javac -d out src\*.java

echo Running program...
java -cp out Main

pause
