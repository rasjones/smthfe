package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react._

import scala.scalajs.js

/**
 * Created by uenyioha on 11/28/15.
 */

object Grid {

  case class Props(`class`: Option[String] = None, id: Option[String] = None,
                   styles: Option[Seq[String]] = None, fixed: Boolean = false,
                   gutter: Boolean = false, collapse: Boolean = false,
                   gutterTop : Boolean = false, gutterBottom: Boolean = false, gutterLeft: Boolean = false,
                   gutterRight : Boolean = false)

  class Backend($: BackendScope[Props, Int]) {

    def render(props: Props, state: Int, children: PropsChildren) = {

      <.div(
        ^.id := props.id,
        ^.key := 1,
        ^.classSet1( "rubix-grid",
          props.`class`.getOrElse("") -> props.`class`.isDefined,
          "container" -> props.fixed,
          "container-fluid" -> !props.fixed,
          "grid-gutter" -> props.gutter,
          "grid-collapse" -> props.collapse,
          "grid-gutter-top" -> props.gutterTop,
          "grid-gutter-bottom" -> props.gutterBottom,
          "grid-gutter-left" -> props.gutterLeft,
          "grid-gutter-right" -> props.gutterRight
        ),
        ^.zIndex := state,
        children
      )
    }
  }

  val component = ReactComponentB[Props]("Grid")
    .initialState(decreaseZIndex())
    .renderBackend[Backend]
    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None,
            styles: Option[Seq[String]] = None, fixed: Boolean = false,
            gutter: Boolean = false, collapse: Boolean = false,
            gutterTop : Boolean = false, gutterBottom: Boolean = false, gutterLeft: Boolean = false,
            gutterRight : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id, styles, fixed, gutter, collapse, gutterTop,
                    gutterBottom, gutterLeft, gutterRight), children : _*)
}
