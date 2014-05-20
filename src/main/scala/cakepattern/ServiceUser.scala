package cakepattern

class ServiceUser {
  this: AAServiceComponent with BBServiceComponent =>

  def someUsage = {
    aaService.callService("lala")
    bbService.callService("huhu")
  }
}
