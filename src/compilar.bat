@echo off
set JAR=src\antlr4\antlr-4.13.2-complete.jar

if not exist out mkdir out

javac -encoding UTF-8 -d out -cp %JAR% src\Cabeca.java src\lexico.java src\leitor.java src\parser.java src\Token.java src\TipoToken.java src\No.java src\ErroCompilacao.java src\Interpretador.java src\antlr4\expr*.java src\antlr4\Aritimetico.java

if errorlevel 1 (
    echo *** ERRO NA COMPILACAO ***
    pause
    exit /b 1
)

java -cp "out;%JAR%" Cabeca %*