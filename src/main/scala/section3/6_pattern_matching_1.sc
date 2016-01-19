/****
 * Simple match
 */
// We define a method with one string argument.
// matches are expression. So they return always a value!
def describe(x: String) = x match {
  case "Hallo" => "some hello"
  case "Hallo Welt" => "some hello world"
}
// Will return "some hello world"
describe("Hallo Welt")
// Will return "some hello"
describe("Hallo")
// Will throw an MatchError
describe("Foo")



/****
 * Constant pattern and default value with wildcard pattern
 */
def describe2(x: Any) = x match {
  case 10 => "ten"
  case true => "true"
  case "hello" => "hi!"
  case Nil => "empty List"
  case _   => "something else"  // <--- Wildcard pattern as default value
}

describe2(10)
describe2(Nil)
describe2(Unit)

/****
 * Variable pattern
 */
// We can match the value into a variable:
42 match {
  case 0 => println("zero")
  case someVar => println(someVar)
}

// But attention with constant values!
import math.{E, Pi}
val pi = Pi
E match {
  case pi => "strange math? Pi = " + pi
  case _ => "Ok"
}


// To match the pi value with constant value,
// we have to escape it with two ticks:
// USE CONSTANT NAMES WITH AN LEADING UPPERCASE CHARACTER
E match {
  case `pi` => "strange math? Pi = " + pi
  case _ => "Ok"
}

/****
 * Constructor pattern with case classes
 */
abstract class Gender
object Male extends Gender
object Female extends Gender

case class User(name: String, surname: String, age: Int, gender: Gender)

val max = User("Max", "Mustermann", 34, Male)
val martina = User("Martina", "Musterfrau", 16, Female)
def users(user: User) = user match {
  case User(name, "Mustermann", _, Male) => println(s"some male with surname Mustermann named: "+ name)
  case User(name, _, _, Female) => println(s"some female named: "+ name)
  // unreachable code!
  case User(name, _, 34, Male) => println(s"some male named: "+ name)
}

users(max)
users(martina)



