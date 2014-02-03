package nu.nldv.parsethatgpx.model

import org.joda.time.DateTime
import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-29
 * Time: 20:58
 */
case class Point(latitude: Double, longitude: Double, elevation: Double, time: DateTime)

object Point {
  implicit val writes = Json.writes[Point]
}