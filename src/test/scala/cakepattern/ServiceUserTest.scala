package cakepattern

import org.scalatest.FunSuite

trait MockedEnvironment
  extends AAServiceComponent
  with BBServiceComponent {

  var lastAACall: String = ""
  var lastBBCall: String = ""

  val aaService: AAService = new AAService {
    def callService(x: String): Unit = {
      lastAACall = x
    }
  }

  val bbService: BBService = new BBService {
    def callService(y: String): Unit = {
      lastBBCall = y
    }
  }
}

class ServiceUserTest extends FunSuite {
  test("A ServiceUser instance calls an AA service") {
    val serviceUser = new ServiceUser with MockedEnvironment

    serviceUser.someUsage
    assert("lala" == serviceUser.lastAACall)
  }

  test("A ServiceUser instance calls an BB service") {
    val serviceUser = new ServiceUser with MockedEnvironment

    serviceUser.someUsage
    assert("huhu" == serviceUser.lastBBCall)
  }
}
