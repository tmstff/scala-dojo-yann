package section1

import java.io.{FileInputStream, InputStream}

object Section1 {
  // implement the ???
  // and change if necessary the 'def' with 'val', 'var' or 'lazy val'
  def message: String = "Hello, World"
  var greeting: String = "Hello, World"
  def max(x: Int, y: Int): Int = if (x > y) x else y

  def expr(): String = {
    var result = ""
    // change the 'def' with 'val', 'var' or 'lazy val' or let it stay a 'def'
    // Ask yourself, when which block is executed.
    val x: Int = { result += "x"; 1 }
    lazy val y: Int = { result += "y"; 2 }
    def z: Int = { result += "z"; 3 }

    // Do not edit this line. ;-)
    z + y + x + z + y + x
    result
  }

  def exception: Int = throw new RuntimeException
  def newConst(x: Int, y: => Int) = x

  // Return a function which takes one parameter and multiply it with the 'x' value
  def someIntFunction(x: Int): (Int => Int) = _ * x

  def withStream(is: InputStream)(useInputStream: InputStream => Unit): Unit =
    try {
      useInputStream(is)
    } finally {
      is.close()
    }

  def withFiles(fileNames: String*)(useInputStream: InputStream => Unit) : Unit =
    fileNames.foreach(
      fileName => {
        val is = new FileInputStream(fileName)
        withStream(is)(useInputStream)
      }
    )
}
