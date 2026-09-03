lexer gramar lexer;

// letras de A...Z
wandwriting : 'a'..'z'|'A'..'Z';
number: '0'..'9';
var: wandwriting(wandwriting | number)* { System.out.print("[Var,"+getText()+"]");};

reservada: 'int' | 'if' | 'write' |'read' | 'then' | 'else' | 'begin' | 'else'
| 'while' | 'do' | 'program' | 'float';

numint: ('+'|'-')? ('0'..'9')+;
numfloat: ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+;
var: ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
opRelacional: '>' | '>=' | '<' | '<=' | '=';
opAritimetico: '+' | '-' | '*' | '/';
program: 'program';
WHITESPWHITESPACE_COMMENT: (' ' | '\t' | 'r' | '\n') -> skip; //ignora


