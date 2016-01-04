package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactNode, ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 12/7/15.
  */
object TextArea {

  case class Props(`class` : Option[String])

  val component = ReactComponentB[Props]("textarea")
    .stateless
    .render { $ =>

      <.textarea(
        ^.classSet1("form-control",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        ^.defaultValue := $.propsChildren.asInstanceOf[js.Array[ReactNode]]
      )
    }
    .build

  def apply(`class` : Option[String],
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class` : Option[String]), children : _*)

}
