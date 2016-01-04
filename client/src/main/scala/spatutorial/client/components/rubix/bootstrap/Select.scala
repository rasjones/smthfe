package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/7/15.
  */
object Select {

  case class Props(`class` : Option[String] = None, smInput: Boolean = false, lgInput: Boolean  = false)

  val component = ReactComponentB[Props]("select")
    .stateless
    .render { $ =>

      <.select(
        ^.classSet1("form-control ",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "input-sm" -> $.props.smInput,
          "input-lg" -> $.props.lgInput
        ),
        $.propsChildren
      )

    }.build

  def apply(`class` : Option[String] = None, smInput: Boolean = false, lgInput: Boolean  = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, smInput, lgInput), children: _*)

}
