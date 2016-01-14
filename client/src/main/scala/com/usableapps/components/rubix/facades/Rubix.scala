package com.usableapps.components.rubix.facades

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * Created by uenyioha on 1/4/16.
 */
@js.native
class Rubix(selector: String, params : Any) extends js.Object {
  def column_series(data: Any) : Rubix = js.native
  def line_series(data: Any) : Rubix = js.native
  def area_series(data: Any) : Rubix = js.native
  var extent : js.Array[Double] = js.native
  def addData(data: Any) : Unit = js.native
}