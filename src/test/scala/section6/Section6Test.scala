package section6

import org.scalatest.{Matchers, FunSuite}
import scala.util.{Failure, Success}
import java.net.URL
import java.io.ByteArrayOutputStream

class Section6Test extends FunSuite with Matchers {

  test("parseURL can parse a regular URL") {
    Section6.parseURL("http://en.wikipedia.org/") shouldBe a [Success[_]]
  }

  test("parseURL cannot parse a malformed URL") {
    Section6.parseURL("htp://en.wikipedia.org/") shouldBe a [Failure[_]]
  }

  test("defaultSearchEngine should use duckduckgo as default") {
    val duckduckgo = new URL("http://duckduckgo.com")
    Section6.defaultSearchEngine("garbage") shouldEqual duckduckgo
  }

  test("getProtocol should read a valid url") {
    Section6.getProtocol("http://en.wikipedia.org/") shouldEqual Success("http")
  }

  test("getProtocol should handle invalid url") {
    Section6.getProtocol("htp://en.wikipedia.org/") shouldBe a [Failure[_]]
  }

  test("readURLContent should output the error") {
    val output = new ByteArrayOutputStream
    Section6.readURLContent("garbage", output)
    output.toString shouldEqual "Problem rendering URL content: no protocol: garbage"
  }

  test("getURLContentWithErrorMessage should report invalid URL") {
    val result = Section6.getURLContentWithErrorMessage("garbage")
    result shouldBe a [Success[_]]
    result.get.next() shouldEqual "Please make sure to enter a valid URL"
  }

  test("getURLContentWithErrorMessage should report non existing page") {
    val result = Section6.getURLContentWithErrorMessage("http://en.wikipedia.org/blabla")
    result shouldBe a [Success[_]]
    result.get.next() shouldEqual "Requested page does not exist"
  }

  test("getURLContentWithErrorMessage should fetch website content") {
    val result = Section6.getURLContent("http://en.wikipedia.org/wiki/Scala_(programming_language)")
    result shouldBe a [Success[_]]
    result.get.next() shouldEqual "<!DOCTYPE html>"
  }

}
