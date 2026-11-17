grammar expr;

@header { package antlr4; }

@parser::members {
    public java.util.Map<String, Integer> vars =
        java.util.Collections.emptyMap();
}

program returns [int val]
    : expressao EOF { $val = $expressao.val; } ;

expressao returns [int val]
    : termo expressao2[$termo.val] { $val = $expressao2.sint; } ;

expressao2 [int her] returns [int sint]
    : '+' termo expressao2[$her + $termo.val] { $sint = $expressao2.sint; }
    | '-' termo expressao2[$her - $termo.val] { $sint = $expressao2.sint; }
    |                                         { $sint = $her; }
    ;

termo returns [int val]
    : fator termo2[$fator.val] { $val = $termo2.sint; } ;

termo2 [int her] returns [int sint]
    : '*' fator termo2[$her * $fator.val] { $sint = $termo2.sint; }
    | '/' fator { if($fator.val == 0){
                        throw new RuntimeException("Erro de execucao divisao por zero");}
                        } termo2[$her / $fator.val] { $sint = $termo2.sint; }
    |  { $sint = $her; }
    ;

fator returns [int val]
    : '(' expressao ')' { $val = $expressao.val; }
    | NUM { $val = Integer.parseInt($NUM.text); }
    | ID {
        Integer valor = vars.get($ID.text);

        if (valor == null) valor = 0;

        $val = valor;
    }
    ;

NUM : [0-9]+;
ID  : [a-z_] [a-z_0-9]*;
WS  : [ \t\r\n]+ -> skip;