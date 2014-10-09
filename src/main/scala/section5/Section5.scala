package section5

import scala.util.Try

object Section5 {

  class Cigarettes
  case class UnderAgeException(message: String) extends Exception(message)
  case class NoIdException(message: String) extends Exception(message)

  case class Customer(age: Int, haveId: Boolean = false) {
    require(age > 0)
  }

  class Store {
    def buyCigarettes(customer: Customer): Cigarettes = {
      if(customer.age < 18) throw new UnderAgeException(s"Customer must be older than 18 but was ${customer.age}")
      else if (!customer.haveId) throw new NoIdException("")
      else new Cigarettes
    }

    // Alternative 1:
    def buyCigarettes_(customer: Customer): Cigarettes = customer match {
      case c1 if c1.age < 18 => throw new UnderAgeException(s"Customer must be older than 18 but was ${c1.age}")
      case c2 if !c2.haveId  => throw new NoIdException("")
      case _ => new Cigarettes
    }
    // Alternative 2:
    def buyCigarettes__(customer: Customer): Cigarettes = customer match {
      case Customer(age, _) if age < 18 => throw new UnderAgeException(s"Customer must be older than 18 but was ${age}")
      case Customer(_, false) => throw new NoIdException("")
      case _ => new Cigarettes
    }
  }

  class LaxistStore extends Store {
    override def buyCigarettes(customer: Customer): Cigarettes = try {
      super.buyCigarettes(customer)
    } catch {
      case _ : NoIdException => new Cigarettes
    }

    // Alternative 1:
    override def buyCigarettes_(customer: Customer): Cigarettes = {
      if(customer.age < 18) throw new UnderAgeException(s"Customer must be older than 18 but was ${customer.age}")
      else new Cigarettes
    }

    // Alternative 2:
    override def buyCigarettes__(customer: Customer): Cigarettes =
      Try(super.buyCigarettes(customer)).recover{
        case _ : NoIdException => new Cigarettes
      }.get
  }

}
