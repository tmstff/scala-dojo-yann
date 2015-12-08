package specials.cakepattern

trait AAService {
  def callService(x: String)
}

trait AAServiceComponent {
  val aaService: AAService

  class AAServiceDefault extends AAService {
    def callService(x: String): Unit = println(s"AAService says: '$x'")
  }
}
