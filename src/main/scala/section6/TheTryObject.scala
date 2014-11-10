package section6

import scala.util.{Failure, Success, Try}

object TheTryObject extends App {
  def divide(x: Int, y: Int): Try[Double] = Try(x/y)

  val mayDouble = divide(4,0)


    val foo = mayDouble.recoverWith[Double] {
      case e: ArithmeticException => Try(42)
    }.filter(i => i%2 == 0).get


  println(foo)

  println(mayDouble.filter(i => i%2 == 0).getOrElse(0))

  divide(2, 0) match {
    case Success(value) => println(value)
    case Failure(e) => println(e.getMessage())
  }
}
