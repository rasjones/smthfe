package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 11/30/15.
  */

object Form {

  case class Props(`class` : Option[String] = None, inline : Boolean = false, horizontal : Boolean = false,
                   allowAutoComplete: Boolean = false, role : Option[String] = None)


  val component = ReactComponentB[Props]("Form")
    .stateless
    .render { $ =>
      <.form(
        ^.role := $.props.role,
        ^.classSet(
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "form-inline" -> $.props.inline,
          "form-horizontal" -> $.props.horizontal
        ),
        ^.autoComplete := (if ($.props.allowAutoComplete) "on" else "off"),
        $.propsChildren
      )
    }.build


  def apply(`class` : Option[String] = None, inline : Boolean = false, horizontal : Boolean = false,
            allowAutoComplete: Boolean = false, role : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, inline, horizontal, allowAutoComplete, role), children : _*)

}
