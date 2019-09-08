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
import java.util.HashMap;


/** A table of constants (integers and strings). */
public final class Constants {

  /** string constants */
  private static final HashMap<String, Integer> strings = new HashMap<>();
  /** integer constants */
  private static final HashMap<String, Integer> integers = new HashMap<>();


  /**
   * Returns the label that represents the given string value.
   *
   * @param val string value
   * @return label that represents the given string value
   */
  public static String getStringLabel(String val) {
    return String.format("str_const%d", strings.get(val));
  }

  /**
   * Returns the label that represents the given int value.
   *
   * @param val int value
   * @return label that represents the given int value
   */
  public static String getIntLabel(String val) {
    return String.format("int_const%d", integers.get(val));
  }

  /**
   * Adds a string in the table.
   *
   * @param val string value to add
   */
  public static void addString(String val) {
    if (!strings.containsKey(val)) {
      strings.put(val, strings.size());
    }
  }

  /**
   * Adds a integer in the table.
   *
   * @param val integer value to add
   */
  public static void addInteger(String val) {
    if (!integers.containsKey(val)) {
      integers.put(val, integers.size());
    }
  }

  /**
   * Emits assembly code for all defined constants.
   *
   * @param p print stream
   */
  public static void code(PrintStream p) {
    // add default string and int constants
    addString("");
    addInteger("0");
    // code bool constants
    CgenSupport.emitAlign(p);
    p.println(CgenSupport.FALSE + CgenSupport.LABEL);
    p.println(CgenSupport.WORD + "0");
    p.println(CgenSupport.TRUE + CgenSupport.LABEL);
    p.println(CgenSupport.WORD + "1");
    // code string constants
    for (String key : strings.keySet()) {
      CgenSupport.emitLabelDef(String.format("str_const%d", strings.get(key)), p);
      CgenSupport.emitStringConstant(key, p);
    }
    // code int constants
    CgenSupport.emitAlign(p);
    for (String key : integers.keySet()) {
      CgenSupport.emitLabelDef(String.format("int_const%d", integers.get(key)), p);
      CgenSupport.emitIntConstant(key, p);
    }
  }

}
