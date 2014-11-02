package section8

import scala.concurrent.{Await, Promise, Future}
import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.Date

object SomeAsynchronousService {
  def makeSomeAsynchronous(value: Int, successHandler: PartialFunction[Int, Unit]) = {
    val f = Future {
      println("some example asynchronous request: " + Thread.currentThread().getId + " : " + new Date)
      Thread.sleep(2000)
      value * value
    }

    f.onSuccess(successHandler)
  }
}

object PromiseExample extends App
