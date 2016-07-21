package section1

import java.io.InputStream

object Section1 {
  // implement the ???
  // and change if necessary the 'def' with 'val', 'var' or 'lazy val'
  def message: String = ???
  def greeting: String = ???
  def max(x: Int, y: Int): Int = ???

  def expr(): String = {
    var result = ""
    // change the 'def' with 'val', 'var' or 'lazy val' or let it stay a 'def'
    // Ask yourself, when which block is executed.
    def x: Int = { result += "x"; 1 }
    def y: Int = { result += "y"; 2 }
    def z: Int = { result += "z"; 3 }

    // Do not edit this line. ;-)
    z + y + x + z + y + x
    result
  }

  def exception: Int = throw new RuntimeException
  def newConst(x: Int, y: Int) = x

  // Return a function which takes one parameter and multiply it with the 'x' value
  def someIntFunction(x: Int): (Int => Int) = ???

  def withFiles(fileNames: String*)(useInputStream: InputStream => Unit) : Unit = ???

  def stringOf(is: InputStream) = scala.io.Source.fromInputStream(is).mkString
}
