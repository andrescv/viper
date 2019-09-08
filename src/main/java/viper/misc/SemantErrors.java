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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


/** Viper semant errors. */
public final class SemantErrors {

  /** program file path */
  private static Path file = null;

  /** error counter */
  private static int ERRORS = 0;

  /**
   * Pretty prints a semant error.
   *
   * @param line error line
   * @param col error column
   * @param msg error message
   */
  private static void print(int line, int col, String msg) {
    System.err.println(String.format("error:%d:%d %s", line, col, msg));
    if (file != null) {
      try {
        Stream<String> lines = Files.lines(file);
        String source = lines.skip(line - 1).findFirst().get();
        String pad = "^";
        for (int i = 0; i < col - 1; i++) {
          pad = " " + pad;
        }
        System.err.println();
        System.err.println(source);
        System.err.println(pad);
        System.err.println();
      } catch (IOException e) { }
    }
    ERRORS++;
  }

  /**
   * Sets program file path.
   *
   * @param file program file
   */
  public static void setFile(File file) {
    SemantErrors.file = file.toPath();
    ERRORS = 0;
  }

  /**
   * Verifies if the current program has semant errors.
   *
   * @return true if the current program has errors, false if not
   */
  public static boolean hasErrors() {
    return ERRORS != 0;
  }

  /**
   * Semant error when the main function is declared with arguments.
   *
   * @param line error line
   * @param col error column
   */
  public static void mainFunctionShouldHaveNoArgs(int line, int col) {
    print(line, col, "'main' function should have no arguments");
  }

  /**
   * Semant error when the main function is declared with the wrong return type.
   *
   * @param line error line
   * @param col error column
   */
  public static void mainFunctionShouldHaveAnIntRetType(int line, int col) {
    print(line, col, "'main' function should have an int return type");
  }

  /**
   * Semant error when a formal parameter is multiply defined.
   *
   * @param line error line
   * @param col error column
   * @param name formal name
   */
  public static void formalIsAlreadyDefined(int line, int col, String name) {
    print(line, col, String.format("formal parameter %s is already defined", name));
  }

  /**
   * Semant error for binary operators.
   *
   * @param line error line
   * @param col error col
   * @param operator binary operator
   */
  public static void badOperandTypesForBinaryOp(int line, int col, String operator) {
    print(line, col, String.format("bad operand types for binary operator '%s'", operator));
  }

  /**
   * Semant error for unary operators.
   *
   * @param line error line
   * @param col error col
   * @param operator unary operator
   */
  public static void badOperandTypeForUnaryOperator(int line, int col, Type t, String operator) {
    print(line, col, String.format("bad operand type %s for unary operator '%s'", t, operator));
  }

  /**
   * Incomparable types semant error.
   *
   * @param line error line
   * @param col error col
   * @param t1 first type
   * @param t2 second type
   */
  public static void incomparableTypes(int line, int col, Type t1, Type t2) {
    print(line, col, String.format("incomparable types %s. and %s", t1, t2));
  }

  /**
   * Incompatible types semant error.
   *
   * @param line error line
   * @param col error col
   * @param t1 first type
   * @param t2 second type
   */
  public static void incompatibleTypes(int line, int col, Type t1, Type t2) {
    print(line, col, String.format("incompatible types: %s cannot be converted to %s", t1, t2));
  }

  /**
   * Semant error for undefined symbols.
   *
   * @param line error line
   * @param col error col
   * @param name symbol name
   */
  public static void cannotFindSymbol(int line, int col, String name) {
    print(line, col, String.format("cannot find symbol '%s'", name));
  }

  /**
   * Semant error when a function is called with the wrong number of arguments.
   *
   * @param line error line
   * @param col error column
   * @param name function name
   */
  public static void functionCalledWithWrongNumberOfArgs(int line, int col, String name) {
    print(line, col, String.format("function '%s' called with wrong number of arguments", name));
  }

  /**
   * Semant error when a function is multiply defined.
   *
   * @param line error line
   * @param col error col
   * @param name function name
   */
  public static void functionIsAlreadyDefined(int line, int col, String name) {
    print(line, col, String.format("function %s is already defined", name));
  }

  /**
   * Semant error when a variable is multiply defined.
   *
   * @param line error line
   * @param col error column
   * @param id variable name
   */
  public static void variableIsAlreadyDefined(int line, int col, String id) {
    print(line, col, String.format("variable %s is already defined", id));
  }

  /**
   * Semant error when a return expression is unexpected.
   *
   * @param line error line
   * @param col error column
   */
  public static void unexpectedReturnValue(int line, int col) {
    print(line, col, "incompatible types: unexpected return value");
  }

  /**
   * Semant error when a return expression is missing.
   *
   * @param line error line
   * @param col error column
   */
  public static void missingReturnStatement(int line, int col) {
    print(line, col, "missing return statement");
  }

}
