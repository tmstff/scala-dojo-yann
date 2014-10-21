package section4

import java.util.Date

// A simple trait with two fields which must be set with a value.
// Also an implementation of an method
trait Person {
  val name: String
  val gender: String
  def sayHello() = println(s"Hello! I'm $name!")
}

// We can "mix in" the trait with 'extends' or 'with'
// Scala has NO native multi inheritance!
class Student(val name: String, val gender: String) extends Person

// We can define another trait which we want to mix in into our subclass
trait CantinaUser {
  private var budget: Int = 0

  def actualBudget = budget

  def buyFood(costs: Int) = if(budget - costs < 0) {
    throw new RuntimeException("You can not buy food! Not enough money!")
  } else {
    budget = budget - costs
  }

  def deposit(value: Int) = budget = budget + value
}

// Now our employee is a person and has a CantinaUser mixin
class Employee(val name: String, val gender: String) extends Person with CantinaUser {
  val beginOfEmployment = new Date
}

object ## extends App {
  val student = new Student("max", "male")
  student.sayHello()

  val employee = new Employee("Susan", "female")
  employee.sayHello()
  employee.deposit(100)
  println(employee.actualBudget)

  // The trait and therefore our object has its own type
  var user: CantinaUser = employee
}
