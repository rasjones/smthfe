package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/7/15.
  */
class Tag {

  case class Props(`class`: Option[String] = None,
                   href : Option[String] = None, color : Option[String] = None)

  val component = ReactComponentB[Props]("tag")
                    .stateless
                    .render { $ =>
                      val hrefString = $.props.href.getOrElse("#")
                      val colorString = $.props.color.getOrElse("darkgreen45")

                      <.a(
                        ^.href := hrefString,
                        ^.color := colorString,
                        ^.classSet1("left-tag",
                          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
                          s"border-hover-$colorString" -> true,
                          s"bg-hover-$colorString" -> true,
                          "fg-hover-white" -> true,
                          "bg-lightgray50" -> true,
                          "border-lightgray50" -> true,
                          "fg-text" -> true
                        ),
                        $.propsChildren
                      )
                    }
                    .build

  def apply(`class`: Option[String] = None,
            href : Option[String] = None, color : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, href, color), children : _*)

}
