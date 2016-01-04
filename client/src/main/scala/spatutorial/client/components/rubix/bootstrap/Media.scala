package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import spatutorial.client.components.rubix.bootstrap.MediaBody.Props

import scala.scalajs.js

/**
  * Created by uenyioha on 12/7/15.
  */

object MediaBody {

  case class Props(`class`: Option[String])

  val component = ReactComponentB[Props]("media-body")
    .stateless
    .render { $ =>
      val classString = $.props.`class`.getOrElse("")

      <.div(
        ^.classSet1("media-body",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}


object Media {

  case class Props(`class`: Option[String])

  val component = ReactComponentB[Props]("media")
    .stateless
    .render { $ =>
      val classString = $.props.`class`.getOrElse("")

      <.li(
        ^.classSet1("media",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)}

object MediaDiv {

  case class Props(`class`: Option[String])

  val component = ReactComponentB[Props]("media-div")
    .stateless
    .render { $ =>
      <.div(
        ^.classSet1("media",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}

object MediaList {

  case class Props(`class`: Option[String])

  val component = ReactComponentB[Props]("media-list")
    .stateless
    .render { $ =>
      <.ul(
        ^.classSet1("media-list",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}

object MediaObject {

  case class Props(`class`: Option[String])

  val component = ReactComponentB[Props]("media-object")
    .stateless
    .render { $ =>
      <.img(
        ^.classSet1("media-object",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}

object MediaHeading {

  case class Props(`class`: Option[String])

  val component = ReactComponentB[Props]("media-heading")
    .stateless
    .render { $ =>
      val classString = $.props.`class`.getOrElse("")

      <.h4(
        ^.classSet1("media-heading fg-black50",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`), children : _*)
}
