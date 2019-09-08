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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;
import java_cup.runtime.Symbol;

import viper.misc.Type;
import viper.tree.*;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Token.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] =
    unpackFromStrings(new String[] {
    "\000\057\000\002\002\003\000\002\002\004\000\002\003" +
    "\004\000\002\003\003\000\002\004\015\000\002\005\003" +
    "\000\002\005\002\000\002\006\005\000\002\006\003\000" +
    "\002\007\005\000\002\010\003\000\002\010\003\000\002" +
    "\010\003\000\002\010\003\000\002\011\003\000\002\011" +
    "\003\000\002\011\003\000\002\012\003\000\002\012\002" +
    "\000\002\013\004\000\002\013\003\000\002\014\004\000" +
    "\002\014\015\000\002\014\011\000\002\014\007\000\002" +
    "\015\005\000\002\015\002\000\002\016\005\000\002\016" +
    "\005\000\002\016\005\000\002\016\005\000\002\016\005" +
    "\000\002\016\005\000\002\016\005\000\002\016\005\000" +
    "\002\016\005\000\002\016\004\000\002\016\005\000\002" +
    "\016\006\000\002\016\003\000\002\016\003\000\002\016" +
    "\003\000\002\016\003\000\002\017\003\000\002\017\002" +
    "\000\002\020\005\000\002\020\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table =
    unpackFromStrings(new String[] {
    "\000\140\000\004\005\006\001\002\000\006\002\ufffe\005" +
    "\ufffe\001\002\000\004\002\142\001\002\000\004\037\011" +
    "\001\002\000\006\002\001\005\006\001\002\000\006\002" +
    "\uffff\005\uffff\001\002\000\004\016\012\001\002\000\006" +
    "\017\ufffb\037\013\001\002\000\004\020\140\001\002\000" +
    "\006\017\ufff9\023\ufff9\001\002\000\004\017\021\001\002" +
    "\000\006\017\ufffc\023\017\001\002\000\004\037\013\001" +
    "\002\000\006\017\ufffa\023\ufffa\001\002\000\004\020\022" +
    "\001\002\000\012\006\027\007\025\010\023\011\026\001" +
    "\002\000\004\021\ufff5\001\002\000\004\021\030\001\002" +
    "\000\004\021\ufff6\001\002\000\004\021\ufff4\001\002\000" +
    "\004\021\ufff7\001\002\000\034\006\032\007\035\010\036" +
    "\012\041\014\033\015\uffef\016\047\022\uffef\035\045\037" +
    "\043\040\034\041\040\042\037\001\002\000\034\006\032" +
    "\007\035\010\036\012\041\014\033\015\ufff0\016\047\022" +
    "\ufff0\035\045\037\043\040\034\041\040\042\037\001\002" +
    "\000\010\017\ufff3\023\ufff3\037\ufff3\001\002\000\004\016" +
    "\131\001\002\000\030\017\uffd9\023\uffd9\024\uffd9\025\uffd9" +
    "\026\uffd9\027\uffd9\030\uffd9\031\uffd9\032\uffd9\033\uffd9\034" +
    "\uffd9\001\002\000\010\017\ufff2\023\ufff2\037\ufff2\001\002" +
    "\000\010\017\ufff1\023\ufff1\037\ufff1\001\002\000\030\017" +
    "\uffd7\023\uffd7\024\uffd7\025\uffd7\026\uffd7\027\uffd7\030\uffd7" +
    "\031\uffd7\032\uffd7\033\uffd7\034\uffd7\001\002\000\030\017" +
    "\uffd8\023\uffd8\024\uffd8\025\uffd8\026\uffd8\027\uffd8\030\uffd8" +
    "\031\uffd8\032\uffd8\033\uffd8\034\uffd8\001\002\000\004\016" +
    "\117\001\002\000\006\015\112\022\uffe7\001\002\000\034" +
    "\016\101\017\uffda\023\uffda\024\uffda\025\uffda\026\uffda\027" +
    "\uffda\030\uffda\031\uffda\032\uffda\033\uffda\034\uffda\036\102" +
    "\001\002\000\034\006\uffed\007\uffed\010\uffed\012\uffed\014" +
    "\uffed\015\uffed\016\uffed\022\uffed\035\uffed\037\uffed\040\uffed" +
    "\041\uffed\042\uffed\001\002\000\016\016\047\035\045\037" +
    "\043\040\034\041\040\042\037\001\002\000\024\024\077" +
    "\025\057\026\054\027\063\030\062\031\055\032\064\033" +
    "\061\034\060\001\002\000\016\016\047\035\045\037\043" +
    "\040\034\041\040\042\037\001\002\000\004\037\051\001" +
    "\002\000\004\036\052\001\002\000\016\016\047\035\045" +
    "\037\043\040\034\041\040\042\037\001\002\000\024\024" +
    "\056\025\057\026\054\027\063\030\062\031\055\032\064" +
    "\033\061\034\060\001\002\000\016\016\047\035\045\037" +
    "\043\040\034\041\040\042\037\001\002\000\016\016\047" +
    "\035\045\037\043\040\034\041\040\042\037\001\002\000" +
    "\034\006\uffe9\007\uffe9\010\uffe9\012\uffe9\014\uffe9\015\uffe9" +
    "\016\uffe9\022\uffe9\035\uffe9\037\uffe9\040\uffe9\041\uffe9\042" +
    "\uffe9\001\002\000\016\016\047\035\045\037\043\040\034" +
    "\041\040\042\037\001\002\000\016\016\047\035\045\037" +
    "\043\040\034\041\040\042\037\001\002\000\016\016\047" +
    "\035\045\037\043\040\034\041\040\042\037\001\002\000" +
    "\016\016\047\035\045\037\043\040\034\041\040\042\037" +
    "\001\002\000\016\016\047\035\045\037\043\040\034\041" +
    "\040\042\037\001\002\000\016\016\047\035\045\037\043" +
    "\040\034\041\040\042\037\001\002\000\030\017\uffe1\023" +
    "\uffe1\024\uffe1\025\057\026\054\027\063\030\062\031\055" +
    "\032\uffe1\033\uffe1\034\uffe1\001\002\000\030\017\uffe4\023" +
    "\uffe4\024\uffe4\025\uffe4\026\uffe4\027\uffe4\030\uffe4\031\uffe4" +
    "\032\uffe4\033\uffe4\034\uffe4\001\002\000\030\017\uffe3\023" +
    "\uffe3\024\uffe3\025\uffe3\026\uffe3\027\uffe3\030\uffe3\031\uffe3" +
    "\032\uffe3\033\uffe3\034\uffe3\001\002\000\030\017\uffe0\023" +
    "\uffe0\024\uffe0\025\057\026\054\027\063\030\062\031\055" +
    "\032\uffe0\033\uffe0\034\uffe0\001\002\000\030\017\uffdf\023" +
    "\uffdf\024\uffdf\025\057\026\054\027\063\030\062\031\055" +
    "\032\064\033\061\034\uffdf\001\002\000\030\017\uffe6\023" +
    "\uffe6\024\uffe6\025\uffe6\026\uffe6\027\063\030\062\031\055" +
    "\032\uffe6\033\uffe6\034\uffe6\001\002\000\030\017\uffe2\023" +
    "\uffe2\024\uffe2\025\uffe2\026\uffe2\027\uffe2\030\uffe2\031\uffe2" +
    "\032\uffe2\033\uffe2\034\uffe2\001\002\000\030\017\uffe5\023" +
    "\uffe5\024\uffe5\025\uffe5\026\uffe5\027\063\030\062\031\055" +
    "\032\uffe5\033\uffe5\034\uffe5\001\002\000\024\017\076\025" +
    "\057\026\054\027\063\030\062\031\055\032\064\033\061" +
    "\034\060\001\002\000\030\017\uffdc\023\uffdc\024\uffdc\025" +
    "\uffdc\026\uffdc\027\uffdc\030\uffdc\031\uffdc\032\uffdc\033\uffdc" +
    "\034\uffdc\001\002\000\034\006\uffec\007\uffec\010\uffec\012" +
    "\uffec\014\uffec\015\uffec\016\uffec\022\uffec\035\uffec\037\uffec" +
    "\040\uffec\041\uffec\042\uffec\001\002\000\030\017\uffdd\023" +
    "\uffdd\024\uffdd\025\uffdd\026\uffdd\027\uffdd\030\uffdd\031\uffdd" +
    "\032\uffdd\033\uffdd\034\uffdd\001\002\000\020\016\047\017" +
    "\uffd5\035\045\037\043\040\034\041\040\042\037\001\002" +
    "\000\016\016\047\035\045\037\043\040\034\041\040\042" +
    "\037\001\002\000\030\017\uffde\023\uffde\024\uffde\025\057" +
    "\026\054\027\063\030\062\031\055\032\064\033\061\034" +
    "\060\001\002\000\006\017\uffd6\023\110\001\002\000\026" +
    "\017\uffd3\023\uffd3\025\057\026\054\027\063\030\062\031" +
    "\055\032\064\033\061\034\060\001\002\000\004\017\107" +
    "\001\002\000\030\017\uffdb\023\uffdb\024\uffdb\025\uffdb\026" +
    "\uffdb\027\uffdb\030\uffdb\031\uffdb\032\uffdb\033\uffdb\034\uffdb" +
    "\001\002\000\016\016\047\035\045\037\043\040\034\041" +
    "\040\042\037\001\002\000\026\017\uffd4\023\uffd4\025\057" +
    "\026\054\027\063\030\062\031\055\032\064\033\061\034" +
    "\060\001\002\000\016\016\047\035\045\037\043\040\034" +
    "\041\040\042\037\001\002\000\004\022\114\001\002\000" +
    "\006\002\ufffd\005\ufffd\001\002\000\024\024\116\025\057" +
    "\026\054\027\063\030\062\031\055\032\064\033\061\034" +
    "\060\001\002\000\004\022\uffe8\001\002\000\016\016\047" +
    "\035\045\037\043\040\034\041\040\042\037\001\002\000" +
    "\024\017\121\025\057\026\054\027\063\030\062\031\055" +
    "\032\064\033\061\034\060\001\002\000\004\021\122\001" +
    "\002\000\032\006\032\007\035\010\036\012\041\014\033" +
    "\016\047\022\uffef\035\045\037\043\040\034\041\040\042" +
    "\037\001\002\000\004\022\124\001\002\000\004\013\125" +
    "\001\002\000\004\021\126\001\002\000\032\006\032\007" +
    "\035\010\036\012\041\014\033\016\047\022\uffef\035\045" +
    "\037\043\040\034\041\040\042\037\001\002\000\004\022" +
    "\130\001\002\000\034\006\uffeb\007\uffeb\010\uffeb\012\uffeb" +
    "\014\uffeb\015\uffeb\016\uffeb\022\uffeb\035\uffeb\037\uffeb\040" +
    "\uffeb\041\uffeb\042\uffeb\001\002\000\016\016\047\035\045" +
    "\037\043\040\034\041\040\042\037\001\002\000\024\017" +
    "\133\025\057\026\054\027\063\030\062\031\055\032\064" +
    "\033\061\034\060\001\002\000\004\021\134\001\002\000" +
    "\032\006\032\007\035\010\036\012\041\014\033\016\047" +
    "\022\uffef\035\045\037\043\040\034\041\040\042\037\001" +
    "\002\000\004\022\136\001\002\000\034\006\uffea\007\uffea" +
    "\010\uffea\012\uffea\014\uffea\015\uffea\016\uffea\022\uffea\035" +
    "\uffea\037\uffea\040\uffea\041\uffea\042\uffea\001\002\000\034" +
    "\006\uffee\007\uffee\010\uffee\012\uffee\014\uffee\015\uffee\016" +
    "\uffee\022\uffee\035\uffee\037\uffee\040\uffee\041\uffee\042\uffee" +
    "\001\002\000\010\006\032\007\035\010\036\001\002\000" +
    "\006\017\ufff8\023\ufff8\001\002\000\004\002\000\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table =
    unpackFromStrings(new String[] {
    "\000\140\000\010\002\004\003\006\004\003\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\004\007\001\001\000\002\001\001\000\002\001\001\000" +
    "\010\005\014\006\015\007\013\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\007\017\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\010\023\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\011\047\012\041\013\030\014\043\016\045\001" +
    "\001\000\010\011\047\014\136\016\045\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\015\112\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\016\077\001\001\000\002" +
    "\001\001\000\004\016\074\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\016\052\001\001\000\002\001\001" +
    "\000\004\016\073\001\001\000\004\016\072\001\001\000" +
    "\002\001\001\000\004\016\071\001\001\000\004\016\070" +
    "\001\001\000\004\016\067\001\001\000\004\016\066\001" +
    "\001\000\004\016\065\001\001\000\004\016\064\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\010\016\104" +
    "\017\105\020\103\001\001\000\004\016\102\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\016\110\001\001\000" +
    "\002\001\001\000\004\016\114\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\016\117\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\011\047\012\122\013\030\014\043\016\045\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\011\047\012\126\013\030\014\043\016\045\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\016\131" +
    "\001\001\000\002\001\001\000\002\001\001\000\014\011" +
    "\047\012\134\013\030\014\043\016\045\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\140\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




  /** input file */
  private File file;

  /**
   * Creates a new Parser.
   *
   * @param file Viper file to parse
   */
  @SuppressWarnings("deprecation")
  public Parser(File file) throws Exception {
    super(new Lexer(new FileReader(file)));
    this.file = file;
  }

  /**
   * Parses a Viper program.
   *
   * @param file Viper file to parse
   * @return Program node
   */
  public static Program parse(File file) {
    try {
      Parser parser = new Parser(file);
      Symbol result = parser.parse();
      return (Program) result.value;
    } catch (FileNotFoundException e) {
      System.err.println(String.format("File '%s' not found", file.toString()));
      System.exit(-1);
    } catch (IOException e) {
      System.err.println("Compilation halted due to I/O errors");
      System.exit(-1);
    } catch (Exception e) {
      System.err.println("Compilation halted due to unexpected exception");
      System.exit(-1);
    }
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public void syntax_error(Symbol token) {
    int l = token.left;
    int c = token.right;
    String t = Token.terminalNames[token.sym].toLowerCase();
    if (t.equals("id") || t.equals("integer") || t.equals("string") || t.equals("boolean")) {
      t = token.value.toString();
    }
    System.err.println(String.format("%d:%d: parse error at or near: %s", l, c, t));
    try {
      Stream<String> lines = Files.lines(file.toPath());
      String source = lines.skip(l - 1).findFirst().get();
      String pad = "^";
      for (int i = 0; i < c - 1; i++) {
        pad = " " + pad;
      }
      System.err.println();
      System.err.println(source);
      System.err.println(pad);
    } catch (IOException e) { }
    System.err.println("Compilation halted due to syntax errors");
    System.exit(1);
  }

  /** {@inheritDoc} */
  @Override
  public void unrecovered_syntax_error(Symbol token) {
    /* DO NOTHING */
  }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= functions
            {
              Program RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Functions l = (Functions)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Program(file, l);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF
            {
              Object RESULT =null;
    int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Program start_val = (Program)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // functions ::= functions function
            {
              Functions RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Functions l = (Functions)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Function f = (Function)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = l.add(f);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("functions",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // functions ::= function
            {
              Functions RESULT =null;
    int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Function f = (Function)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = (new Functions()).add(f);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("functions",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // function ::= DEF ID LPAREN formals RPAREN COLON rtype LBRACE statements ret RBRACE
            {
              Function RESULT =null;
    int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-9)).left;
    int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-9)).right;
    String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-9)).value;
    int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)).left;
    int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)).right;
    Formals f = (Formals)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-7)).value;
    int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
    int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
    Type t = (Type)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
    int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Statements s = (Statements)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int rleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int rright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Expression r = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = new Function(idleft, idright, id, f, t, s, r);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("function",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // formals ::= params
            {
              Formals RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Formals l = (Formals)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = l;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("formals",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // formals ::=
            {
              Formals RESULT =null;
     RESULT = new Formals();
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("formals",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // params ::= params COMMA formal
            {
              Formals RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Formals l = (Formals)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Formal f = (Formal)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = l.add(f);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("params",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // params ::= formal
            {
              Formals RESULT =null;
    int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Formal f = (Formal)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = (new Formals()).add(f);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("params",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // formal ::= ID COLON dtype
            {
              Formal RESULT =null;
    int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Type t = (Type)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Formal(idleft, idright, id, t);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("formal",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // rtype ::= INT
            {
              Type RESULT =null;
     RESULT = Type.INT;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rtype",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // rtype ::= BOOL
            {
              Type RESULT =null;
     RESULT = Type.BOOL;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rtype",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // rtype ::= STR
            {
              Type RESULT =null;
     RESULT = Type.STR;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rtype",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // rtype ::= VOID
            {
              Type RESULT =null;
     RESULT = Type.VOID;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rtype",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // dtype ::= INT
            {
              Type RESULT =null;
     RESULT = Type.INT;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dtype",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // dtype ::= BOOL
            {
              Type RESULT =null;
     RESULT = Type.BOOL;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dtype",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // dtype ::= STR
            {
              Type RESULT =null;
     RESULT = Type.STR;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dtype",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statements ::= stmts
            {
              Statements RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Statements l = (Statements)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = l;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // statements ::=
            {
              Statements RESULT =null;
     RESULT = new Statements();
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // stmts ::= stmts statement
            {
              Statements RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Statements l = (Statements)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Statement s = (Statement)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = l.add(s);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmts",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // stmts ::= statement
            {
              Statements RESULT =null;
    int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Statement s = (Statement)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = (new Statements()).add(s);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmts",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // statement ::= expr SEMI
            {
              Statement RESULT =null;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = e;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // statement ::= IF LPAREN expr RPAREN LBRACE statements RBRACE ELSE LBRACE statements RBRACE
            {
              Statement RESULT =null;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-10)).value;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-8)).value;
    int tpleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
    int tpright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
    Statements tp = (Statements)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
    int epleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int epright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Statements ep = (Statements)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = new If(ileft, iright, e, tp, ep);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // statement ::= WHILE LPAREN expr RPAREN LBRACE statements RBRACE
            {
              Statement RESULT =null;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
    int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Statements s = (Statements)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = new While(ileft, iright, e, s);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // statement ::= dtype ID ASSIGN expr SEMI
            {
              Statement RESULT =null;
    int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
    int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
    Type t = (Type)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
    int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
    int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
    String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = new Declaration(idleft, idright, t, id, e);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // ret ::= RETURN expr SEMI
            {
              Expression RESULT =null;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = new Return(ileft, iright, e);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ret",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // ret ::=
            {
              Expression RESULT =null;
     RESULT = new NoReturn(-1, -1);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ret",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // expr ::= expr PLUS expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Add(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // expr ::= expr MINUS expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Sub(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // expr ::= expr TIMES expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Mul(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // expr ::= expr DIV expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Div(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // expr ::= expr MOD expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Mod(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // expr ::= expr LT expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new LessThan(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // expr ::= expr LE expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new LessEqual(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // expr ::= expr EQ expr
            {
              Expression RESULT =null;
    int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Equal(ileft, iright, e1, e2);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // expr ::= ID ASSIGN expr
            {
              Expression RESULT =null;
    int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Assign(idleft, idright, id, e);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // expr ::= NOT expr
            {
              Expression RESULT =null;
    int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Object i = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Not(ileft, iright, e);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // expr ::= LPAREN expr RPAREN
            {
              Expression RESULT =null;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = e;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // expr ::= ID LPAREN actuals RPAREN
            {
              Expression RESULT =null;
    int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
    int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
    String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
    int argsleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
    int argsright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
    Actuals args = (Actuals)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
     RESULT = new Call(idleft, idright, id, args);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // expr ::= ID
            {
              Expression RESULT =null;
    int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new Id(idleft, idright, id);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // expr ::= INTEGER
            {
              Expression RESULT =null;
    int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new IntConst(valleft, valright, val);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // expr ::= STRING
            {
              Expression RESULT =null;
    int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new StrConst(valleft, valright, val);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // expr ::= BOOLEAN
            {
              Expression RESULT =null;
    int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Boolean val = (Boolean)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = new BoolConst(valleft, valright, val);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // actuals ::= args
            {
              Actuals RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Actuals l = (Actuals)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = l;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("actuals",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // actuals ::=
            {
              Actuals RESULT =null;
     RESULT = new Actuals();
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("actuals",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // args ::= args COMMA expr
            {
              Actuals RESULT =null;
    int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
    int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
    Actuals l = (Actuals)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = l.add(e);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // args ::= expr
            {
              Actuals RESULT =null;
    int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
    int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
    Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
     RESULT = (new Actuals()).add(e);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
