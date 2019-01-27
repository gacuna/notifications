package utils

import models.Notification
import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax._

object JsonFormats {

  implicit val notificationReads: Reads[Notification] = (
    (JsPath \ "from").read[String] and
      (JsPath \ "to").read[String] and
      (JsPath \ "body").read[String]
    )(Notification.apply _)

  implicit val notificationWrites: Writes[Notification] = (
    (JsPath \ "from").write[String] and
      (JsPath \ "to").write[String] and
      (JsPath \ "body").write[String]
    )(Notification.unapply(_).get)

}
