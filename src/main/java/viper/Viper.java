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
package viper;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import viper.syntax.Parser;
import viper.tree.Program;


/** Viper compiler main class. */
public final class Viper {

  /** Prints help message. */
  private static void help() {
    System.out.println(" _   ___");
    System.out.println("| | / (_)__  ___ ____");
    System.out.println("| |/ / / _ \\/ -_) __/");
    System.out.println("|___/_/ .__/\\__/_/");
    System.out.println("     /_/");
    System.out.println();
    System.out.println("usage: viper [options] <files>");
    System.out.println();
    System.out.println("Options:");
    System.out.println("  -h, --help    show this help message and exit");
    System.out.println("  -s, --semant  stop compilation before codegen, dump AST to stdout and exit");
    System.out.println("  -g, --debug   enable debug flag");
    System.exit(0);
  }

  /**
   * Prints a cmd line error.
   *
   * @param msg error message
   */
  private static void error(String msg, boolean help) {
    System.out.println(" _   ___");
    System.out.println("| | / (_)__  ___ ____");
    System.out.println("| |/ / / _ \\/ -_) __/");
    System.out.println("|___/_/ .__/\\__/_/");
    System.out.println("     /_/");
    System.out.println();
    System.out.println("error: " + msg);
    if (help) {
      System.out.println();
      System.out.println("usage: viper [options] <files>");
      System.out.println();
      System.out.println("Options:");
      System.out.println("  -h, --help    show this help message and exit");
      System.out.println("  -s, --semant  stop compilation before codegen, dump AST to stdout and exit");
      System.out.println("  -g, --debug   enable debug flag");
    }
    System.exit(0);
  }

  /**
   * Viper compiler main method.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    Options options = new Options();
    options.addOption(Option.builder("h").longOpt("help").build());
    options.addOption(Option.builder("s").longOpt("semant").build());
    options.addOption(Option.builder("g").longOpt("debug").build());
    try {
      DefaultParser parser = new DefaultParser();
      CommandLine cmd = parser.parse(options, args);
      if (cmd.hasOption("help")) {
        help();
      }
      Flags.SEMANT = cmd.hasOption("semant");
      Flags.DEBUG = cmd.hasOption("debug");
      String[] files = cmd.getArgs();
      if (files.length == 0) {
        error("no files passed", true);
      } else {
        for (String arg : files) {
          if (arg.endsWith(".vp")) {
            File file = new File(arg);
            if (file.exists()) {
              Program program = Parser.parse(file);
              program.semant();
              if (Flags.SEMANT) {
                program.dump(System.out);
              } else {
                program.code();
              }
            } else {
              error("file " + arg + " not found", false);
            }
          } else {
            error("invalid file: " + arg, false);
          }
        }
      }
    } catch (ParseException e) {
      error(e.getMessage().toLowerCase(), true);
    }
  }

}
