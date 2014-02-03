package nu.nldv.parsethatgpx.model

import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-29
 * Time: 20:57
 */
case class Segment(points: List[Point])

object Segment {
  implicit val writes = Json.writes[Segment]
}
