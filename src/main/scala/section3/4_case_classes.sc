case class SomeCaseClass(w: Int, var x: Int, y: Int = 100, private var z: Int)
//                       |           |       |                         |
//                       |           |       |                         private mutable variable
//                       |           |       |
//                       |           |       public immutable with default
//                       |           |
//                       |           public mutable variable
//                       |
//                       public immutable value
//

case class User(name: String, surname: String, age: Int) {
  val hasFullage = age >= 18
  def fullName = name + " " + surname

  // We can copy our self with single parameters changed
  def birthday = this.copy(age = age + 1)
}

// Case classes have builtin factory methods
val user_one = User("Max", "Mustermann", 23)
val user_two = User("Max", "Mustermann", 23)

// case classes has a builtin equals method
user_one == user_two

// case classes can copy itself with single or more changes
user_one.birthday

// case classes has a builtin hash method
user_one.hashCode
user_one.birthday.hashCode
