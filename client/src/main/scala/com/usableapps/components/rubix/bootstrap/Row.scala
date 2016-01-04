package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react._

import scala.scalajs.js

/**
 * Created by uenyioha on 11/28/15.
 */
object Row {
  case class Props(`class`: Option[String] = None)

  val component = ReactComponentB[Props]("row")
    .stateless
    .render( $ => {

      <.div(
        ^.classSet1("row",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }
    )
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}
