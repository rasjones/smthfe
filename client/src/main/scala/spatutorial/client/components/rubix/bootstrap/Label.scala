package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 12/6/15.
  */
object Label {

  case class Props(`class`: Option[String] = None, inline: Boolean = false, control : Boolean = false,
                   xs : Int = 0, ss : Int = 0, ms : Int = 0, ls : Int = 0,
                   collapseLeft: Boolean = false, collapseRight : Boolean = false,
                   collapseTop : Boolean = false, collapseBottom: Boolean = false,
                   gutterRight : Boolean = false, gutterLeft : Boolean = false,
                   gutterTop : Boolean = false, gutterBottom : Boolean = false,
                   clearfix: Boolean = false, hidden : Boolean = false, visible : Option[String] = None,
                   push : Boolean = false, pull : Boolean = false, offset : Boolean = false)

  val component = ReactComponentB[Props]("label")
    .stateless
    .render { $ =>

      val colClassSet = Col.Props(
          xs = $.props.xs, sm = $.props.ss, md = $.props.ms, lg = $.props.ms,
          collapseLeft = $.props.collapseLeft, collapseRight = $.props.collapseRight,
          collapseTop = $.props.collapseTop, collapseBottom = $.props.collapseBottom,
          gutterRight = $.props.gutterRight, gutterLeft = $.props.gutterLeft,
          gutterTop = $.props.gutterTop, gutterBottom = $.props.gutterBottom,
          clearfix = $.props.clearfix, hidden = $.props.hidden, visible = $.props.visible,
          push = $.props.push, pull = $.props.pull, offset = $.props.offset).genClasses

      <.label(
        ^.classSet1($.props.`class`.getOrElse(""),
          "inline" -> $.props.inline,
          "control-label" -> $.props.control
        ) + colClassSet,
        $.propsChildren
      )

    }
    .build

  def apply(`class` : Option[String],inline: Boolean = false, control : Boolean = false,
            xs : Int = 0, ss : Int = 0, ms : Int = 0, ls : Int = 0,
            collapseLeft: Boolean = false, collapseRight : Boolean = false,
            collapseTop : Boolean = false, collapseBottom: Boolean = false,
            gutterRight : Boolean = false, gutterLeft : Boolean = false,
            gutterTop : Boolean = false, gutterBottom : Boolean = false,
            clearfix: Boolean = false, hidden : Boolean = false, visible : Option[String] = None,
            push : Boolean = false, pull : Boolean = false, offset : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class` : Option[String],
                                            inline, control, xs, ss, ms, ls,
                                            collapseLeft, collapseRight,
                                            collapseTop, collapseBottom,
                                            gutterRight, gutterLeft,
                                            gutterTop, gutterBottom,
                                            clearfix, hidden, visible,
                                            push, pull, offset), children : _*)

}
