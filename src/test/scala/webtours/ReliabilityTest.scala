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
    .assertions(
      global.responseTime.max.lt(1000), // Максимальное время ответа < 1 секунды
      global.successfulRequests.percent.gt(99.0), // Успешных запросов > 99%
      global.responseTime.mean.lt(300), // Среднее время ответа < 300 мс
      global.responseTime.percentile3.lt(800) // 95-й перцентиль < 800 мс
    )
}
