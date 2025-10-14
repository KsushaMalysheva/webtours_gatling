package webtours

import io.gatling.core.Predef._
import io.gatling.core.Predef.{exec, scenario}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import io.gatling.core.controller.inject.open.OpenInjectionStep
import io.gatling.core.structure.ScenarioBuilder
import webtours.Feeders.MyFeed



object MyComputerTestScenario {
  def apply(): ScenarioBuilder = new MyComputerTestScenario().scn
 }

class MyComputerTestScenario {

    val scn: ScenarioBuilder = scenario("MyComputerTest")
      .feed(MyFeed)
    .exec(Actions.GetHomePage)
    .exec(Actions.PostAuthorization)
    .randomSwitch(
    30.0 -> exec(Actions.GetSerchFlights),
    10.0 -> exec(Actions.PostSelectFlight1),
    10.0 -> exec(Actions.PostSelectFlight2),
    10.0 -> exec(Actions.Data),
    10.0 -> exec(Actions.GetFlights),
    30.0 -> exec(Actions.GetUnAuthorization)
  )

}
