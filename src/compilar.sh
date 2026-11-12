#!/bin/sh
# Uso: ./compilar.sh exemplos/fatorial.minilang
JAR=src/antlr4/antlr-4.13.2-complete.jar
rm -rf out
javac -encoding UTF-8 -d out -cp "$JAR" src/Cabeca.java src/lexico.java src/leitor.java src/parser.java src/Token.java src/TipoToken.java src/No.java src/ErroCompilacao.java src/Interpretador.java src/antlr4/expr*.java src/antlr4/Aritimetico.java || { echo "*** ERRO NA COMPILACAO ***"; exit 1; }
java -cp "out:$JAR" Cabeca "$@"
