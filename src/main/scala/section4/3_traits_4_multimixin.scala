package section4

package MultiMixin {
  class Car

  /**
   * We have an abstract type and two implementations
   */
  trait Engine {
    def run()
  }

  trait BigEngine extends Engine {
    override def run() = println("RRÖÖÖÖÖÖÖÖÖÖAAAAAAAAAAAAAAAAAARRRRRRRRRRRRRRRRRRRR")
  }

  trait LittleEngine extends Engine {
    override def run() = println("töf töf töf")
  }

  /**
   * We define a car with two engines. Which one will start?
   * We also can access the traits origin methods over the super reference
   */
  object MultiMixin extends App {
    val car = new Car with LittleEngine with BigEngine {
      def runLittle() = super[LittleEngine].run()
      def runBig() = super[BigEngine].run()
    }

    // Which engine will start?
    car.run()
    car.runLittle()
    car.runBig()
  }
}
