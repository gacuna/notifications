package controllers


import javax.inject.{Inject, Singleton}
import models.Notification
import play.api.libs.json.JsValue
import play.api.mvc._
import play.api.libs.json._
import utils.JsonFormats.{notificationReads, notificationWrites}

@Singleton
class NotificationController @Inject()(cc: ControllerComponents)  extends AbstractController(cc) {

  def send() = Action(parse.json) { request: Request[JsValue]  =>
    val json = request.body.validate[Notification]
    json.fold(errors => {
      BadRequest(JsError.toJson(errors))
    }, notification => {
      //TODO Escribir en una cola de mensajes o en kafka... que decida Paoletta jaja
      Ok(Json.toJson("OK"))
    })
  }

}
