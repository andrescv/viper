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


/** Represents a list of statements. */
public final class Statements extends ListNode {

  /**
   * Adds a new statement to the list.
   *
   * @param node statement to add
   * @return the list of nodes after adding the given node
   */
  public Statements add(Statement node) {
    list.add(node);
    return this;
  }

  /**
   * Calculates the number of local variables that are alive
   *
   * @return number of local variables that area alive.
   */
  public int locals() {
    int n = 0;
    for (Node node : elements()) {
      if (node instanceof Declaration) {
        n++;
      }
    }
    int m = 0;
    for (Node node : elements()) {
      if (node instanceof If) {
        m = Math.max(m, ((If) node).locals());
      } else if (node instanceof While) {
        m = Math.max(m, ((While) node).locals());
      }
    }
    return n + m;
  }


  /**
   * Calls semant method of each node in the list.
   *
   * @param O ids environment
   * @param M functions environment
   */
  public void semant(SymbolTable O, HashMap<String, Function> M) {
    for (Node node : elements()) {
      ((Statement) node).semant(O, M);
    }
  }

  /**
   * Calls code method of each node in the list.
   *
   * @param locals local counter
   * @param O ids environment
   * @param p print stream
   */
  public void code(Counter locals, SymbolTable O, PrintStream p) {
    for (Node node : elements()) {
      ((Statement) node).code(locals, O, p);
    }
  }

  /**
   * Calls dump method of each node in the list.
   *
   * @param p print stream
   * @param pad padding number
   */
  public void dump(PrintStream p, int pad) {
    for (Node node : elements()) {
      ((Statement) node).dump(p, pad);
    }
  }

}
