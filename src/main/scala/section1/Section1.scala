package section1

object Section1 {
  def loop: Int = loop
  def constOne(x: Int, y: Int) = 1

  // you can change everything here
  def message: String = ???
  def greeting: String = ???
  def max(x: Int, y: Int): Int = ???

  def newConstOne(x: Int, y: Int) = 1

  def expr(): String = {
    var result = ""
    def x = { result += "x"; 1 }
    def y = { result += "y"; 2 }
    def z = { result += "z"; 3 }
    z + y + x + z + y + x
    result
  }
}
