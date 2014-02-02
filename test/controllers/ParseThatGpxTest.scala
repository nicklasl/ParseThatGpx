package controllers

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.Play
import play.api.Play.current
import java.io.File
import play.api.test.WithApplication
import model.Gpx
import play.api.libs.json.{JsValue, Json}

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-28
 * Time: 21:33
 */
@RunWith(classOf[JUnitRunner])
class ParseThatGpxTest extends Specification {

  def loadFile: File = {
    val dir: Option[File] = Play.getExistingFile("samples")
    val file = dir.get.listFiles().filter(f => f.getAbsolutePath.endsWith(".gpx")).head
    println("Testing with ", file.getAbsolutePath)
    file
  }

  "ParseThatGpx" should {
    val parser = new ParseThatGpx

    "Test API" in new WithApplication {

      val file = loadFile
      private val gpx: Gpx = parser.parse(file)
      gpx.version must beEqualTo("1.1")
      gpx.track.name must beEqualTo("Cross-Country Skiing 2/13/11 10:26 am")
      gpx.track.segments.size must beEqualTo(2)
      gpx.track.segments.head.points.size must beEqualTo(236)
      gpx.track.segments.tail.head.points.size must beEqualTo(233)
    }

    "Test json" in new WithApplication {
      val file = loadFile
      private val gpx: Gpx = parser.parse(file)
      val json = Json.toJson(gpx)
      json must beAnInstanceOf[JsValue]
    }
  }

}
