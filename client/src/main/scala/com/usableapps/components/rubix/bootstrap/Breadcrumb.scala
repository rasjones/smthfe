package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 11/30/15.
  */
object Breadcrumb {
  case class Props(`class`: Option[String] = None)

  val component = ReactComponentB[Props]("Breadcrumb")
    .stateless
    .render( $ => {
        <.ol(
         ^.classSet1("breadcrumb ",
           $.props.`class`.getOrElse("") -> true),
          $.propsChildren
        )
      }
    ).build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children: _*)
}

private object `b-link-li` {
  case class Props(classSet : TagMod = vdom.EmptyTag)

  val component = ReactComponentB[Props]("b-link-li")
    .stateless
    .render { $ =>
      <.li(
        $.props.classSet,
        $.propsChildren
      )
    }.build

  def applyChildren(classSet : TagMod = vdom.EmptyTag)
                   (children: PropsChildren) = component(Props(classSet), children)
  def applyNode(classSet : TagMod = vdom.EmptyTag)
            (children: ReactNode*) = component(Props(classSet), children : _*)
}

object BLink {
  case class Props(`class`: Option[String] = None, href : Option[String] = None, active: Boolean = false)

  val component = ReactComponentB[Props]("b-link")
    .stateless
    .render { $ =>
      val classString = $.props.`class`.getOrElse("")
      if ($.props.active)
        `b-link-li`.applyChildren(
          ^.classSet1(classString,
            "active" -> $.props.active
          ))($.propsChildren)
      else
        `b-link-li`.applyNode(
          ^.classSet1(classString,
            "active" -> $.props.active)
        )(
          <.a(
            ^.href := $.props.href.getOrElse("#"),
            <.span(
              $.propsChildren
            ),
            <.span(" ")
          )
        )
    }
    .build

  def apply(`class`: Option[String] = None, href : Option[String] = None, active: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, href, active), children: _*)
}
