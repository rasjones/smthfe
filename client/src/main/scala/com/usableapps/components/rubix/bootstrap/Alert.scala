package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/9/15.
  */
object Alert {

  case class Props(`class`: Option[String] = None, dismissible: Boolean = false,
                   onDismiss: Option[(ReactEvent) => Callback], collapseBottom: Option[Int] = None,
                   info: Boolean = false, danger: Boolean = false,
                   success : Boolean = false, warning : Boolean = false)

  case class State(hidden: Boolean)

  class Backend($: BackendScope[Props, State]) {

    def resetState = $.modState(s => s.copy(hidden = true))

    def render(p: Props, s: State, propsChildren: PropsChildren) = {

      val alertClasses = ^.classSet1( p.`class`.getOrElse(""),
        "alert-info" -> p.info,
        "alert-danger" -> p.danger,
        "alert-success" -> p.success,
        "alert-warning" -> p.warning
      )

      <.div(
        ^.role := "alert",
        alertClasses + ^.classSet("hidden" -> s.hidden),
        ^.marginBottom := p.collapseBottom,
        if (p.dismissible)
          <.div(
            Button(
              close = true,
              onClick = Some((e: ReactEvent) => resetState thenRun p.onDismiss.orNull)
            )()
          )
        else
          propsChildren
      )
    }
  }

  val component = ReactComponentB[Props]("Alert")
    .initialState(State(false))
    .renderBackend[Backend]
    .build

  def apply(`class`: Option[String] = None, dismissible: Boolean = false,
            onDismiss: Option[(ReactEvent) => Callback] = None, collapseBottom: Option[Int] = None,
            info: Boolean = false, danger: Boolean = false,
            success : Boolean = false, warning : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, dismissible,
                   onDismiss, collapseBottom, info, danger, success, warning), children : _*)

}

object AlertLink {

  case class Props(`class` : Option[String] = None, href : Option[String] = None)

  val component = ReactComponentB[Props]("alert-link")
    .stateless
    .render { $ =>
      <.a(
        ^.href := $.props.href.getOrElse("#"),
        ^.classSet1("alert-link",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        $.propsChildren
      )
    }
  .build

  def apply(`class` : Option[String] = None, href : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, href), children : _*)

}