package section5

object Section5 {

  class Cigarettes
  case class UnderAgeException(message: String) extends Exception(message)
  case class NoIdException(message: String) extends Exception(message)

  case class Customer(age: Int, haveId: Boolean = false) {
    // hint: you can use the require function
  }

  class Store {
    def buyCigarettes(customer: Customer): Cigarettes = ???
  }

  class LaxistStore extends Store {
    override def buyCigarettes(customer: Customer): Cigarettes = ???
  }

}
