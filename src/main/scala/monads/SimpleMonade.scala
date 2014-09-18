package monads

object MonadeExample extends App {

  val elem: Int = 4711
  val monade: SimpleMonade[Int] = new SimpleMonade[Int](elem)



  val strMonade = new SimpleMonade("hallo")

  val strValue = strMonade
    .flatMap(str => new SimpleMonade(str + " Welt"))
    .flatMap(str => new SimpleMonade(str.toUpperCase))

  println(strValue.element)
}
/**
 * We have a class which encapsulate
 * an element. We can turn an t into an M of t
 * with a value constructor. In our example it's simple
 * the class constructor
 */
class SimpleMonade[T](val element: T) {

  /**
   * flatMap defines a binding method which only changes the internal typ
   * of our monade.
   *
   * @param f
   * @tparam B
   * @return
   */
  def map[B](f: T => B): SimpleMonade[B] = new SimpleMonade[B](f(element))

  /**
   * A Monade defines a binding method, which takes a function
   * which converts the inside element of type T into a monade of type B
   *
   * The method can implement a side effect or simple perform the function
   * on the element.
   *
   * Or on all elements if we want to implement some kind of List.
   *
   * We can also insert a default value or an monade inherited object
   * if the element has a specific state. Like Option with its Some and None.
   */
  def flatMap[B](f: T => SimpleMonade[B]): SimpleMonade[B] = f(element)
}
