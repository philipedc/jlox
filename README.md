Project based on the book Crafting Interpreters for educational purposes


# Table of Contents

- [Grammar](#grammar)
- [Discussion](#discussion)



# Grammar

Lox's grammar can be defined with just a few lines:

```d
program        → declaration* EOF ;
declaration    → funDecl | varDecl | statement ;
statement      → exprStmt | forStmt | ifStmt | printStmt | whileStmt | whileStmt | block ;
block		       → "{" declaration* "}" ;

returnStmt     → "return" expression? ";" ;
funDecl        → "fun" function ;
function       → IDENTIFIER "(" parameters? ")" block ;
parameters		 → IDENTIFIER ( "," IDENTIFIER )* ;
forStmt        → "for" "(" ( varDecl | exprStmt | ";" ) expression? ";" expression? ")" statement ;
whileStmt      → "while" "(" expression ")" statement ;
ifStmt  	     → "if" "(" expressions ")" statement ( "else" statement)? ;
varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;
exprStmt       → expression ";" ;
printStmt      → "print" expression ";" ;

arguments      → expression ( "," expression )* ;
expression     → assignment ;
assignment     → IDENTIFIER "=" assignment | logic_or ;
logic_or	   	 → logic_and ( "or" logic_and )* ;
logic_and      → equality ( "and" equality )* ;
equality       → comparison ( ( "!=" | "==" ) comparison )* ;
comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;
term           → factor ( ( "-" | "+" ) factor )* ;
factor         → unary ( ( "/" | "*" ) unary )* ;
unary          → ( "!" | "-" ) unary | call ;
call           → primary ( "(" arguments? ")" )* ;
primary        → NUMBER | STRING | "true" | "false" | "nil" | "(" expression ")" | IDENTIFIER ;
```

## Precedence and Associativity

The corresponding is the following

| Name       | Operators      | Associates |
|------------|--------------|------------|
| Equality   | `==` `!=`     | Left       |
| Comparison | `>` `>=` `<` `<=` | Left   |
| Term       | `-` `+`       | Left       |
| Factor     | `/` `*`       | Left       |
| Unary      | `!` `-`       | Right      |

# Discussion

# TODO

Commit what is done