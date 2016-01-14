package com.usableapps.components.rubix.gui.panels

import com.usableapps.components.rubix.bootstrap.{Col, Row, Grid}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

/**
 * Created by uenyioha on 1/4/16.
 */
object RevenueActivityPanel {

  case class Props()

  val component = ReactComponentB[Props]("revenue-panel")
    .stateless
    .render( $ =>
        Row(`class` = Some("bg-green fg-lightgreen"))(
          Col(xs= 6, `class` = Some("text-center"))(
            <.h3(^.`class` := "ssdsd", "Daily Activity")
          ),
          Col(xs= 6, `class` = Some("text-right"))(
            <.h2(^.`class` := "fg-lightgreen")
          )
        )
    ).build

  def apply() = component(Props())

}
