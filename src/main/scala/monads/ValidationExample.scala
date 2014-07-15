package monads

trait Validation[T] {
  def map[B](f: T => B): Validation[B]

  def flatMap[B](f: T => Validation[B]): Validation[B]
}

case class Invalid(error: String) extends Validation[Nothing] {
  def map[B](f: (Nothing) => B): Validation[B] = this

  def flatMap[B](f: (Nothing) => Validation[B]): Validation[B] = ???
}

case class Valid[T](value: T) extends Validation[T] {
  def map[B](f: (T) => B): Validation[B] = Valid(f(value))

  def flatMap[B](f: (T) => Validation[B]): Validation[B] = f(value)
}

object ValidationExample extends App {

}
