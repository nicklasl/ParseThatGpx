package model

import org.joda.time.DateTime

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-29
 * Time: 20:55
 */
case class Track(name: String, time: DateTime, segments: List[Segment])
