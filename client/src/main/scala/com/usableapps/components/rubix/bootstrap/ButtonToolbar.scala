package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/10/15.
  */
object ButtonToolbar {

  case class Props(`class`: Option[String])

  val component = ReactComponentB[Props]("ButtonToolbar")
    .stateless
    .render { $ =>
      <.div(
        ^.role := "toolbar",
        ^.classSet1("btn-toolbar",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        $.propsChildren
      )
    }.build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`))

}
