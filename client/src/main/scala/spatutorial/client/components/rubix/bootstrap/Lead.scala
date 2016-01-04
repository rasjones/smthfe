package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 12/7/15.
  */
object Lead {

  case class Props(`class` : Option[String] = None)

  val component = ReactComponentB[Props]("lead")
    .stateless
    .render { $ =>

      <.p(
        ^.classSet1("lead",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        $.propsChildren
      )

    }
    .build

  def apply(`class` : Option[String] = None, key : js.Any = {}, ref : js.UndefOr[String] = "")
           (children : ReactElement*) = component.set(key,ref)(Props(`class`), children : _*)

}
