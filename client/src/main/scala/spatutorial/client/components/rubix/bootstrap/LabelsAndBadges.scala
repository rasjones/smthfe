package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


/**
  * Created by uenyioha on 12/9/15.
  */
private object LBCommon {

  def genClasses (bsStyle : Option[String], `type` : String) = {
    val bs_style = bsStyle.getOrElse("default")
    val styles = bs_style.split(",")

    val fxn = (st : String) => `type` + "-" + st.trim
    val ret = styles.map(fxn)

    `type` + ret.mkString(" ") + " "
  }

  def `b-mixin`(`class`: Option[String], bsStyle : Option[String],
                `type`: String, propsChildren: PropsChildren) = {
    val classString = genClasses(bsStyle, `type`)

    <.span(
      ^.`class` := classString + `class`,
      propsChildren
    )
  }

}

object Badge {
  case class Props(`class`: Option[String] = None, bsStyle : Option[String] = None)

  val component = ReactComponentB[Props]("badge")
    .stateless
    .render{ $ =>
      LBCommon.`b-mixin`(`class` = $.props.`class`, bsStyle = $.props.bsStyle, "badge", $.propsChildren)
    }.build

  def apply(`class`: Option[String] = None, bsStyle : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, bsStyle), children : _*)

}

object BLabel {
  case class Props(`class`: Option[String] = None, bsStyle : Option[String] = None)

  val component = ReactComponentB[Props]("badge")
    .stateless
    .render{ $ =>
      LBCommon.`b-mixin`(`class` = $.props.`class`, bsStyle = $.props.bsStyle, "badge", $.propsChildren)
    }.build

  def apply(`class`: Option[String] = None, bsStyle : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, bsStyle), children : _*)

}

