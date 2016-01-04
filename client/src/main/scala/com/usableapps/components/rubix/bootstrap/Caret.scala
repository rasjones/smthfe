package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 11/30/15.
  */
object Caret {
  case class Props(`class`: Option[String] = None)

  val component = ReactComponentB[Props]("caret")
    .stateless
    .render { $ =>
      <.span(
        ^.classSet1("caret",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        )
      )
    }
  .build


  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})=
    component.set(key, ref)(Props(`class`))

}
