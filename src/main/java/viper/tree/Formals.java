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


/** Represents a list of formals. */
public final class Formals extends ListNode {

  /**
   * Adds a formal to the list.
   *
   * @param node formal to add
   * @return the list of nodes after adding the given node
   */
  public Formals add(Formal node) {
    list.add(node);
    return this;
  }

  /**
   * Returns the formal at the given index.
   *
   * @param index list index
   * @return formal at givien index
   */
  public Formal get(int index) {
    return (Formal) list.get(index);
  }

  /**
   * Calls dump method of each node in the list.
   *
   * @param p print stream
   * @param pad padding number
   */
  public void dump(PrintStream p, int pad) {
    for (Node node : elements()) {
      ((Formal) node).dump(p, pad);
    }
  }

}
