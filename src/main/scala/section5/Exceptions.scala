package section5

import java.util.NoSuchElementException
import scala.NoSuchElementException

object Exceptions extends App {
  val handler: PartialFunction[Throwable, Unit] = {
    case e: RuntimeException =>  println("re caught")
  }

  val handler2 : PartialFunction[Throwable, Unit] = {
    case e: IllegalArgumentException=>  println("iae caught")
  }

  val newHandler : PartialFunction[Throwable, Unit] = {
    case e: NoSuchElementException=>  println("nse caught")
  }

  val handler3 = handler2 orElse newHandler orElse handler

  println(handler3.isDefinedAt(new NoSuchElementException("Hallo Welt!")))

  try {
    throw new NoSuchElementException("Hallo Welt!")
  } catch handler3
  finally {
    println("finally")
  }
}
