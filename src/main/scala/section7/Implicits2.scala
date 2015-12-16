package section7

object Implicits2 extends App {

  /**
   * In this example we define a new class Rational which represents
   * rational number with a numerator and a denominator.
   *
   * With a self defined "+"-method, we can add another Rational
   * and create a new Rational with the added values.
   */
  case class Rational(numer: Int, denom: Int) {
    def + (r: Rational): Rational = Rational(
      r.numer * denom + numer * r.denom,
      r.denom * denom
    )
  }

  // So let test this:
  val add = Rational(1, 3) + Rational(2, 3)
  assert(add == Rational(9, 9))
  println(add)


  // And now let us add a pure integer to our Rational:
  // We will expect an result of 4/3
  val intAdd = Rational(1, 3) + 1
  assert(intAdd == Rational(4, 3))
  println(intAdd)

  // But how does the "+"-method know how to deal with the integer!?
  // The method is only defined for the Rational type:
  //  ---> def + (r: Rational)

  // The answer is this companion object, which defines a implicit convert method
  // This method takes an integer value i and converts it to a Rational(i,1)
  // This new rational therefore, is passed as the "r"-parameter of the "+"-method.
  //
  // PS: The method can also be defined everywhere in the used scope.
  object Rational {
    implicit def fromIntToRational(value: Int): Rational = Rational(value, 1)
  }

  // Does this also works with an java Integer?
  /*
      val i: java.lang.Integer = 42
      new Rational(1, 1) + i
   */
  // In the last example we saw, that we can convert the Integer to an int with Predef
  // So this code should compiled to:
  // new Rational(1, 1) + fromIntToRational(Integer2int(i)) or?
  // No! Because the scala compiler does not nest implicits conversion cause of complexity and performance
  // Think of the problem of possible infinite resolving and conversion loop.

  // But if we are a little bit more verbose we can write:
  val i: java.lang.Integer = 42
  val j: Int = i
  new Rational(1, 1) + j

  // Further information:
  // http://www.artima.com/pins1ed/implicit-conversions-and-parameters.html

  // Hint!
  // Do not add implicits as much as you can. Too much and not intuitional conversions make your code
  // unreadable!
}


