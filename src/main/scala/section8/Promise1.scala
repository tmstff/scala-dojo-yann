package section8

import scala.concurrent.{Await, Promise, Future}
import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.Date

object Promise1 extends App {
  val baseFuture = Future {
    println("baseFuture: " + Thread.currentThread().getId + " : " + new Date)
    Thread.sleep(2000)

    42
  }

  val promise = Promise[Int]()

  baseFuture.onSuccess{
    case result => {
      println("onSuccess: " + Thread.currentThread().getId + " : " + new Date)
      Thread.sleep(2000)

      promise success result
    }
  }

  println(Await.result(promise.future, 8.seconds))
}
