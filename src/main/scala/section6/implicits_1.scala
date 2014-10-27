package Implicits {
  case class Rational(numer: Int, denom: Int) {
    def + (r: Rational): Rational = Rational(
      r.numer * denom + numer * r.denom,
      r.denom * denom
    )
  }

  object Rational {
    implicit def fromIntToRational(value: Int): Rational = Rational(value, 1)
  }

  object Section6 extends App {
    println(Rational(1, 3) + Rational(2, 3))
    println(Rational(1, 3) + 1)

    val foo = new SomeFooClass
    foo.step1("Hallo welt")(2)

    implicit val someInt = 24
    foo.step1("Hallo!")
  }

  class SomeFooClass {
    def step1(x: String)(implicit y: Int) {
      step2(x)
    }

    private def step2(x: String)(implicit y: Int) {
      step3(x)
    }

    private def step3(x: String)(implicit y: Int) {
      println(s"X is $x and Y is: $y")
    }
  }
}


