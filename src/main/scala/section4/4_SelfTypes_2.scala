package section4

package selfTypes2 {
  /**
   * Now we have passengers and a little choo choo train.
   * The train needs a conductor inheritance to control the passengers.
   *
   * Here the self type defines, that a Train instance must be inherited by a Conductor or must mixed in a Conductor.
   * It only must be A Conductor. So all inherited conductors are possible for mixin. --> Cake pattern!
   * @param hasTicket
   */
  case class Passenger(hasTicket: Boolean)
  class Train(var passengers: List[Passenger]) {
    this: Conductor =>
  }

  /**
   * Now we define a conductor hierarchy
   */
  trait Conductor {
    def findFareDodgers: Int
  }

  /**
   * We have a hard working conductor. He controls every passenger.
   * Therefore he needs access to the train and therefore its passengers
   */
  trait HardWorkingConductor extends Conductor {
    this: Train =>
    def findFareDodgers: Int = passengers.count(p => !p.hasTicket)
  }

  /**
   * Also we have a lazy conductor. He will always sit in his
   * conductor office and reports 0 daredodgers. He does not really need a train
   */
  trait LazyConductor extends Conductor {
    def findFareDodgers: Int = 0
  }

  /**
   * So we define two trains. All trains need a conductor but we can choose which implementation we mixin.
   */
  object SelfType2 extends App {
    val passengers = List(Passenger(true), Passenger(false), Passenger(true), Passenger(false))

    //val willNotCompileTrain = new Train(passengers)
    val train1 = new Train(passengers) with LazyConductor
    val train2 = new Train(passengers) with HardWorkingConductor
  }
}
