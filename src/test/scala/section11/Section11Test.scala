package section11

import org.scalatest.{FunSuite, Matchers, GivenWhenThen, FeatureSpec}
import section8.Section8._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.duration.DurationInt

class Section11Test extends FunSuite with Matchers {

  test("wordsWithoutEmptyString") {
    Section11.wordsWithoutEmptyString should have size 292
  }

  test("dictionary") {
    Section11.dictionary should contain key 'e'
    Section11.dictionary('e') should contain ("elegant")
    Section11.dictionary should contain key 'j'
    Section11.dictionary('j') should contain ("Java")
  }


}
