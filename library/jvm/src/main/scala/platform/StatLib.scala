package platform

import statistics.{Statistics => stat}


object StatLib {
  def mean(seq: Seq[Double]): Double = stat.mean(seq)
  def median(seq: Seq[Double]): Double = stat.median(seq)
  def variance(seq: Seq[Double]): Double = stat.variance(seq)
  def deviation(seq: Seq[Double]): Double = stat.deviation(seq)
}
