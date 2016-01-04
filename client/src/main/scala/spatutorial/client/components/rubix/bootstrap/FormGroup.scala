package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 12/1/15.
  */

object FormGroup {

  case class Props(`class`: Option[String],
                    sm : Boolean = false, lg: Boolean = false, error : Boolean = false, success : Boolean = false,
                    warning : Boolean = false, feedback : Boolean = false
                  )

  val component = ReactComponentB[Props]("formgroup")
    .stateless
    .render { $ =>

      <.div(
        ^.classSet1("form-group",
          $.props.`class`.getOrElse("") ->  $.props.`class`.isDefined,
          "form-group-sm" -> $.props.sm,
          "form-group-lg" -> $.props.lg,
          "has-error" -> $.props.error,
          "has-success" -> $.props.success,
          "has-warning" -> $.props.warning,
          "feedback" -> $.props.feedback
        ),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String],
            sm : Boolean = false, lg: Boolean = false, error : Boolean = false, success : Boolean = false,
            warning : Boolean = false, feedback : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, sm, lg, error, success, warning, feedback), children: _*)

}
