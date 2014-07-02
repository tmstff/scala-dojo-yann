import scala.Predef._
import scala.Some
abstract class Gender
case object Male extends Gender
case object Female extends Gender
case class User(name: String, surname: String, age: Int, gender: Gender)

/****
 * Sequence pattern
 */
List(1, 2, 3, 4) match {
  case List(first, _, _) => println("Three item list with first element" + first)

  // List with arbitrary length
  case List(first, _*) =>  println("Large list with first: " + first)
}

/****
 * Tuple patterns
 */
(1, 2, 3) match {
  case (_, _, 2) => println("_, _, 2")
  case (_, 2, 4) => println("_, 2, 4")
  case (1, _, _) => println("1, _, _")
}

/****
 * Typed patterns
 */
val male: Option[Gender] = Some(Male)
val female: Option[Gender] = Some(Female)
val nothing: Option[Gender] = None

def optionMatcher(x: Option[Any]) = x match {
  case Some(gender) => gender match {
    case str : String => println("A String with value: " + str)
    case gend : Gender => println("A Gender with value: " + gend)
  }
  case None => println("Nothing!")
}

optionMatcher(male)
optionMatcher(female)
optionMatcher(nothing)
optionMatcher(Some("hallo"))

// WARNING for TYPE ERASURES!!!
// As in Java there are NO generic information at runtime!
// So the JVM can NOT verify that the given Map ist of type Map[Int, Int]
// The case will match all Map[Any, Any]!
def isIntCollection(x: Any) = x match {
  case m: Map[_, Int] => true
  case a: Array[Int] => true
  case _ => false
}


// So this example will return true!
// An equal java example:
// http://docs.oracle.com/javase/tutorial/java/generics/bridgeMethods.html
isIntCollection(Map("x" -> "y"))

// But wait... FALSE?!
// Why does this not match the Array[Int]?
// Because arrays are NOT type erased on the JVM. There has always been typed arrays
// like String[] or int[] or something else in Java.
// Arrays stores their type also on runtime!
// http://code.stephenmorley.org/articles/java-generics-type-erasure/
isIntCollection(Array("hallo"))

/****
 * Variable binding
 */
// How we can get this list out of the Option in one step?
Some(List(1, 2)) match {
  case Some(List(_, _)) => true
}
// Variable binding!
Some(List(1, 2)) match {
  case Some(l @ List(_, _)) => println(l.head)
}

/****
 * Pattern guards
 */
// We can adding some guards to a case clause
User("Hans", "Meier", 19, Male) match {
  case User(_, _, age, Male) if age > 18 => println("Adult male")
  case User(_, _, _, Male) => println("childish male")
}









