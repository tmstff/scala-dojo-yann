package section3

object Section3 {

  case class User(
    id: Int,
    firstName: String,
    lastName: String,
    age: Option[Int],
    gender: Option[String])

  object UserRepository {
    private val male = Some("male")
    private val female = Some("female")

    private val users = Map(
      1 -> User(1, "John", "Doe", Some(32), male),
      2 -> User(2, "Johanna", "Doe", Some(30), None),
      3 -> User(3, "Alice", "Doe", None, female),
      4 -> User(4, "Lisa", "Doe", Some(8), female),
      5 -> User(5, "Kathrin", "Doe", Some(18), female)
    )

    def findById(id: Int): Option[User] = users.get(id)

    def findAll = users.values
  }

  // Procedural style
  def isMale1(id: Int): Boolean = {
    val mayBeUser = UserRepository.findById(id)
    if(mayBeUser.isDefined) {
      val mayBeGender = mayBeUser.get.gender
      if(mayBeGender.isDefined && mayBeGender.get == "male") {
        true
      } else {
        false
      }
    } else {
      false
    }
  }

  // Functional style
  def isMale2(id: Int): Boolean = UserRepository.findById(id).exists(
    user => user.gender.exists(gen => gen == "male")
  )

  // Pattern match style
  def isMale3(id: Int): Boolean = UserRepository.findById(id) match {
    case Some(user) => user.gender match {
      case Some(gender) if gender == "male" => true
      case _ => false
    }
    case None => false
  }

  // For comprehensive style
  def isMale(id: Int): Boolean = (
    for {
      user <- UserRepository.findById(id)
      gender <- user.gender
      if gender == "male"
    } yield true
  ).getOrElse(false)

  def isUserAllowed(id: Int): Boolean = ???

}
