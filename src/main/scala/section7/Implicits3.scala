package section7

/**
 * Implicit parameters
 * Implicit parameters can be used for periodic use of a single value.
 * Such as session Ids, runtime contexts and so on.
 */


// First of all we define an example class.
// Our class defines three methods:
// * step1 is public.
// * step1 calls step2
// * step2 calls step3

// The methods have two parameter lists. Implicit parameters must only exist in the last
// parameter list.
// The x defines a string.
// The y parameter defines an int and is implicit.
class SomeFooClass {

  // The step1 method has the implicit y value.
  // If we look at the step2 method, this has also an implicit y parameter.
  def step1(x: String)(implicit y: Int) {
    // So we can call step2 only with the explicit x parameter.
    // y is add implicit.
    step2(x)
  }

  // As step1, step2 passes the implicit value y to the step3 method.
  private def step2(x: String)(implicit y: Int) {
    step3(x)
  }

  // Step3 uses the implicit value y in the println function.
  private def step3(x: String)(implicit y: Int) {
    println(s"X is $x and Y is: $y")
  }
}

object Implicits3 extends App {
  // Now we will use the SomeFooClass
  // First we apply the second parameter explicit
  val foo = new SomeFooClass
  foo.step1("Hallo welt")(4)

  // But we can also define an implicit value in out scope.
  // So, someInt will be automatically passed to the step1 method.
  implicit val someInt = 24
  foo.step1("Hallo!")
}


