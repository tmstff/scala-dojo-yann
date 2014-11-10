package section7

object Implicits extends App {
  val x: java.lang.Integer = 4

  val j: Int = 10

  //println(x.+(j))

  case class Rational(numer: Int, denom: Int) {
    def +(r: Rational): Rational = Rational(
      r.numer * denom + numer * r.denom,
      r.denom * denom
    )
  }

  object Rational {
    implicit def IntToRational(x: Int): Rational = Rational(x, 1)
  }

  val add = Rational(1,4) + Rational(3, 4)
  println(add)


  val y: Int = x
  Rational(1, 3) + y
  println(1 + Rational(1, 3))
}
