grammar expr;

program returns[ int val]:
    expressao EOF {$val = $expressao.val;};

expressao returns[ int val]: termo expressao2[$termo.val] {$val = $expressao2.sint;};

expressao2[ int her] returns[int sint]:
      '+' termo expressao2[$termo.val + $her] {$sint = $expressao2.sint;}
    | '-' termo expressao2[$her-$termo.val] {$sint = $expressao2.sint;}
    | {$sint = $her;} ;

termo returns[ int val]: fator termo2[$fator.val] {$val = $termo2.sint;};

termo2 [ int her] returns[ int sint]:
    '*' fator termo2[$fator.val * $her] {$sint = $termo2.sint;} | {$sint = $her;} ;

fator returns[ int val]:
    '(' expressao ')' {$val = $expressao.val;}
    | NUM{$val = Interger.parseInt($NUM.text);};
NUM: '0'..'9'+;
WS: (' '|'\n' |'/r' |'//' | '\t'){skip();};