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
package viper.misc;

import java.io.PrintStream;


/** Code generation support (RISC-V version). */
public final class CgenSupport {

  /** label counter */
  private static int COUNT = 0;

  /** newline String */
  public static final String NEWLINE = System.getProperty("line.separator");

  /** word size */
  public static final int WORD_SIZE = 4;

  /** .data directive */
  public static final String DATA = "  .data";
  /** .text directive */
  public static final String TEXT = "  .text";
  /** .globl directive */
  public static final String GLOBAL= "  .globl  ";
  /** .align 2 directive */
  public static final String ALIGN = "  .align  2";
  /** .word directive */
  public static final String WORD = "  .word  ";
  /** .string directive */
  public static final String STRING = "  .string  ";

  /** methods label prefix */
  public static final String DEF = "def_";
  /** label symbol */
  public static final String LABEL = ":";

  /** Div by zero exception */
  public static final String DIV_BY_ZERO = "_div_by_zero";

  /** main function label */
  public static final String MAIN = "def_main";
  /** false boolean label */
  public static final String FALSE = "bool_const0";
  /** true boolean label */
  public static final String TRUE = "bool_const1";

  /** zero register */
  public static final String X0 = "x0";
  /** a0 register (accumulator) */
  public static final String A0 = "a0";
  /** t1 register (temporary 1) */
  public static final String T1 = "t1";
  /** t2 register (temporary 2) */
  public static final String T2 = "t2";
  /** sp register (stack pointer) */
  public static final String SP = "sp";
  /** fp register (frame pointer) */
  public static final String FP = "fp";
  /** ra register (return address) */
  public static final String RA = "ra";


  /** jal instruction */
  public static final String JAL     = "  jal   ";
  /** ret pseudo-instruction */
  public static final String RET     = "  ret   ";
  /** sw instruction */
  public static final String SW      = "  sw    ";
  /** lw instruction */
  public static final String LW      = "  lw    ";
  /** li pseudo-instruction */
  public static final String LI      = "  li    ";
  /** la pseudo-instruction */
  public static final String LA      = "  la    ";
  /** mv pseudo-instruction */
  public static final String MOVE    = "  mv    ";
  /** add instruction */
  public static final String ADD     = "  add   ";
  /** addi instruction */
  public static final String ADDI    = "  addi  ";
  /** rem instruction */
  public static final String REM     = "  rem   ";
  /** div instruction */
  public static final String DIV     = "  div   ";
  /** mul instruction */
  public static final String MUL     = "  mul   ";
  /** sub instruction */
  public static final String SUB     = "  sub   ";
  /** beqz pseudo-instruction */
  public static final String BEQZ    = "  beqz  ";
  /** j pseudo-instruction */
  public static final String JUMP    = "  j     ";
  /** beq instruction */
  public static final String BEQ     = "  beq   ";
  /** ble instruction */
  public static final String BLEQ    = "  ble   ";
  /** blt instruction */
  public static final String BLT     = "  blt   ";

  /**
   * Returns the next available label number.
   *
   * @return next available label number
   */
  public static int nextLabel() {
    return COUNT++;
  }

  /**
   * Emits a .data directive.
   *
   * @param p print stream
   */
  public static void emitData(PrintStream p) {
    p.println(DATA);
  }

  /**
   * Emits a .text directive.
   *
   * @param p print stream
   */
  public static void emitText(PrintStream p) {
    p.println(TEXT);
  }

  /**
   * Emits an .align directive.
   *
   * @param p print stream
   */
  public static void emitAlign(PrintStream p) {
    p.println(ALIGN);
  }

  /**
   * Emits a .globl directive
   *
   * @param label global label
   * @param p print stream
   */
  public static void emitGlobl(String label, PrintStream p) {
    p.println(GLOBAL + label);
  }

  /**
   * Emits a string constant.
   *
   * @param val string constant
   * @param p print stream
   */
  public static void emitStringConstant(String val, PrintStream p) {
    p.println(STRING + "\"" + val + "\"");
  }

  /**
   * Emits a int constant.
   *
   * @param val integer constant
   * @param p print stream
   */
  public static void emitIntConstant(String val, PrintStream p) {
    p.println(WORD + val);
  }

