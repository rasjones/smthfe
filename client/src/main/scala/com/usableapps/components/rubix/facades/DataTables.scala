package com.usableapps.components.rubix.facades

import org.querki.jquery.JQuery
import org.scalajs.dom.raw.HTMLElement

import scala.language.implicitConversions
import scala.scalajs.js

/**
 * Created by uenyioha on 1/5/16.
 */
@js.native
trait JQueryDataTablesExtensions extends JQuery {
  def dataTable(params: Any) : JQuery = js.native
}

object DataTablesQueryXtras {
  implicit def newFxns (jq: JQuery) : JQueryDataTablesExtensions  = jq.asInstanceOf[JQueryDataTablesExtensions]
}
