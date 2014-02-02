package nu.nldv.parsethatgpx.controllers

import java.io.File
import scala.xml.{Node, NodeSeq, XML}
import model.{Point, Segment, Track, Gpx}
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-28
 * Time: 21:27
 */
object ParseThatGpx {

  private val pattern = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")

  private def point(node: Node): Point = Point((node \ "@lat").text.toDouble, (node \ "@lon").text.toDouble, (node \\ "ele").text.toDouble, dateTime(node \\ "time"))

  private def dateTime(node: NodeSeq): DateTime = {
    DateTime.parse(node.text, pattern)
  }

  private def points(nodes: NodeSeq): List[Point] = nodes.map {
    node =>
      point(node)
  }.toList

  private def segments(nodes: NodeSeq): List[Segment] = nodes.map {
    node =>
      Segment(points(node \\ "trkpt"))
  }.toList

  private def track(node: NodeSeq): Track = Track((node \ "name").text, dateTime(node \ "time"), segments(node \\ "trkseg"))

  def parse(xml: scala.xml.Elem): Gpx = Gpx((xml \ "@version").text, (xml \ "@creator").text, track(xml \\ "trk"))

  def parse(file: File): Gpx = parse(XML.loadFile(file))

}
