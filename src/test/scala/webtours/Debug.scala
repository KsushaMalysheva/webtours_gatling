package webtours

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class Debug extends Simulation {

  setUp(MyComputerTestScenario().inject(atOnceUsers(1))).protocols(httpProtocol)

}
