package nu.nldv.parsethatgpx.model

import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-28
 * Time: 21:44
 */
case class Gpx(version: String, creator: String, track: Track)

object Gpx {
  implicit val writes = Json.writes[Gpx]
}
