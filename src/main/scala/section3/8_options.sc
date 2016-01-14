/**
 * Option is a container model for parameters and return values
 * which can be obsolete or nullable.
 *
 * It is designed to give developers the hint, that a method
 * can return an empty value.
 */

// Option is an sealed abstract class which has
// two inherited entities:
// "None" defines the absent/empty/null value of the Option parameter or return value.
val o: Option[String] = None

// "Some" takes an object and defines therefore the existent value
val oo: Option[String] = Some("hello World")

// All Options has the same api
// True if Some( value ) or false if None
o.isDefined
// If None, return "foo"
o.getOrElse("foo")
// Is this object defined and has a specific value ?
oo.exists(value => value == "hello World")
// Convert Option[A] to Option[B]
oo.map(value => value.split(' ').toList)


// Option implements the Collection api, so
// have map, flatMap and withFilter.
// With this methods, we can use it in a for comprehension
val may_hello = Some("Hello")
val may_world = Some("World")

// Collapse multiple Options and yielding their values
// The return is also an option, cause we don't know
// if one value is a None
val value = for {
  hello <- may_hello
  world <- may_world
} yield {
  hello + " " + world
}

// Ok. A "foreach" on an single optional value sounds
// a little bit weird. But collection api tells so.
value.foreach(println(_))

// Or we can make it less functional:
println(value.getOrElse("nothing"))




