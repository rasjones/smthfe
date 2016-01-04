package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/13/15.
  */


object Page {

  case class Props(`class`: Option[String] = None, href : Option[String] = None, begin : Boolean = false,
                   end : Boolean = false, next : Boolean = false, previous : Boolean = false, active : Boolean = false,
                   disabled : Boolean = false)


  val component = ReactComponentB[Props]("Pagination")
                    .stateless
                    .render { $ =>

                      val rChildren = $.propsChildren
                      val child = if ($.props.begin) "«"
                                  else if ($.props.end) "»"
                                  else if ($.props.next)  <.span( rChildren + " →" )
                                  else if ($.props.previous)  <.span( "← " + rChildren )
                                  else if ($.props.active)
                                        <.span( rChildren,
                                          <.span( ^.`class` :="sr-only", "(current)" ) )
                                  else
                                      rChildren
                      <.li(
                        ^.href := "",
                        ^.classSet1($.props.`class`.getOrElse(""),
                          "next" -> $.props.next,
                          "active" -> $.props.active,
                          "disabled" -> $.props.active,
                          "previous" -> $.props.previous
                        ),
                        <.a(
                          ^.href := $.props.href.getOrElse("#"),
                          child.asInstanceOf[js.Array[ReactNode]]
                        )
                      )
                    }
                    .build


  def apply(`class`: Option[String] = None, href : Option[String] = None, begin : Boolean = false,
            end : Boolean = false, next : Boolean = false, previous : Boolean = false, active : Boolean = false,
            disabled : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`: Option[String], href, begin, end, next, previous, active,
                  disabled), children : _*)

}


object Pagination {

  case class Props(`class`: Option[String] = None, sm: Boolean = false, lg: Boolean = false)

  val component = ReactComponentB[Props]("Pagination")
                    .stateless
                    .render { $ =>
                      <.ul(
                        ^.classSet1($.props.`class`.getOrElse(""),
                          "pagination-sm " -> $.props.sm,
                          "pagination-lg " -> $.props.lg
                        ),
                        $.propsChildren
                      )
                    }
                    .build

  def apply(`class`: Option[String] = None, sm: Boolean = false, lg: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, sm, lg), children : _*)

}

object Pager {

  case class Props(`class`: Option[String] = None)

  val component = ReactComponentB[Props]("Pager")
                      .stateless
                      .render { $ =>
                        <.ul(
                          ^.classSet1("pager", $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
                          $.propsChildren
                        )
                      }
                      .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)

}
