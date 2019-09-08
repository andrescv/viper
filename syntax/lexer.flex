package viper.syntax;

import java_cup.runtime.Symbol;

%%

%{

  /** string length */
  private int length;

  /** strings and chars string builder */
  private StringBuilder text;

  /**
   * Creates a new symbol with default value.
   *
   * @param type symbol id
   * @return a symbol
   */
  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1, yytext());
  }

  /**
   * Creates a new symbol with a given value.
   *
   * @param type symbol id
   * @param value symbol value
   * @return a symbol
   */
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }

%}

%init{
  length = 0;
  text = new StringBuilder(0);
%init}

%eofval{
  switch (yystate()) {
    case STRING:
      return symbol(Token.ERROR, "EOF in string constant");
    case SBACKSLASH:
      return symbol(Token.ERROR, "EOF in string constant");
    default:
      return symbol(Token.EOF);
  }
%eofval}


%public
%final
%class Lexer
%cup
%line
%column
%unicode

%state COMMENT
%state STRING
%state SBACKSLASH
%state CLEAN

// language lements
LPAREN = "("
RPAREN = ")"
COLON = ":"
LBRACE = "{"
RBRACE = "}"
COMMA = ","
SEMI = ";"
PLUS = "+"
MINUS = "-"
TIMES = "*"
DIV = "/"
MOD = "%"
LT = "<"
LE = "<="
EQ = "=="
NOT = "!"
ASSIGN = "="

// keywords
DEF = "def"
INT = "int"
BOOL = "bool"
STR = "str"
VOID = "void"
IF = "if"
ELSE = "else"
WHILE = "while"
RETURN = "return"
TRUE = "true"
FALSE = "false"

// numbers
INTEGER = [+-]?[0-9]+

// identifier
ID = [a-zA-Z_][a-zA-Z0-9_]*

// strings
STRSTART = "'"
BACKSLASH = \\
CHAR = .

// comments
COMMENTSTART = "#"

// platoform independent newline
NEWLINE = \R

// valid whitespace
WHITESPACE = (" "|\t|\f|\x0B)

// everything else error
ERROR = .

%%

<YYINITIAL> {

  {LPAREN} {
    return symbol(Token.LPAREN);
  }

  {RPAREN} {
    return symbol(Token.RPAREN);
  }

  {COLON} {
    return symbol(Token.COLON);
  }

  {LBRACE} {
    return symbol(Token.LBRACE);
  }

  {RBRACE} {
    return symbol(Token.RBRACE);
  }

  {COMMA} {
    return symbol(Token.COMMA);
  }

  {SEMI} {
    return symbol(Token.SEMI);
  }

  {ASSIGN} {
    return symbol(Token.ASSIGN);
  }

  {PLUS} {
    return symbol(Token.PLUS);
  }

  {MINUS} {
    return symbol(Token.MINUS);
  }

  {TIMES} {
    return symbol(Token.TIMES);
  }

  {DIV} {
    return symbol(Token.DIV);
  }

  {LT} {
    return symbol(Token.LT);
  }

  {LE} {
    return symbol(Token.LE);
  }

  {NOT} {
    return symbol(Token.NOT);
  }

  {EQ} {
    return symbol(Token.EQ);
  }

  {DEF} {
    return symbol(Token.DEF);
  }

  {INT} {
    return symbol(Token.INT);
  }

  {BOOL} {
    return symbol(Token.BOOL);
  }

  {STR} {
    return symbol(Token.STR);
  }

  {VOID} {
    return symbol(Token.VOID);
  }

  {IF} {
    return symbol(Token.IF);
  }

  {ELSE} {
    return symbol(Token.ELSE);
  }

  {WHILE} {
    return symbol(Token.WHILE);
  }

  {RETURN} {
    return symbol(Token.RETURN);
  }

  {TRUE} {
    return symbol(Token.BOOLEAN, true);
  }

  {FALSE} {
    return symbol(Token.BOOLEAN, false);
  }

  {INTEGER} {
    return symbol(Token.INTEGER);
  }

  {ID} {
    return symbol(Token.ID);
  }

  {STRSTART} {
    length = 0;
    text.setLength(0);
    yybegin(STRING);
  }

  {COMMENTSTART} {
    yybegin(COMMENT);
  }

  // ignore newlines
  {NEWLINE} { /* do nothing */ }

  // ignore whitespace
  {WHITESPACE} { /* do nothing */ }

  // report error
  {ERROR}  {
    return symbol(Token.ERROR, "invalid language element: '" + yytext() + "'");
  }

}

<STRING> {

  {STRSTART} {
    yybegin(YYINITIAL);
    String str = "\"" + text.toString() + "\"";
    if (length > 1024) {
      return symbol(Token.ERROR, "string constant too long");
    }
    return symbol(Token.STRING, str);
  }

  {BACKSLASH} {
    yybegin(SBACKSLASH);
    text.append('\\');
  }

  {CHAR} {
    length++;
    text.append(yytext());
  }

  {NEWLINE} {
    yybegin(CLEAN);
    return symbol(Token.ERROR, "unterminated string constant");
  }

}

<SBACKSLASH> {

  {CHAR} {
    length++;
    text.append(yytext());
    yybegin(STRING);
  }

  {NEWLINE} {
    length++;
    text.append("n");
    yybegin(STRING);
  }

}

<CLEAN> {

  {STRSTART} {
    yybegin(YYINITIAL);
  }

  {CHAR}|{NEWLINE} { /* consume everything */}

}

<COMMENT> {

  {CHAR} { /* consume everything */ }

  {NEWLINE} {
    yybegin(YYINITIAL);
  }

}
