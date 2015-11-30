package section1

object LazyvalMain {
  def main(args: Array[String]) = {
    lazy val foo = {
      println("Hallo Welt")
      "Hallo"
    }

    println(foo)
    println(foo)

  }

}
