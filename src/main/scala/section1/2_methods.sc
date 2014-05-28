import scala.annotation.tailrec

// Defining methods short and long
def sum(x: Int, y: Int): Int = {
  val z = x + y
  z // The last expression is the return value
}

def sum2(x: Int, y: Int):Int = x+y
sum(3, 4)


// Defining unit (aka void) methods
def unitMethod(x: String) { // <-- no return type and no equals sign: return type is Unit
  println(x)
}

def unitMethod2(x: String):Unit = { // Return type is explicit Unit. We must write it with a '=' char.
  println(x)
}
// Invalid method. Return type is Int, but without the '=' character
/*
 def invalid(x: String):Int {
   42
 }
*/


// repeated parameters
def repeatedParameters(values: String*) = {
  values.mkString(" ")
}
repeatedParameters("Hallo", "Welt", "!!!")

// named arguments
def namedArguments(value: String, splitAt: Char) = {
  value.split(splitAt)
}

namedArguments(splitAt = '.', value = "Hallo.Welt.!!!")

// Default parameter values
def splitMethodDefault(value: String, splitAt: Char = '.') = {
  value.split(splitAt)
}
splitMethodDefault("Hallo.Welt.!!!")


//
// Methods in methods:
// We can define a method inside a method body:
def recusiveListSumFolder(list: List[Int]) = {
  @tailrec
  def step(sum: Int, elements: List[Int]): Int = {
    if(elements.isEmpty) {
      sum
    } else {
      step(sum + elements.head, elements.tail)
    }
  }

  step(0, list)
}
recusiveListSumFolder(List(1, 2, 3, 4, 5))


//
// Is call by reference and reference manipulation possible?
var x = List(1, 2, 3)
def tryOfCallbyReference(param: List[Int]) {
  // param = List(1, 2, 3, 4) Error: Reassignment to val

  // The params value is a reference on x,
  // but since all params are vals there is no reference manipulation!
}

