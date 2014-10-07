package futures

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object FutureExmpl extends App {
  val f1 = Future {
    Thread.sleep(3000)
    println("Das war der Thread 1")
    "Welt"
  }

  val f2 = Future {
    Thread.sleep(1000)
    println("Das war der Thread 2")
    "Hallo"
  }

  val f3 = Future {
    Thread.sleep(100)
    println("Das war der Thread 3")
    " "
  }

  val superF:Future[String] = for {
    welt <- f1
    hallo <- f2
    blank <- f3
  } yield { hallo + blank + welt }

  println("Main thread")
  val result: String = Await.result(superF, Duration.Inf)
  println(result)
}
