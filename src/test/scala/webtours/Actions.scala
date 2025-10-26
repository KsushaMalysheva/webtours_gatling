package webtours

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {

  val GetHomePage = http("HOME_PAGE")
    .get("/webtours/")
    .resources(
      http("request_1")
        .get("/webtours/header.html"),
       http("request_4")
        .get("/cgi-bin/welcome.pl?signOff=true"),
      http("request_5")
        .get("/WebTours/home.html"),
      http("request_6")
        .get("/cgi-bin/nav.pl?in=home")
        .check(status is 200))

  val PostAuthorization = http("AUTHORIZATION_USER")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "139159.716889429HVfiAcHpQDHftcQtipVzHzcf")
    .formParam("username", "gatlingtestuser")
    .formParam("password", "gatlingtestuser")
    .formParam("login.x", "49")
    .formParam("login.y", "9")
    .formParam("JSFormSubmit", "off")
    .resources(
      http("request_9")
        .get("/cgi-bin/nav.pl?page=menu&in=home"),
      http("request_13")
        .get("/cgi-bin/login.pl?intro=true")
        .check(status is 200))

val GetSerchFlights = http("SEARCH_FLIGHTS")
  .get("/cgi-bin/welcome.pl?page=search")
  .resources(
    http("request_16")
      .get("/cgi-bin/nav.pl?page=menu&in=flights"),
    http("request_21")
      .get("/cgi-bin/reservations.pl?page=welcome")
      .check(status is 200))

  val PostSelectFlight1 = http("SELECT_FLIGHT_1")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "London")
    .formParam("departDate", "06/11/2025")
    .formParam("arrive", "Los Angeles")
    .formParam("returnDate", "06/12/2025")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "Window")
    .formParam("seatType", "Business")
    .formParam("findFlights.x", "30")
    .formParam("findFlights.y", "6")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(status is 200)

  val PostSelectFlight2 =  http("SELECT_FLIGHT_2")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "230;1121;06/11/2025")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Business")
    .formParam("seatPref", "Window")
    .formParam("reserveFlights.x", "43")
    .formParam("reserveFlights.y", "5")
    .check(status is 200)

  val Data =  http("DATA")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "gatlingtestuser")
    .formParam("lastName", "gatlingtestuser")
    .formParam("address1", "street test")
    .formParam("address2", "city test")
    .formParam("pass1", "gatlingtestuser gatlingtestuser")
    .formParam("creditCard", "555555555")
    .formParam("expDate", "111")
    .formParam("saveCC", "on")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Business")
    .formParam("seatPref", "Window")
    .formParam("outboundFlight", "230;1121;06/10/2025")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "49")
    .formParam("buyFlights.y", "10")
    .formParam(".cgifields", "saveCC")
    .check(status is 200)

  val GetFlights = http("FLIGHTS")
    .get("/cgi-bin/welcome.pl?page=itinerary")
    .resources(
      http("request_29")
        .get("/cgi-bin/nav.pl?page=menu&in=itinerary"),
      http("request_34")
        .get("/cgi-bin/itinerary.pl")
        .check(status is 200))

  val GetUnAuthorization = http("UNAUTHORIZATION")
    .get("/cgi-bin/welcome.pl?signOff=1")
    .resources(
      http("request_38")
        .get("/WebTours/home.html"),
      http("request_39")
        .get("/cgi-bin/nav.pl?in=home")
        .check(status is 200))


}
