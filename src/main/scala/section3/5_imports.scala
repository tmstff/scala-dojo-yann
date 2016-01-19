package section3

// Standard import
import java.util.ArrayList

// Static import
import Helper.help1

// Multi import without wildcard
import java.util.{Random, Base64}

// Wildcard import with _
import java.lang.Math._

// Renaming
import java.util.{List => JavaList}

class Imports {
  val list = new ArrayList()
  help1()

  def randomString = Base64.getEncoder.encode(new Random().nextInt().toString.getBytes())

  abs(-5)

  val jList: JavaList = list

}

object Helper {
  def help1() = println("help1")

  def help2() = println("help2")
}
