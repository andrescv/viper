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

import viper.misc.CgenSupport;
import viper.misc.Counter;
import viper.misc.SemantErrors;
import viper.misc.SymbolTable;
import viper.misc.Type;


/** Represents a call expression. */
public class Call extends Expression {

  /** function name */
  protected final String name;
  /** function arguments */
  protected final Actuals actuals;

  /**
   * Creates a new call expression.
   *
   * @param line node line number
   * @param col node column number
   * @param name function name
   * @param actuals function arguments
   */
  public Call(int line, int col, String name, Actuals actuals) {
    super(line, col);
    this.name = name;
    if ((name.equals("print") || name.equals("println") || name.equals("input")) && actuals.size() == 0) {
      this.actuals = (new Actuals()).add(new StrConst(-1, -1, ""));
    } else {
      this.actuals = actuals;
    }
  }

  /**
   * Verifies if it is a function call to print or println.
   *
   * @return true if it is a function call to print or println, false otherwise
   */
  public boolean isPrint() {
    return name.equals("print") || name.equals("println");
  }

  /** {@inheritDoc} */
  @Override
  public void semant(SymbolTable O, HashMap<String, Function> M) {
    // WRITE YOUR CODE HERE
  }

  /** {@inheritDoc} */
  @Override
  public void code(Counter locals, SymbolTable O, PrintStream p) {
    // WRITE YOUR CODE HERE
  }

  /** {@inheritDoc} */
  @Override
  public void dump(PrintStream p, int pad) {
    p.println(pad(pad) + "Call(" + name + ")");
    actuals.dump(p, pad + 2);
  }

}
