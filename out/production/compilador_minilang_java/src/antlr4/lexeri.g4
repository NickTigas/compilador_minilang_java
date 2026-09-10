lexer grammar lexeri;

@header {
package antlr4;
}
// Letras
fragment LETTER : 'a'..'z' | 'A'..'Z';

// Números
fragment DIGIT : '0'..'9';

// Palavras reservadas
RESERVADA : 'int'
          | 'if'
          | 'write'
          | 'read'
          | 'then'
          | 'else'
          | 'begin'
          | 'while'
          | 'do'
          | 'program'
          | 'float';

// Variáveis
VAR : LETTER (LETTER | DIGIT)* {
    System.out.print("[Var," + getText() + "]");
};

// Número inteiro
NUMINT : ('+' | '-')? DIGIT+;

// Número real
NUMFLOAT : ('+' | '-')? DIGIT+ '.' DIGIT+;

// Operadores relacionais
OP_RELACIONAL : '>'
              | '>='
              | '<'
              | '<='
              | '=';

// Operadores aritméticos
OP_ARITMETICO : '+'
              | '-'
              | '*'
              | '/';

// Ignora espaços, tabulações e quebras de linha
WHITESPACE : (' ' | '\t' | '\r' | '\n') -> skip;