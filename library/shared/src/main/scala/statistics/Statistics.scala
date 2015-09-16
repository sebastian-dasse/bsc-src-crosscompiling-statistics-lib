package statistics

import scala.language.implicitConversions

object Statistics {
  implicit def is2ds(is: Seq[Int]): Seq[Double] = is.map(_.toDouble)

  def mean(seq: Seq[Double]): Double = {
    require(seq.length > 0)
    seq.sum / seq.length
  }

  def median(seq: Seq[Double]): Double = {
    require(seq.length > 0)
    val srtd = seq.sorted
    val lenHalf = srtd.length / 2
    srtd.length % 2 match {
      case 1 => srtd( lenHalf )
      case 0 => ( srtd( lenHalf ) + srtd( lenHalf - 1 ) ) / 2
    }
  }

  def variance(seq: Seq[Double]): Double = {
    require(seq.length > 0)
    val mn = mean(seq)
    def sqr(x: Double) = x * x
    seq.map(x => sqr(x - mn)).sum / seq.length
  }

  def deviation(seq: Seq[Double]): Double = math.sqrt(variance(seq))

  // TODO
//  def quartile(seq: Seq[Double]): Double = ???
}
