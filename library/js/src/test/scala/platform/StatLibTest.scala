package platform

import scala.scalajs.js
import js.JSConverters._
import utest._

import StatLib.{mean, median, variance, deviation}


object StatLibTest extends TestSuite {

  def dblJSArray(r: Range): js.Array[Double] = r.map(_.toDouble).toJSArray

  def assertNear(exp: Double, act: Double, delta: Double = 1e-5) =
    assert(math.abs(exp - act) < delta)

  val tests = TestSuite {
    "JavaScript platform" - {
      "mean test" - {
        intercept[IllegalArgumentException](mean(js.Array[Double]()))
        assert(mean(js.Array[Double](0.0)) == 0.0)
        assert(mean(js.Array[Double](1.0, 2.0)) == 1.5)
        assert(mean(dblJSArray(1 to 100)) == 50.5)
        assertNear( mean( js.Array[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 190.918516 )
      }

      "median test" - {
        intercept[IllegalArgumentException](median(js.Array[Double]()))
        assert(median(js.Array[Double](123.0)) == 123.0)
        assert(median(js.Array[Double](1.0, 2.0)) == 1.5)
        assert(median(js.Array[Double](1.0, 3.0, 2.0)) == 2.0)
        assert(median(dblJSArray(1 to 100)) == 50.5)
        assert( median( js.Array[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ) == 38.2 )
      }

      "variance test" - {
        intercept[IllegalArgumentException](variance(js.Array[Double]()))
        assert(variance(js.Array[Double](123.0)) == 0.0)
        assert(variance(js.Array[Double](1.0, 2.0)) == 0.25)
        assert(variance(js.Array[Double](9.0, 29.0)) == 100.0)
        assert(variance(js.Array[Double](3.0, 9.0, 12.0)) == 14.0)
        assert(variance(dblJSArray(1 to 100)) == 833.25)
        assertNear( variance( js.Array[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 131446.692564 )
      }

      "deviation test" - {
        intercept[IllegalArgumentException](deviation(js.Array[Double]()))
        assert(deviation(js.Array[Double](123.0)) == 0.0)
        assert(deviation(js.Array[Double](1.0, 2.0)) == 0.5)
        assert(deviation(js.Array[Double](9.0, 29.0)) == 10.0 )
        assert(deviation(js.Array[Double](3.0, 9.0, 12.0)) == math.sqrt(14.0))
        assert(deviation(dblJSArray(1 to 100)) == math.sqrt(833.25))
        assertNear( deviation( js.Array[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 362.555779 )
      }
    }
  }
}
