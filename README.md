# Compilador MiniLang (Java)

Implementação de um interpretador para a **MiniLang**, uma linguagem de programação
imperativa e extremamente simplificada, criada para fins didáticos na disciplina de
Compiladores / Linguagens Formais e Autômatos.

A especificação completa da linguagem (gramática BNF, tokens, semântica operacional e exemplos) 

> ⚠️ **Status do projeto: em desenvolvimento.**
> Atualmente apenas o **analisador léxico** 
> Analisador sintático, AST e interpretador ainda não foram implementados.


## Sobre a MiniLang

- Paradigma imperativo e procedural
- Único tipo de dado: inteiros não negativos
- Escopo global (até 26 variáveis, `a`–`z`)
- Comandos de entrada/saída (`read`, `write`)
- Estruturas de controle: sequência, `if`/`else` e `while`


## Arquitetura planejada

```
Código-fonte (.minilang)
        │
        ▼
  Analisador Léxico  (lexico.java + leitor.java)  →  fluxo de Tokens
        │
        ▼
  Analisador Sintático (parser)                    →  AST
        │
        ▼
  Interpretador (avaliador da semântica operacional) → Saída
```

### Estrutura do repositório

```
src/
├── Main.java        # Ponto de entrada (CLI) — ainda não implementado
├── TipoToken.java    # Enum com os tipos de token da linguagem
├── Token.java        # Representação de um token (tipo + lexema)
├── leitor.java        # Leitor de arquivo com buffer duplo e rollback de lexema
├── lexico.java        # Analisador léxico (reconhecimento de tokens)
└── lexic.java          # Programa de teste do lexer (imprime os tokens de um arquivo)
```

Ainda não existem os pacotes/classes de **parser**, **AST** e **interpretador** — fazem
parte do roadmap.

## Como compilar e rodar (estado atual)

Hoje só é possível rodar o teste do analisador léxico:

```bash
cd src
javac *.java
java lexic caminho/para/programa.minilang
```


## Roadmap / o que falta

- [ ] Corrigir os bugs do lexer listados acima
- [ ] Analisador sintático (parser) para a gramática LL(1) da seção 2.2 da
      especificação (já com recursão à esquerda eliminada e fatoração à esquerda)
- [ ] Construção da AST (nós para programa, bloco, atribuição, read, write, if,
      while, expressões e relações)
- [ ] Interpretador seguindo a semântica operacional da seção 4 da especificação:
  - [ ] Tabela de símbolos (26 variáveis, inicializadas em 0)
  - [ ] Avaliador de expressões aritméticas (`aval`)
  - [ ] Avaliador de expressões relacionais (`avr`)
  - [ ] Execução de comandos (atribuição, sequência, condicional, laço)
  - [ ] Fila de entrada / lista de saída
  - [ ] Erro de execução para divisão por zero
- [ ] Tratamento de erros léxicos e sintáticos com mensagens claras (arquivo, posição,
      caractere/token inesperado)
- [ ] `Main.java` funcional: recebe o arquivo-fonte e os valores de entrada, roda o
      pipeline completo e imprime a saída
- [ ] Casos de teste automatizados a partir dos exemplos da especificação (seção 5):
      fatorial, máximo de dois números, soma até zero e o programa inválido
      (para validar mensagens de erro)

## Tokens reconhecidos

| Token | Padrão | Exemplo |
|---|---|---|
| `PROGRAM` | `program` | `program` |
| `BEGIN` | `begin` | `begin` |
| `END` | `end` | `end` |
| `READ` | `read` | `read` |
| `WRITE` | `write` | `write` |
| `IF` / `THEN` / `ELSE` | `if` / `then` / `else` | — |
| `WHILE` / `DO` | `while` / `do` | — |
| `ID` | `[a-z][a-z0-9]*` | `x`, `contador` |
| `NUMBER` | `[0-9]+` | `0`, `42` |
| `ASSIGN`, `PLUS`, `MINUS`, `TIMES`, `DIVIDE` | `=`, `+`, `-`, `*`, `/` | — |
| `EQ`, `LT`, `GT` | `==`, `<`, `>` | — |
| `LPAREN`, `RPAREN`, `LBRACE`, `RBRACE` | `(`, `)`, `{`, `}` | — |
| `SEMICOLON`, `COLON`, `COMMA`, `DOT` | `;`, `:`, `,`, `.` | — |
| `COMMENT` | `//[^\n]*` | `// comentário` |



## Autores

_Daniel Santiago Purificação_
_Felipe de Lima Monteiro_
_João Vitor Ludovino Leite Alves_
_Nicolas Caldeira dos Santos_
_Nicolas Jimenes Haase_
_Pedro Dias Guedes Santos_

## Disciplina

Compiladores: trabalho prático de implementação de um interpretador para uma
linguagem educacional, com foco em Linguagens Formais, Autômatos e Computabilidade.
