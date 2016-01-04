package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.util.Try

/**
  * Created by uenyioha on 12/13/15.
  */

object ProgressGroup {

  case class Props(`class`: Option[String], collapseBottom: Boolean,
                                         maybeBackground : Option[String], rChildren: PropsChildren)

  val component = ReactComponentB[Props]("ProgressGroup")
                    .stateless
                    .render { $ =>
                      <.div(
                        ^.classSet($.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
                          "progress-collapse-bottom" -> $.props.collapseBottom),
                        ^.background := $.props.maybeBackground.getOrElse(""),
                        React.Children.map($.props.rChildren, (c: ReactNode, k : Int) =>
                          React.cloneElement(c.asInstanceOf[ReactElement],
                            Map("stack" -> true, "key" -> k)
                          )
                        ).asInstanceOf[js.Array[ReactNode]]
                      )
                    }
                    .build

  def apply(`class`: Option[String], collapseBottom: Boolean,
            maybeBackground : Option[String],
            key : js.Any = {}, ref : js.UndefOr[String] = "")(rChildren: PropsChildren)
  = component.set(key, ref)(Props(`class`, collapseBottom, maybeBackground, rChildren))
}

object Progress {

  private def `progress-group-construct-child`(id: Option[String], `class`: Option[String], collapseBottom: Boolean, value: Int, min: Int, max: Int,
                                         maybeBackground : Option[String], child: ReactElement*) = {
    <.div(
      ^.classSet(`class`.getOrElse("") -> `class`.isDefined, "progress-collapse-bottom" -> collapseBottom),
      ^.id := id,
      ^.value := value,
      ^.min := min,
      ^.max := max,
      child
    )
  }

  case class Props(`class`: Option[String] = None, id: Option[String] = None,
                   value: Int, maybeColor : Option[String] = None,
                   min: Int, max: Int,
                   isStack: Boolean = false, maybeFgColor : Option[String] = None, background: Option[String] = None,
                   minWidth: Option[Int] = None, maybeWithLabel : Option[String] = None,
                   info: Boolean = false, danger: Boolean = false, success: Boolean = false,
                   warning : Boolean = false, striped: Boolean = false,
                   stack : Boolean = false, collapseBottom: Boolean = false, active: Boolean = false)

  val component = ReactComponentB[Props]("progress")
                    .stateless
                    .render { $ =>

                      val classSet = ^.classSet1( "progress progress-bar",
                        "active" -> $.props.active,
                        "progress-bar-info" -> $.props.info,
                        "progress-bar-danger" -> $.props.danger,
                        "progress-bar-success" -> $.props.success,
                        "progress-bar-warning" -> $.props.warning,
                        "progress-bar-striped" -> $.props.striped,
                        "progress-collapse-bottom" -> $.props.collapseBottom
                      )

                      val value = $.props.value
                      val color = $.props.maybeColor.getOrElse("")
                      val minValue = $.props.min
                      val maxValue = $.props.max
                      val fgColor = $.props.maybeFgColor.getOrElse("")
                      val minWidth = $.props.minWidth.getOrElse(-1)

                      val infoString = if ($.props.info) "info" else ""
                      val dangerString = if ($.props.danger) "danger" else ""
                      val successString = if ($.props.success) "success" else ""
                      val warningString = if ($.props.warning) "warning" else ""

                      val suffixString = s"($infoString$dangerString$successString$warningString)"

                      val temp = for {
                        withLabel <-$.props.maybeWithLabel
                      } yield {
                        val convertValue : String = Try(withLabel.toInt.toString + "%").getOrElse(withLabel)
                        <.span(
                          ^.color := fgColor,
                          convertValue
                        )
                      }

                      val child = temp orElse Some(
                        <.span(
                          ^.`class` := "sr-only",
                          s"$value% Complete $suffixString"
                        )
                      )

                      if ($.props.isStack)
                        <.div(
                          ^.id := $.props.id,
                          classSet + ^.classSet( $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
                          ^.role := "progressbar",
                          ^.aria.valuenow := value,
                          ^.aria.valuemin := minValue,
                          ^.aria.valuemax := maxValue,
                          ^.width := s"$value%",
                          ^.background := color,
                          ^.minWidth := minWidth,
                          child.get
                        )
                      else {
                        `progress-group-construct-child`(`class` = $.props.`class`, collapseBottom = $.props.collapseBottom, id = $.props.id,
                                                    maybeBackground = $.props.background, value = value, min = minValue, max = maxValue,
                                                    child =
                                                      <.div(
                                                        classSet,
                                                        ^.role := "progressbar",
                                                        ^.aria.valuenow := value,
                                                        ^.aria.valuemin := minValue,
                                                        ^.aria.valuemax := maxValue,
                                                        ^.width := s"$value%",
                                                        ^.background := color,
                                                        ^.minWidth := minWidth,
                                                        child.get
                                                      )
                        )
                      }
                    }
                    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None,
            value: Int, maybeColor : Option[String] = None,
            min : Int, max: Int,
            isStack: Boolean = false, maybeFgColor : Option[String] = None,background: Option[String] = None,
            maybeMinWidth: Option[Int] = None, maybeWithLabel : Option[String] = None,
            info: Boolean = false, danger: Boolean = false, success: Boolean = false,
            warning : Boolean = false, striped: Boolean = false,
            stack : Boolean = false, collapseBottom: Boolean = false,
            active: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {}) =
    component.set(key, ref)(Props(`class`, id,
                  value, maybeColor, min, max,isStack, maybeFgColor, background,
                    maybeMinWidth, maybeWithLabel, info, danger, success, warning, striped,
                    stack, collapseBottom, active))
}
