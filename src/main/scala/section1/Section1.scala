package section1

object Section1 {
  def exception: Int = throw new RuntimeException
  def constOne(x: Int, y: Int) = 1

  // implement the ???
  // and change if necessary the 'def' with 'val', 'var' or 'lazy val'
  def message: String = "Hello, World"
  var greeting: String = "Hello, World"

  def max(x: Int, y: Int): Int = if (x > y) x else y

  def newConstOne(x: Int, y: => Int) = 1

  def expr(): String = {
    var result = ""
    // change if necessary the 'def' with 'val', 'var' or 'lazy val'
    val x = { result += "x"; 1 }
    lazy val y = { result += "y"; 2 }
    def z = { result += "z"; 3 }
    z + y + x + z + y + x
    result
  }

  def newConst(x: Int, y: => Int) = x

  // Return a function which takes one parameter and multiply it with the 'x' value
  def someIntFunction(x: Int): (Int => Int) = (y:Int) => x * y

}
