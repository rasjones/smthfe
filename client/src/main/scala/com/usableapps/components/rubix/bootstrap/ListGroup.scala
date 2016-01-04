package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

/**
  * Created by uenyioha on 12/7/15.
  */
object ListGroupItem {

  case class Props(`class` : Option[String] = None, href : Option[String] = None, active : Boolean = false,
                disabled: Boolean = false, info : Boolean = false, danger: Boolean = false, warning : Boolean = false,
                success: Boolean = false, bStyle : Option[String])

  val component = ReactComponentB[Props]("list-group-item")
    .stateless
    .render { $ =>

      val splitBstyle: Option[Array[String]] = $.props.bStyle.map(_.split(""""\s|,"""))

      val stylesString = (for {
        array <- splitBstyle
      } yield {
        array.map("list-group-" + _).mkString(" ")
      }).getOrElse("") + " "

      <.a(
        ^.href := $.props.href.getOrElse("#"),
        ^.classSet1( "list-group-item",
          "active" -> $.props.active,
          "disabled" -> $.props.disabled,
          "list-group-item-info" -> $.props.info,
          "list-group-item-danger" -> $.props.danger,
          "list-group-item-warning" -> $.props.warning,
          "list-group-item-success" -> $.props.success,
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        $.propsChildren
      )
    }
    .build


  def apply(props : Props,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(props, children : _*)

}

object ListGroupItemHeading {
  case class Props(`class` : Option[String] = None)

  val component = ReactComponentB[Props]("list-group-item-heading")
    .stateless
    .render { $ =>
      <.h4(
        ^.classSet1("list-group-item-heading",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }.build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}

object ListGroupItemText {
  case class Props(`class` : Option[String] = None)

  val component = ReactComponentB[Props]("list-group-item-text")
    .stateless
    .render { $ =>
      <.p(
        ^.classSet1("list-group-item-text",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }.build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}

object ListGroup {
  case class Props(`class` : Option[String] = None)

  val component = ReactComponentB[Props]("list-group")
    .stateless
    .render { $ =>
      <.div(
        ^.classSet1("list-group",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }.build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}