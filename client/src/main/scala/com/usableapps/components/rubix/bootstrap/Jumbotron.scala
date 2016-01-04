package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 12/6/15.
  */
object Jumbotron {

  case class Props(`class`: Option[String] = None)

  val component = ReactComponentB[Props]("jumbotron")
    .stateless
    .render{ $ =>

      <.div(
        ^.classSet1("jumbotron",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`: Option[String]), children : _*)
}
