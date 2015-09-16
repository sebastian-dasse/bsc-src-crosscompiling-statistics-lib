package statistics

import statistics.Statistics._
import utest._

object StatisticsTest extends TestSuite {

  def intSeq(r: Range): Seq[Int] = r

  def dblSeq(r: Range): Seq[Double] = r

  def assertNear(exp: Double, act: Double, delta: Double = 1e-5) =
    assert(math.abs(exp - act) < delta)

  val tests = TestSuite {
    "mean test" - {
      intercept[IllegalArgumentException](mean(Nil))

      assert(mean(Seq[Int]   (0  )) == 0.0)
      assert(mean(Seq[Double](0.0)) == 0.0)

      assert(mean(Seq[Int]   (1  , 2  )) == 1.5)
      assert(mean(Seq[Double](1.0, 2.0)) == 1.5)

      assert(mean(intSeq(1 to 100)) == 50.5)
      assert(mean(dblSeq(1 to 100)) == 50.5)

      assert( mean( Seq[Int](2, 4711, 123, 65536, 29, 1000) ) == 71401 / 6.0)
      assertNear( mean( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 190.918516)
    }

    "median test" - {
      intercept[IllegalArgumentException](median(Nil))

      assert(median(Seq[Int]   (123  )) == 123.0)
      assert(median(Seq[Double](123.0)) == 123.0)

      assert(median(Seq[Int]   (1  , 2  )) == 1.5)
      assert(median(Seq[Double](1.0, 2.0)) == 1.5)

      assert(median(Seq[Int]   (1  , 3  , 2  )) == 2.0)
      assert(median(Seq[Double](1.0, 3.0, 2.0)) == 2.0)

      assert(median(intSeq(1 to 100)) == 50.5)
      assert(median(dblSeq(1 to 100)) == 50.5)

      assert( median( Seq[Int](2, 4711, 123, 65536, 29, 1000) ) == 561.5)
      assert( median( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ) == 38.2 )
    }

    "variance test" - {
      intercept[IllegalArgumentException](variance(Nil))

      assert(variance(Seq[Int]   (123  )) == 0.0)
      assert(variance(Seq[Double](123.0)) == 0.0)

      assert(variance(Seq[Int]   (1  , 2  )) == 0.25)
      assert(variance(Seq[Double](1.0, 2.0)) == 0.25)

      assert(variance(Seq[Int]   (9  , 29  )) == 100.0)
      assert(variance(Seq[Double](9.0, 29.0)) == 100.0)

      assert(variance(Seq[Int]   (3  ,   9, 12  )) == 14.0)
      assert(variance(Seq[Double](3.0, 9.0, 12.0)) == 14.0)

      assert(variance(intSeq(1 to 100)) == 833.25)
      assert(variance(dblSeq(1 to 100)) == 833.25)

      assert( variance( Seq[Int](2, 4711, 123, 65536, 29, 1000) ) == 578082165.138889)
      assertNear( variance( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 131446.692564 )
    }

    "deviation test" - {
      intercept[IllegalArgumentException](deviation(Nil))

      assert(deviation(Seq[Int]   (123  )) == 0.0)
      assert(deviation(Seq[Double](123.0)) == 0.0)

      assert(deviation(Seq[Int]   (1  , 2  )) == 0.5)
      assert(deviation(Seq[Double](1.0, 2.0)) == 0.5)

      assert( deviation( Seq[Int]   (9  , 29  ) ) == 10.0 )
      assert( deviation( Seq[Double](9.0, 29.0) ) == 10.0 )

      assert( deviation( Seq[Int]   (3  , 9  , 12  ) ) == math.sqrt(14.0) )
      assert( deviation( Seq[Double](3.0, 9.0, 12.0) ) == math.sqrt(14.0) )

      assert( deviation( intSeq(1 to 100) ) == math.sqrt(833.25) )
      assert( deviation( dblSeq(1 to 100) ) == math.sqrt(833.25) )

      assert( deviation( Seq[Int]   (2, 4711, 123, 65536, 29, 1000) ) == 24043.339309232586)
      assertNear( deviation( Seq[Double](2.345, 47.11, 1.23, 65.536, 29.29, 1000.0001) ), 362.555779 )
    }
  }
}