  /**
   * Emits the prologue of a method.
   *
   * @param size how much increment sp (size is multiplied by WORD_SIZE)
   * @param p print stream
   */
  public static void emitPrologue(int size, PrintStream p) {
    int realSize = size * WORD_SIZE;
    emitAddi(SP, SP, -realSize, p);
    emitStore(FP, 2, SP, p);
    emitStore(RA, 1, SP, p);
    emitAddi(FP, SP, 4, p);
  }

  /**
   * Emits the epilogue of a method.
   *
   * @param size how much decrement sp (size is multiplied by WORD_SIZE)
   * @param p print stream
   */
  public static void emitEpilogue(int size, PrintStream p) {
    int realSize = size * WORD_SIZE;
    emitLoad(FP, 2, SP, p);
    emitLoad(RA, 1, SP, p);
    emitAddi(SP, SP, realSize, p);
    emitReturn(p);
  }

  /**
   * Emits a lw instruction.
   *
   * @param dest destination register
   * @param offset the word offset from source register
   * @param source source register
   * @param p print stream
   */
  public static void emitLoad(String dest, int offset, String source, PrintStream p) {
    p.println(LW + dest + " " + (offset * WORD_SIZE) + "(" + source + ")");
  }

  /**
   * Emits a sw instruction.
   *
   * @param dest destination register
   * @param offset the word offset from source register
   * @param source source register
   * @param p print stream
   */
  public static void emitStore(String source, int offset, String dest, PrintStream p) {
    p.println(SW + source + " " + (offset * WORD_SIZE) + "(" + dest + ")");
  }

  /**
   * Emits a li instruction.
   *
   * @param dest destination register
   * @param val the integer value
   * @param p print stream
   */
  public static void emitLoadImm(String dest, int val, PrintStream p) {
    p.println(LI + dest + " " + val);
  }

  /**
   * Emits a la instruction.
   *
   * @param dest destination register
   * @param address the address from which a word is loaded
   * @param p print stream
   */
  public static void emitLoadAddress(String dest, String address, PrintStream p){
    p.println(LA + dest + " " + address);
  }

  /**
   * Loads a bool constant.
   *
   * @param dest destination register
   * @param val boolean value to load
   * @param p print stream
   */
  public static void emitLoadBool(String dest, boolean val, PrintStream p) {
    if (val) {
      emitLoadAddress(dest, TRUE, p);
    } else {
      emitLoadAddress(dest, FALSE, p);
    }
    emitLoad(dest, 0, dest, p);
  }

  /**
   * Loads a string constant.
   *
   * @param dest destination register
   * @param val string value to load
   * @param p print stream
   */
  public static void emitLoadString(String dest, String val, PrintStream p) {
    emitLoadAddress(dest, Constants.getStringLabel(val), p);
  }

  /**
   * Loads a integer constant.
   *
   * @param dest destination register
   * @param val int value to load
   * @param p print stream
   */
  public static void emitLoadInt(String dest, String val, PrintStream p) {
    emitLoadAddress(dest, Constants.getIntLabel(val), p);
    emitLoad(dest, 0, dest, p);
  }


  /**
   * Emits a mv instruction.
   *
   * @param dest destination register
   * @param source source register
   * @param p print stream
   */
  public static void emitMove(String dest, String source, PrintStream p) {
    p.println(MOVE + dest + " " + source);
  }

  /**
   * Emits an add instruction.
   *
   * @param dest destination register
   * @param src1 source register 1
   * @param src2 source register 2
   * @param p print stream
   */
  public static void emitAdd(String dest, String src1, String src2, PrintStream p) {
    p.println(ADD + dest + " " + src1 + " " + src2);
  }

  /**
   * Emits an addi instruction.
   *
   * @param dest destination register
   * @param src source register
   * @param imm the immediate
   * @param p print stream
   */
  public static void emitAddi(String dest, String src, int imm, PrintStream p) {
    p.println(ADDI + dest + " " + src + " " + imm);
  }

  /**
   * Emits a div instruction.
   *
   * @param dest destination register
   * @param src1 source register 1
   * @param src2 source register 2
   * @param p print stream
   */
  public static void emitDiv(String dest, String src1, String src2, PrintStream p) {
    p.println(DIV + dest + " " + src1 + " " + src2);
  }

