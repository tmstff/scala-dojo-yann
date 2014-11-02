package section8

import scala.concurrent.Future
import java.security.MessageDigest
import scala.concurrent.ExecutionContext.Implicits.global
import sun.misc.BASE64Encoder
import java.io.InputStreamReader

object FutureExample extends App {

  /**
   * This method returns a future of a character stream
   */
  def loadResourceStream(resourceName: String): Future[Stream[Char]] = Future {
    val in = new InputStreamReader(this.getClass.getResourceAsStream(resourceName))
    Stream.continually(in.read()).takeWhile(_ != -1).map(_.toChar)
  }

  /**
   * This method takes a character stream and returns a string future
   * which contains the sha1 calculated hash of the character stream.
   */
  def calculateSHA1(content: Stream[Char]): Future[String] = Future {
    val hash = MessageDigest.getInstance("SHA1")
    content.foreach(c => hash.update(c.toByte))
    new BASE64Encoder().encode(hash.digest())
  }

  /**
   * This method takes a character stream and returns a boolean future
   * which contains the result of a virus check.
   */
  def checkForVirus(content: Stream[Char]): Future[Boolean] = Future {
    val definition = "virus"
    val findVirus = (mayVirus: String, elem: Char) => {
      if (definition.startsWith(mayVirus + elem)) {
        mayVirus + elem
      } else if(mayVirus == definition) {
        mayVirus
      } else {
        ""
      }
    }

    content.foldLeft[String]("")(findVirus) == definition
  }

  case class ResourceInfo(content: String, hash: String, containsVirus: Boolean)
}

