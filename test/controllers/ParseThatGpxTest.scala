package controllers

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.Play
import java.io.File
import play.api.test.WithApplication
import model.Gpx

/**
 * Created with IntelliJ IDEA.
 * User: nicklas
 * Date: 2014-01-28
 * Time: 21:33
 */
@RunWith(classOf[JUnitRunner])
class ParseThatGpxTest extends Specification {

  "ParseThatGpx" should {
    val parser = new ParseThatGpx

    "Test API" in new WithApplication {
      val dir: Option[File] = Play.getExistingFile("samples")
      val file = dir.get.listFiles().filter(f => f.getAbsolutePath.endsWith(".gpx")).head
      println("Testing with ", file.getAbsolutePath)
      private val gpx: Gpx = parser.parse(file)
      gpx.version must beEqualTo("1.1")
      gpx.track.name must beEqualTo("Cross-Country Skiing 2/13/11 10:26 am")
      gpx.track.segments.size must beEqualTo(2)
      gpx.track.segments.head.points.size must beEqualTo(236)
      gpx.track.segments.tail.head.points.size must beEqualTo(233)
    }

  }

}
