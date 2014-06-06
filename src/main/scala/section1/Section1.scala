package section1

object Section1 {
  def exception: Int = throw new RuntimeException
  def constOne(x: Int, y: Int) = 1

  // def with return value "Hello, World"
  def message: String = "Hello, World"
  // or as val. Static value
  val message2: String = "Hello, World"
  // This one has to be a var to be mutable
  var greeting: String = "Hello, World"

  // Simple if statement
  def max(x: Int, y: Int): Int = if (x > y) x else y

  /*
   hehe... ok.
   x is evaluated direct on method call -> result = "x"
   y is a lazy val. Will be evaluated on first read
   z is a method. Evaluates on every call

   We have:
   on start:                    result = "x"
   z -> method:                 result = "xz"
   y -> lazy val, first read:   result = "xzy"
   x -> evaluated val: nothing  result = "xzy"
   z -> method:                 result = "xzyz"
   y -> lazy val, evaluated:    result = "xzyz"
   x -> evaluated val: nothing  result = "xzyz"
  */
  def expr(): String = {
    var result = ""
    // change if necessary the 'def' with 'val', 'var' or 'lazy val'
    val x = { result += "x"; 1 }
    lazy val y = { result += "y"; 2 }
    def z = { result += "z"; 3 }
    z + y + x + z + y + x
    result
  }

  // We use call by name, so the parameter y will be evaluated on first read (like a lazy val)
  def newConst(x: Int, y: => Int) = x

  // Return a function which takes one parameter and multiply it with the 'x' value
  def someIntFunction(x: Int): (Int => Int) = {
    (y: Int) => y * x
  }
}
