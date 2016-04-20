package section3

import section3.Section3.UserRepository.{female, male}

object Section3 {

  class Dog {

  }

  class Cat (private val name: String) {

    def barkAt(dog: Dog) = s"$name-cat is barked at by a dog"
  }

  case class User(
    id: Int,
    firstName: String,
    lastName: String,
    age: Option[Int],
    gender: Option[String])

  object UserRepository {

    val male = Some("male")
    val female = Some("female")

    private val users = Map(
      1 -> User(1, "John", "Boe", Some(32), male),
      2 -> User(2, "Johanna", "Coe", Some(30), None),
      3 -> User(3, "Alice", "Doe", None, female),
      4 -> User(4, "Lisa", "Foe", Some(8), female),
      5 -> User(5, "Kathrin", "Goe", Some(18), female),
      6 -> User(6, "Frank", "Zappa", Some(40), male),
      7 -> User(7, "Edith", "Piaff", Some(42), female)
    )

    def findById(id: Int): Option[User] = users.get(id)

    def findAll = users.values

    def computeAvarageAge(users: Seq[User] = findAll.toSeq): Int = ???
  }

  object TraditionalDatingAgency {

    def computeMatches(users: Seq[User]): Seq[(User, User)] = ???

  }

  def mkString(list: List[String], sep: String): String = ???

  object CologneDatingAgency {

    def computeMatches(users: Seq[User]): Seq[(User, User)] = ???
  }

  def isMale(id: Int): Boolean = ???

  def isUserAllowed(id: Int): Boolean = ???

}
