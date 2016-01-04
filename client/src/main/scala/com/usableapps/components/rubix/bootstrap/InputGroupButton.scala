package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/13/15.
  */
object InputGroupButton {

  case class Props(`class`: Option[String] = None, id: Option[String] = None,
                   onSetSelectItem: (ReactEvent) => Callback,
                   dropUp : Boolean = false, dropDown : Boolean = false, toggleOnHover: Boolean = false)

  class Backend($: BackendScope[Props, String]) {

    def render(props: Props, state: String, propsChildren: PropsChildren) = {

      val children = React.Children.map(propsChildren,
        (child : ReactNode, key: Int) => React.cloneElement(child.asInstanceOf[ReactElement],
            Map("dropdown" -> state,
              "toggleOnHover" -> props.toggleOnHover,
              "onDropdownSetSelectItem" -> props.onSetSelectItem,
              "key" -> key)))

      <.div(
        ^.classSet1("input-group-btn",
          props.`class`.getOrElse("") -> props.`class`.isDefined,
          "dropdown" -> props.dropDown,
          "dropup" -> props.dropUp
        ),
        children.asInstanceOf[js.Array[ReactNode]]
      )
    }

  }

  val component = ReactComponentB[Props]("InputGroup")
                    .initialState_P(f => f.id.getOrElse(increaseGlobalId().toString))
                    .renderBackend[Backend]
                    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None,
            onSetSelectItem: (ReactEvent) => Callback,
            dropUp : Boolean = false, dropDown : Boolean = false, toggleOnHover: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id, onSetSelectItem,
                      dropUp, dropDown, toggleOnHover), children: _*)

}


object InputGroupAddon {
  case class Props(`class`: Option[String] = None)

  val component = ReactComponentB[Props]("input-group-addon")
    .stateless
    .render { $ =>
      <.div(
        ^.classSet1("input-group-addon",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        $.propsChildren
      )
    }
  .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children: _*)

}


object InputGroup {

  case class Props(`class`: Option[String] = None, smInputGroup: Boolean = false,
                   lgInputGroup: Boolean = false)

  val component = ReactComponentB[Props]("input-group")
    .stateless
    .render { $ =>

      <.div(
        ^.classSet1("input-group",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "input-group-sm" -> $.props.smInputGroup,
          "input-group-lg" -> $.props.lgInputGroup
        ),
        $.propsChildren
      )

    }
  .build

  def apply(`class`: Option[String] = None, smInputGroup: Boolean = false,
            lgInputGroup: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, smInputGroup, lgInputGroup), children : _*)

}