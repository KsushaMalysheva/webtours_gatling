package webtours
import io.gatling.core.Predef.{constantUsersPerSec, rampUsers, _}
import io.gatling.http.Predef.{http, _}

import scala.concurrent.duration.DurationInt
class ReliabilityTest extends Simulation {

  setUp(
    MyComputerTestScenario().inject(
      rampUsers(40) during (10.minutes), // Плавный выход на 40 пользователей за 10 минут
      constantUsersPerSec(40) during (60.minutes) // Удержание 40 пользователей в течение 60 минут
    )
  ).protocols(httpProtocol)
}
