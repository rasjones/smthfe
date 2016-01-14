package com.usableapps.components.rubix.facades

import org.querki.jquery.JQuery
import org.scalajs.dom.raw.HTMLElement

import scala.language.implicitConversions
import scala.scalajs.js

/**
 * Created by uenyioha on 1/4/16.
 */
@js.native
trait JQueryExtraFunctions extends JQuery {
  def perfectScrollbar(`object`: js.Any) : HTMLElement = js.native
  def animate(properties: js.Any, duration: js.Any = {}, easing: String = "", complete: js.Function = ???): JQuery = js.native
}

object JQueryXtras {
  implicit def newFxns (jq: JQuery) : JQueryExtraFunctions  = jq.asInstanceOf[JQueryExtraFunctions]
}
