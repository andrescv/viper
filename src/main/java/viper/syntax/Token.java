/*
MIT License

Copyright (c) 2016-2019 Andrés Castellanos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package viper.syntax;

/** CUP generated class containing symbol constants. */
public class Token {

  /* terminals */
  public static final int TIMES = 21;
  public static final int MOD = 23;
  public static final int LT = 24;
  public static final int ELSE = 9;
  public static final int PLUS = 19;
  public static final int RBRACE = 16;
  public static final int RPAREN = 13;
  public static final int INT = 4;
  public static final int SEMI = 18;
  public static final int WHILE = 10;
  public static final int NOT = 27;
  public static final int RETURN = 11;
  public static final int ERROR = 2;
  public static final int IF = 8;
  public static final int LPAREN = 12;
  public static final int COLON = 14;
  public static final int LBRACE = 15;
  public static final int ID = 29;
  public static final int LE = 25;
  public static final int BOOLEAN = 32;
  public static final int STRING = 31;
  public static final int COMMA = 17;
  public static final int EOF = 0;
  public static final int DEF = 3;
  public static final int DIV = 22;
  public static final int MINUS = 20;
  public static final int error = 1;
  public static final int ASSIGN = 28;
  public static final int EQ = 26;
  public static final int STR = 6;
  public static final int BOOL = 5;
  public static final int INTEGER = 30;
  public static final int VOID = 7;

  public static final String[] terminalNames = new String[] {
  "EOF",
  "error",
  "ERROR",
  "DEF",
  "INT",
  "BOOL",
  "STR",
  "VOID",
  "IF",
  "ELSE",
  "WHILE",
  "RETURN",
  "(",
  ")",
  ":",
  "{",
  "}",
  ",",
  ";",
  "+",
  "-",
  "*",
  "/",
  "%",
  "<",
  "<=",
  "==",
  "!",
  "=",
  "ID",
  "INTEGER",
  "STRING",
  "BOOLEAN"
  };

}
