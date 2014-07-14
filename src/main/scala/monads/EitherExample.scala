package monads

object EitherExample extends App {
  println(sumSomething(6, 7))

  def sumSomething(x: Int, y: Int): String = {
    def validateX(x: Int): Either[String, Int] = {
      if (x <= 5) Left("x must be greater 5!!!") else Right(x)
    }

    def validateY(y: Int): Either[String, Int] = {
      if (y <= 8) Left("y must be greater 8!!!") else Right(x)
    }

    validateX(x).right.flatMap { valid_x =>
      validateY(y).right.map { valid_y => valid_x + valid_y }
    }.fold[String] (
      (error: String) => error,
      (value: Int) => s"The value is $value"
    )
  }
}
