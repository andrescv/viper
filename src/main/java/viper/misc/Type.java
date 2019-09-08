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


/** Represents a Viper type. */
public final class Type {

  /** Viper int type. */
  public static final Type INT = new Type("int");
  /** Viper bool type */
  public static final Type BOOL = new Type("bool");
  /** Viper str type */
  public static final Type STR = new Type("str");
  /** Viper void type */
  public static final Type VOID = new Type("void");
  /** Viper UNK type (no type) */
  public static final Type NOTYPE = new Type("notype");

  /** type identifier */
  private String id;

  /**
   * Creates a new Viper type.
   *
   * @param id type id
   */
  private Type(String id) {
    this.id = id;
  }

  /**
   * Verifies if the type is an int type.
   *
   * @return true if the type is int, false if not
   */
  public boolean isInt() {
    return this == INT;
  }

  /**
   * Verifies if the type is a bool type.
   *
   * @return true if the type is bool, false if not
   */
  public boolean isBool() {
    return this == BOOL;
  }

  /**
   * Verifies if the type is a str type.
   *
   * @return true if the type is str, false if not
   */
  public boolean isStr() {
    return this == STR;
  }

  /**
   * Verifies if the type is a void type.
   *
   * @return true if the type is void, false if not
   */
  public boolean isVoid() {
    return this == VOID;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return id;
  }

}
