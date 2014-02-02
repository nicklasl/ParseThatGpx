package model

import org.joda.time.DateTime
import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-29
 * Time: 20:55
 */
case class Track(name: String, time: DateTime, segments: List[Segment])

object Track {
  implicit val writes = Json.writes[Track]
}