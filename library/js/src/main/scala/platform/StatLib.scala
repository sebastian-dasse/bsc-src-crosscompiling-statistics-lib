package platform

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

import statistics.{Statistics => stat}


@JSExport
object StatLib {
  @JSExport def mean(seq: js.Array[Double]): Double = stat.mean(seq)
  @JSExport def median(seq: js.Array[Double]): Double = stat.median(seq)
  @JSExport def variance(seq: js.Array[Double]): Double = stat.variance(seq)
  @JSExport def deviation(seq: js.Array[Double]): Double = stat.deviation(seq)
}
