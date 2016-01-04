package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js


/**
 * Created by uenyioha on 11/28/15.
 */
object Container {

  case class Props(`class`: Option[String] = None, id: Option[String] = None,
                   fixed: Boolean = false, fluid : Boolean = false)

  val component = ReactComponentB[Props]("Container")
    .render { $ =>

      <.div(
        ^.id := $.props.id,
        ^.classSet(
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "container" -> $.props.fixed,
          "container-fluid" -> $.props.fluid
        ),
        $.propsChildren
      )

    }
    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None, fixed: Boolean = false, fluid : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id, fixed, fluid), children: _*)
}