  /**
   * Emits a rem instruction.
   *
   * @param dest destination register
   * @param src1 source register 1
   * @param src2 source register 2
   * @param p print stream
   */
  public static void emitRem(String dest, String src1, String src2, PrintStream p) {
    p.println(REM + dest + " " + src1 + " " + src2);
  }

  /**
   * Emits a mul instruction.
   *
   * @param dest destination register
   * @param src1 source register 1
   * @param src2 source register 2
   * @param p print stream
   */
  public static void emitMul(String dest, String src1, String src2, PrintStream p) {
    p.println(MUL + dest + " " + src1 + " " + src2);
  }

  /**
   * Emits a sub instruction.
   *
   * @param dest destination register
   * @param src1 source register 1
   * @param src2 source register 2
   * @param p print stream
   */
  public static void emitSub(String dest, String src1, String src2, PrintStream p) {
    p.println(SUB + dest + " " + src1 + " " + src2);
  }

  /**
   * Emits a JAL instruction.
   *
   * @param dest target label
   * @param p print stream
   */
  public static void emitJal(String dest, PrintStream p) {
    p.println(JAL + dest);
  }

  /**
   * Emits a ret instruction.
   *
   * @param p print stream
   */
  public static void emitReturn(PrintStream p) {
    p.println(RET);
  }

  /**
   * Emits a beqz instruction.
   *
   * @param src source register
   * @param label branch label
   * @param p print stream
   */
  public static void emitBeqz(String src, int label, PrintStream p) {
    p.print(BEQZ + src + " ");
    emitLabelRef(label, p);
    p.println("");
  }

  /**
   * Emits a beq instruction.
   *
   * @param src1 source register 1
   * @param src2 source register 2
   * @param label branch label
   * @param p print stream
   */
  public static void emitBeq(String src1, String src2, int label, PrintStream p) {
    p.print(BEQ + src1 + " " + src2 + " ");
    emitLabelRef(label, p);
    p.println("");
  }

  /**
   * Emits a bleq instruction.
   *
   * @param src1 source register 1
   * @param src2 source register 2
   * @param label branch label
   * @param p print stream
   */
  public static void emitBleq(String src1, String src2, int label, PrintStream p) {
    p.print(BLEQ + src1 + " " + src2 + " ");
    emitLabelRef(label, p);
    p.println("");
  }

  /**
   * Emits a blt instruction.
   *
   * @param src1 source register 1
   * @param src2 source register 2
   * @param label branch label
   * @param p print stream
   */
  public static void emitBlt(String src1, String src2, int label, PrintStream p) {
    p.print(BLT + src1 + " " + src2 + " ");
    emitLabelRef(label, p);
    p.println("");
  }

  /**
   * Emits a j instruction.
   *
   * @param label jump label
   * @param p print stream
   */
  public static void emitJump(int label, PrintStream p) {
    p.print(JUMP);
    emitLabelRef(label, p);
    p.println("");
  }

  /**
   * Emits a sequence of instructions to push a register onto stack.
   * Stack grows toward smaller addresses.
   *
   * @param reg register to push
   * @param p print stream
   */
  public static void emitPush(String reg, PrintStream p) {
    emitStore(reg, 0, SP, p);
    emitAddi(SP, SP, -4, p);
  }

  /**
   * Emits a sequence of instructions to pop a value from the stack.
   *
   * @param dest destination register
   * @param p print stream
   */
  public static void emitPop(String dest, PrintStream p) {
    emitLoad(dest, 1, SP, p);
    emitAddi(SP, SP, 4, p);
  }

  /**
   * Emits a reference to a label.
   *
   * @param label label number
   * @param p print stream
   */
  public static void emitLabelRef(int label, PrintStream p) {
    p.print("label" + label);
  }

  /**
   * Emits a definition of a label.
   *
   * @param label label number
   * @param p print stream
   */
  public static void emitLabelDef(int label, PrintStream p) {
    emitLabelRef(label, p);
    p.println(LABEL);
  }

  /**
   * Emits a definition of a label.
   *
   * @param label label name
   * @param p print stream
   */
  public static void emitLabelDef(String label, PrintStream p) {
    p.println(label + LABEL);
  }

}
