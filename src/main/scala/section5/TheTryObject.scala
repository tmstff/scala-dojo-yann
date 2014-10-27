package section5

import scala.util.{Try, Success, Failure}

/**
 * If you like it more function the scala library has a Try class like Option.
 */
object TheTryObject extends App {

  // The statement (x/y) can throw an ArithmeticException.
  // So we encapsulate this statement into an Try object.
  def divide(x: Int, y: Int): Try[Double] = Try(x / y)

  // We use the returned Try object to recover a possible exception
  // with the value 24. We filter the value to only get even numbers and
  // then multiply the given number with itself.
  divide(4, 2)
    .recover[Double] {
      case _ : ArithmeticException => 42
    }
    .filter(value => value % 2 == 0)
    .map(value => value * value)
    .map(println)

  // As every monadic structure, also Try can be used in for-comprehensions
  // This method, combines three 'divide' returns to one Try object.
  val result: Try[Double] = for {
    x <- divide(4, 2)
    y <- divide(9, 3)
    z <- divide(2, 0)
  } yield {
    x + y + z
  }

  result match {
    case Failure(e) => println("OUH! An exception: " + e.getMessage)
    case Success(value) => println(value)
  }
}








