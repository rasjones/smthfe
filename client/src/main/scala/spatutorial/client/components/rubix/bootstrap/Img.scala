package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.{ReactElement, ReactComponentB}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/6/15.
  */
object Img {
  case class Props(`class` : Option[String] = None, circle: Boolean = false, rounded : Boolean = false,
                   thumbnail : Boolean = false, responsive : Boolean = false, src : Option[String] = None,
                   style : Option[String] = None)


  val component = ReactComponentB[Props]("row")
    .stateless
    .render{ $ =>
      val srcString = $.props.src.getOrElse("/imgs/blank.gif")
      val styleString = $.props.style.getOrElse("")

      <.img(
        ^.src := srcString,
        ^.classSet(
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
          "img-circle" -> $.props.circle,
          "img-rounded" -> $.props.rounded,
          "img-thumbnail" -> $.props.thumbnail,
          "img-responsive" -> $.props.responsive
        ),
        ^.style := styleString,
        $.props.src.isEmpty ?= (^.backgroundColor := "#EEEEEE"),
        $.propsChildren
      )
    }
    .build

  def apply(`class` : Option[String] = None, circle: Boolean = false, rounded : Boolean = false, thumbnail : Boolean = false,
            responsive : Boolean = false, src : Option[String] = None, style : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, circle, rounded, thumbnail, responsive, src, style))

}
