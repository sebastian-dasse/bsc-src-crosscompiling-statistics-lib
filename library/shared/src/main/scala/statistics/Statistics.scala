package statistics

object Statistics {

  private val errMsg = "empty list"

  def mean(seq: Seq[Double]): Double = {
    require(seq.length > 0, errMsg)
    seq.sum / seq.length
  }

  def median(seq: Seq[Double]): Double = {
    require(seq.length > 0, errMsg)
    val srtd = seq.sorted
    val lenHalf = srtd.length / 2
    srtd.length % 2 match {
      case 1 => srtd( lenHalf )
      case 0 => ( srtd( lenHalf ) + srtd( lenHalf - 1 ) ) / 2
    }
  }

  def variance(seq: Seq[Double]): Double = {
    require(seq.length > 0, errMsg)
    val mn = mean(seq)
    def sqr(x: Double) = x * x
    seq.map(x => sqr(x - mn)).sum / seq.length
  }

  def deviation(seq: Seq[Double]): Double = math.sqrt(variance(seq))

  // TODO
//  def quartile(seq: Seq[Double]): Double = ???
}
