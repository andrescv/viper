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


/** A basic counter implementation. */
public final class Counter {

  /** counter value */
  private int n;

  /**
   * Creates a counter with an initial value.
   *
   * @param n counter initial value
   */
  public Counter(int n) {
    this.n = n;
  }

  /**
   * Increments counter.
   *
   * @return counter value before increment
   */
  public int inc() {
    return n++;
  }

  /**
   * Decrements counter.
   *
   * @return counter value before decrement
   */
  public int dec() {
    return n--;
  }

  /**
   * Creates a copy of the counter.
   *
   * @return a copy of the counter
   */
  public Counter copy() {
    return new Counter(this.n);
  }

}
