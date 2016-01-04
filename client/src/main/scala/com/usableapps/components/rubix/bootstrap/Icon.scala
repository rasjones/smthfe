package com.usableapps.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js

/**
  * Created by uenyioha on 12/1/15.
  */
object Icon {

  case class Props(id: Option[String] = None, `class` : Option[String] = None, feedback : Boolean = false,
                   bundle : Option[String] = None, glyph : Option[String] = None)

  val component = ReactComponentB[Props]("icon")
    .stateless
    .render { $ => {

      val bundleString = $.props.bundle.getOrElse("")
      val glyphString = $.props.glyph.getOrElse("")

      <.span(
        ^.id := $.props.id,
        ^.classSet1("rubix-icon",
          "form-control-feedback" -> $.props.feedback,
          bundleString -> $.props.bundle.isDefined,
          s"icon-$bundleString-$glyphString" -> ($.props.bundle.isDefined && $.props.glyph.isDefined)
        )
      )
    }}
    .build


  def apply(id: Option[String] = None, `class` : Option[String] = None, feedback : Boolean = false,
            bundle : Option[String] = None, glyph : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {}) =
    component.set(key, ref)(Props(id, `class`, feedback, bundle, glyph))
}
