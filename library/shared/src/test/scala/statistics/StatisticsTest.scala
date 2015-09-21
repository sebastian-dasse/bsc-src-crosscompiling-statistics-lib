package statistics

import statistics.Statistics._
import utest._

object StatisticsTest extends TestSuite {

  def dblSeq(r: Range): Seq[Double] = r.map(_.toDouble)

  def assertNear(exp: Double, act: Double, delta: Double = 1e-5) =
    assert(math.abs(exp - act) < delta)

  val tests = TestSuite {
    "mean test" - {
      intercept[IllegalArgumentException](mean(Nil))
      assert(mean(Seq[Double](0.0)) == 0.0)
      assert(mean(Seq[Double](1.0, 2.0)) == 1.5)
      assert(mean(dblSeq(1 to 100)) == 50.5)
      assertNear( mean( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 190.918516)
    }

    "median test" - {
      intercept[IllegalArgumentException](median(Nil))
      assert(median(Seq[Double](123.0)) == 123.0)
      assert(median(Seq[Double](1.0, 2.0)) == 1.5)
      assert(median(Seq[Double](1.0, 3.0, 2.0)) == 2.0)
      assert(median(dblSeq(1 to 100)) == 50.5)
      assert( median( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ) == 38.2 )
    }

    "variance test" - {
      intercept[IllegalArgumentException](variance(Nil))
      assert(variance(Seq[Double](123.0)) == 0.0)
      assert(variance(Seq[Double](1.0, 2.0)) == 0.25)
      assert(variance(Seq[Double](9.0, 29.0)) == 100.0)
      assert(variance(Seq[Double](3.0, 9.0, 12.0)) == 14.0)
      assert(variance(dblSeq(1 to 100)) == 833.25)
      assertNear( variance( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 131446.692564 )
    }

    "deviation test" - {
      intercept[IllegalArgumentException](deviation(Nil))
      assert(deviation(Seq[Double](123.0)) == 0.0)
      assert(deviation(Seq[Double](1.0, 2.0)) == 0.5)
      assert( deviation( Seq[Double](9.0, 29.0) ) == 10.0 )
      assert( deviation( Seq[Double](3.0, 9.0, 12.0) ) == math.sqrt(14.0) )
      assert( deviation( dblSeq(1 to 100) ) == math.sqrt(833.25) )
      assertNear( deviation( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 362.555779 )
    }
  }
}
