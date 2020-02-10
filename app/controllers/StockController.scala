package controllers

import java.util.concurrent.TimeUnit

import `do`.CommandDO
import akka.actor.ActorSystem
import akka.stream.Materializer
import akka.stream.scaladsl.{Flow, Sink, Source}
import com.google.gson.Gson
import com.google.inject.{Inject, Singleton}
import env.Environment
import play.api.Configuration
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{AbstractController, Action, AnyContent, BaseController, ControllerComponents, Request, WebSocket}
import services.api.StockService
import store.StockNameData

import scala.concurrent.duration.FiniteDuration
import scala.jdk.CollectionConverters

@Singleton
class StockController @Inject()(config: Configuration, stockService: StockService, gson: Gson, cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {

  // Home page that renders template
  def index: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def socket: WebSocket = WebSocket.accept[JsValue, JsValue] { request =>
    val dataStore = new StockNameData
    val delay: Long = config.get[Long](Environment.delay)
    val finiteDuration = new FiniteDuration(delay, TimeUnit.SECONDS)
    val in = Sink.foreach[JsValue](json => {
      println("Input " + json)
      val commandDO = gson.fromJson(Json.stringify(json), classOf[CommandDO])
      dataStore.followCommand(commandDO)
    })
    val out = Source.tick(finiteDuration, finiteDuration, "tick")
      .map(str => {
        val stocks = stockService.getStocks(dataStore.getNames)
        val json = gson.toJson(CollectionConverters.MapHasAsJava(stocks).asJava)
        Json.parse(json)
      })

    Flow.fromSinkAndSourceCoupled(in, out)
  }

}
