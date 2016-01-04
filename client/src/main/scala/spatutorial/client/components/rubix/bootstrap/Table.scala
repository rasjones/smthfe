package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{PropsChildren, ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 12/7/15.
  */
object Table {

  case class Props(`class` : Option[String], responsive: Boolean = false, hover: Boolean = false, striped: Boolean = false,
                   bordered : Boolean = false, collapsed: Boolean = false, condensed : Boolean = false,
                   `align-top` : Boolean = false, `align-middle` : Boolean = false, `align-bottom` : Boolean = false) {

    def genClasses: TagMod = {
      ^.classSet1("table",
        `class`.getOrElse("") -> `class`.isDefined,
        "table-hover" -> hover,
        "table-striped" -> striped,
        "table-bordered" -> bordered,
        "table-collapsed" -> collapsed,
        "table-condensed" -> condensed,
        "table-top-align" -> `align-top`,
        "table-middle-align" -> `align-middle`,
        "table-bottom-align" -> `align-bottom`
      )
    }

  }

  def tableConstruct(`class` : Option[String], tableClasses: TagMod, children : PropsChildren) = {
    <.table(
      tableClasses,
      children
    )
  }

  val component = ReactComponentB[Props]("table")
    .stateless
    .render { $ =>
      val tableClasses = $.props.genClasses

      if ($.props.responsive)
        <.div(
          ^.`class` := "table-responsive",
            tableConstruct($.props.`class`, tableClasses, $.propsChildren)
        )
      else
        tableConstruct($.props.`class`, tableClasses, $.propsChildren)
    }.build

  def apply(`class` : Option[String], responsive: Boolean = false, hover: Boolean = false, striped: Boolean = false,
            bordered : Boolean = false, collapsed: Boolean = false, condensed : Boolean = false,
            `align-top` : Boolean = false, `align-middle` : Boolean = false, `align-bottom` : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, responsive, hover,
                      striped, bordered, collapsed, condensed, `align-top`,
                      `align-middle`, `align-bottom`), children : _*)

}
