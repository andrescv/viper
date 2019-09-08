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

import java.util.HashMap;
import java.util.Stack;


/** Symbol table utility. */
public class SymbolTable {

  /** table of symbols */
  private Stack<HashMap<String, Object>> table;

  /** Creates a new and empty symbol table. */
  public SymbolTable() {
    table = new Stack<>();
  }

  /** Adds a new scope */
  public void enterScope() {
    table.push(new HashMap<>());
  }

  /** Removes the current scope. */
  public void exitScope() {
    if (!table.isEmpty()) {
      table.pop();
    }
  }

  /**
   * Adds an identifier in the current scope.
   *
   * @param id identifier name
   * @param value symbol value
   */
  public void add(String id, Object value) {
    if (!table.isEmpty()) {
      table.peek().put(id, value);
    }
  }

  /**
   * Searches the given identifier in all the available scopes.
   *
   * @param id identifier to search
   * @return symbol value or null if the given id does not exists in any scope
   */
  public Object lookup(String id) {
    if (!table.isEmpty()) {
      for (int i = table.size() - 1; i >= 0; i--) {
        if (table.elementAt(i).containsKey(id)) {
          return table.elementAt(i).get(id);
        }
      }
    }
    return null;
  }

  /**
   * Searches the given identifier in the current scope.
   *
   * @param id identifier to search
   * @return symbol value or null if the given id does not exists in the current scope
   */
  public Object probe(String id) {
    if (!table.isEmpty()) {
      return table.peek().get(id);
    }
    return null;
  }

}
