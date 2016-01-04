package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.{ReactElement, ReactComponentB}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/1/15.
  */
object HelpBlock {

  case class Props(`class`: Option[Set[String]])

  val component = ReactComponentB[Props]("helpblock")
    .stateless
    .render{ $ =>
      val classesString = $.props.`class`.getOrElse("")
      <.p(
        ^.`class` := "help-block  " + classesString,
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[Set[String]],
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children: _*)

}
