package section3

import org.scalatest.FunSuite
import section3.Section3.UserRepository.{female, findAll, findById, male}
import section3.Section3._

class Section3Test extends FunSuite {

  test("a male user is male") {
    assert(Section3.isMale(1) === true)
  }

  test("an user without known gender is not male") {
    assert(Section3.isMale(2) === false)
  }

  test("a female user is not male ") {
    assert(Section3.isMale(3) === false)
  }

  test("a not found user is not male") {
    assert(Section3.isMale(999) === false)
  }

  test("male user is not allowed") {
    assert(Section3.isUserAllowed(1) === false)
  }

  test("user without known gender is not allowed") {
    assert(Section3.isUserAllowed(2) === false)
  }

  test("female user with unknown age is not allowed") {
    assert(Section3.isUserAllowed(3) === false)
  }

  test("female user with age < 18 is not allowed") {
    assert(Section3.isUserAllowed(4) === false)
  }

  test("female user with age >= 18 is allowed") {
    assert(Section3.isUserAllowed(5) === true)
  }

  test("one can write method calls in reversed order") {
    val dog: Dog = new Dog()
    val cat: Cat = new Cat("Kitty")
    // a dog can not be barked at by a cat - change method barkAt (and method call) in such a way that
    // the written order of the arguments and the method call makes sense (Hint: section 3, slide 3)
    // i.e. the dog barks at the cat
    assert((cat barkAt dog) === "Kitty-cat is barked at by a dog")
  }

  test("we can find matching adult couples - in a 'traditional' way") {
    // sort males and females by age. Couple first male with first female etc.
    // gender and age has to be present, age has to be >= 18
    assert(
      TraditionalDatingAgency.computeMatches( findAll.toList ) ===
        (findById(1).get, findById(5).get) ::
        (findById(6).get, findById(7).get) :: Nil
    )
  }

  test("we can find matching adult couples - the 'Cologne' way") {
    // Sort users by age. Ignore genders. Couple first with second, then third with fourth and so on.
    // age has to be present, age has to be >= 18
    assert(
      CologneDatingAgency.computeMatches( findAll.toList ) ===
        (findById(5).get, findById(2).get) ::
        (findById(1).get, findById(6).get) :: Nil
    )
  }

}
