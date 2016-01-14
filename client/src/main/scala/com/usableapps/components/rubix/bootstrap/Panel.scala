package com.usableapps.components.rubix.bootstrap


import scala.scalajs._
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react._
import org.scalajs.dom.html.Div

import scala.scalajs.js

/**
 * Created by uenyioha on 11/28/15.
 */

object PanelRight {

  case class Props(`class` : Option[String] = None, noRadius : Boolean = false)

  val component = ReactComponentB[Props]("panel-right")
    .stateless
    .render { $ =>

      <.div(
        ^.classSet1("rubix-panel-right",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "noRadius" -> $.props.noRadius
        ),
        $.propsChildren
      )

    }.build

  def apply(`class` : Option[String] = None, noRadius : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, noRadius), children: _*)

}

object PanelLeft {

  case class Props(`class` : Option[String] = None, noRadius : Boolean = false)

  val component = ReactComponentB[Props]("panel-left")
    .stateless
    .render { $ =>

      <.div(
        ^.classSet1("rubix-panel-left",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "noRadius" -> $.props.noRadius
        ),
        $.propsChildren
      )

    }.build

  def apply(`class` : Option[String] = None, noRadius : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, noRadius), children: _*)
}

object PanelFooter {

  case class Props(`class` : Option[String] = None, noRadius : Boolean = false)

  val component = ReactComponentB[Props]("panel-footer")
    .stateless
    .render { $ =>

      <.div(
        ^.classSet1("rubix-panel-footer",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "noRadius" -> $.props.noRadius
        ),
        $.propsChildren
      )

    }.build

  def apply(`class` : Option[String] = None, noRadius : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, noRadius), children: _*)

}

object PanelHeader {

  case class Props(`class` : Option[String] = None, noRadius : Boolean = false)

  val component = ReactComponentB[Props]("panel-header")
    .stateless
    .render { $ =>

      <.div(
        ^.classSet1("rubix-panel-header",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "noRadius" -> $.props.noRadius
        ),
        $.propsChildren
      )

    }.build

  def apply(`class` : Option[String] = None, noRadius : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, noRadius), children: _*)

}


object PanelBody {

  case class Props(`class` : Option[String] = None, noRadius : Boolean = false, paddingTop : Option[Int] = None,
                   pading : Option[Int] = None)

  val component = ReactComponentB[Props]("panel-body")
    .stateless
    .render { $ =>
      <.div(
        ^.classSet1("rubix-panel-body",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "noRadius" -> $.props.noRadius
        ),
        ^.paddingTop := $.props.paddingTop,
        ^.padding := $.props.pading,
        $.propsChildren
      )

    }.build

  def apply(`class` : Option[String] = None, noRadius : Boolean = false, paddingTop : Option[Int] = None,
            padding : Option[Int] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, noRadius, paddingTop, padding), children: _*)

}

object Panel {

  case class Props(`class` : Option[String] = None, horizontal : Boolean = false)

  val component = ReactComponentB[Props]("panel")
    .stateless
    .render { $ =>

      <.div(
        ^.classSet1("rubix-panel",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "horizontal" -> $.props.horizontal
        ),
        <.div(
          $.propsChildren
        )
      )

    }.build

  def apply(`class` : Option[String] = None, horizontal : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, horizontal), children: _*)
}

object PanelContainer {

  case class State(collapsed: Boolean = false, removed: Boolean = false, zIndex: Int)

  case class Props(`class`: Option[String] = None, bordered : Boolean = false,
                   noOverflow : Boolean = false, gutterBottom : Boolean = false, plain: Boolean = false,
                   collapseBottom: Boolean = false, containerClasses: Option[String] = None,
                   isHorizontal: Boolean = false, controlStyles : Option[String] = None,
                   customControls : Seq[ReactElement] = Seq())

  case class Backend($: BackendScope[Props, State]) {

    def render(props: Props, state: State, children: PropsChildren) =  {

      def togglePanel(state: State)(e: ReactEvent) = {
        e.preventDefaultCB >>
        $.modState(s => s.copy(collapsed = !s.collapsed))
      }

      def removePanel(state: State)(e: ReactEvent) = {
        e.preventDefaultCB >>
        $.modState(s => s.copy(removed = true))
      }

      val controlClassSet = ^.classSet1("rubix-panel-controls",
        props.controlStyles.getOrElse("") -> props.controlStyles.isDefined
      )

      val containerClassSet = ^.classSet1("rubix-panel-container",
        "bordered" -> props.bordered,
        "noOverflow" -> props.noOverflow,
        "panel-plain" -> props.plain,
        "panel-gutter-bottom" -> props.gutterBottom,
        "panel-collapse-bottom" -> props.collapseBottom,
        props.containerClasses.getOrElse("") -> props.containerClasses.isDefined
      )

      val noControls = props.plain

      val ctl = if (!noControls)
        <.div(
          controlClassSet,
          Button()(
            Icon(
              bundle = Some("fontello"),
              glyph = Some("loop-alt-1")
            )
          ),
          Button(
            onClick = Some(togglePanel(state)),
            onTouchEnd = Some(togglePanel(state))
          )(Icon(
            bundle = Some("fontello"),
            glyph = Some(if (state.collapsed) "plus" else "minus")
          )),
          Button(
            onClick = Some(removePanel(state)),
            onTouchEnd = Some(removePanel(state))
          )(Icon(
            bundle = Some("fontello"),
            glyph = Some("cancel")
          )))
      else
        <.div()

      val controls = if (props.customControls.nonEmpty)
                      <.div(
                        controlClassSet,
                        props.customControls
                      )
                    else
                      ctl

      val display = if (props.isHorizontal)
                        if (state.collapsed) "block" else "table"
                    else
                        "block"

      val height = if (state.collapsed) "16px" else "auto"
      val overflow = if (state.collapsed) "hidden" else ""

      if (state.removed)
        <.div()
      else
        <.div(
          ^.classSet1("rubix-panel-container-with-controls",
            "active" -> state.collapsed,
            props.`class`.getOrElse("") -> props.`class`.isDefined
          ),
          controls,
          <.div(
            containerClassSet,
            ^.zIndex := state.zIndex,
            ^.overflow := overflow,
            ^.display := display,
            ^.height := height,
            React.Children.toArray(children)
          )
        )
    }

  }

  val component = ReactComponentB[Props]("panel-container")
    .initialState(State(zIndex = decreaseZIndex()))
    .renderBackend[Backend]
    .build

  def apply(`class`: Option[String] = None, bordered : Boolean = false,
            noOverflow : Boolean = false, gutterBottom : Boolean = false, plain: Boolean = false,
            collapseBottom: Boolean = false, containerClasses: Option[String] = None,
            isHorizontal: Boolean = false, controlStyles : Option[String] = None,
            key : js.Any = {}, ref : js.UndefOr[String] = "")
           (customControls: ReactElement*)(children: ReactElement*)
            = component.set(key, ref)(Props(`class`, bordered, noOverflow, gutterBottom, plain, collapseBottom,
                            containerClasses, isHorizontal, controlStyles, customControls), children: _*)
}