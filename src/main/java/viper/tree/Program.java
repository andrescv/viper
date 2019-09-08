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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import viper.misc.CgenSupport;
import viper.misc.SemantErrors;
import viper.misc.SymbolTable;
import viper.misc.Constants;
import viper.misc.Type;


/** Represents a Viper program. */
public final class Program {

  /** program file */
  private final File file;
  /** program functions */
  private final Functions functions;

  /**
   * Creates a new Viper program.
   *
   * @param file program file
   * @param functions program functions
   */
  public Program(File file, Functions functions) {
    this.file = file;
    this.functions = functions;
  }

  /** Performs the semantic analysis of the program. */
  public void semant() {
    SemantErrors.setFile(file);
    // function mapping, M[name] = Function
    HashMap<String, Function> M = new HashMap<>();
    SymbolTable O = new SymbolTable();
    // install basic functions
    M.put(
      "print",
      new Function(
        -1, -1,
        "print",
        (new Formals()).add(new Formal(-1, -1, "arg", Type.NOTYPE)),
        Type.VOID,
        new Statements(),
        new NoReturn(-1, -1)
      )
    );
    M.put(
      "println",
      new Function(
        -1, -1,
        "print",
        (new Formals()).add(new Formal(-1, -1, "arg", Type.NOTYPE)),
        Type.VOID,
        new Statements(),
        new NoReturn(-1, -1)
      )
    );
    M.put(
      "input",
      new Function(
        -1, -1,
        "input",
        (new Formals()).add(new Formal(-1, -1, "arg", Type.STR)),
        Type.INT,
        new Statements(),
        new Return(
          -1, -1,
          new IntConst(-1, -1, "0")
        )
      )
    );
    // install all program functions
    for (int i = 0; i < functions.size(); i++) {
      Function f = functions.get(i);
      if (M.containsKey(f.name)) {
        SemantErrors.functionIsAlreadyDefined(f.line, f.col, f.name);
      } else {
        M.put(f.name, f);
      }
    }
    // call semant
    functions.semant(O, M);
    // found semantic errors
    if (SemantErrors.hasErrors()) {
      System.err.println("Compilation halted due to static semantic errors.");
      System.exit(-1);
    }
  }

  /** Generates the assembly code that represents the Viper program. */
  public void code() {
    try {
      String name = file.getAbsolutePath();
      String filename = name.substring(0, name.lastIndexOf('.')) + ".s";
      PrintStream p = new PrintStream(new FileOutputStream(filename));
      SymbolTable O = new SymbolTable();
      // code global data
      CgenSupport.emitGlobl(CgenSupport.MAIN, p);
      CgenSupport.emitData(p);
      Constants.code(p);
      // generate code
      CgenSupport.emitText(p);
      functions.code(O, p);
    } catch (IOException e) {
      System.err.println("Compilation halted due to I/O errors");
      System.exit(-1);
    }
  }

  /** Prints a representation of the program AST. */
  public void dump(PrintStream p) {
    p.println(String.format("Program(%s)", file.toString()));
    functions.dump(p, 2);
  }

}
