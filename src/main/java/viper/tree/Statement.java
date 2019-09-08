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
package viper.tree;

import java.io.PrintStream;
import java.util.HashMap;

import viper.misc.Counter;
import viper.misc.SymbolTable;


/** General representation of a Viper statement. */
public abstract class Statement extends Node {

  /**
   * Creates a new statement.
   *
   * @param line node line number
   * @param col node column number
   */
  public Statement(int line, int col) {
    super(line, col);
  }

  /**
   * Performs the semantic analysis of the node.
   *
   * @param O ids environment
   * @param M functions environment
   */
  public abstract void semant(SymbolTable O, HashMap<String, Function> M);

  /**
   * Generates the assembler code of the node.
   *
   * @param locals local counter
   * @param O ids environment
   * @param p print stream
   */
  public abstract void code(Counter locals, SymbolTable O, PrintStream p);

  /**
   * Prints a representation of the node.
   *
   * @param p print stream
   * @param pad padding number
   */
  public abstract void dump(PrintStream p, int pad);

}
