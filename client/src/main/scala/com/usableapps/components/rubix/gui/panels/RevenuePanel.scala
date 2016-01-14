package com.usableapps.components.rubix.gui.panels

/**
 * Created by uenyioha on 1/4/16.
 */

import com.usableapps.components.rubix.bootstrap._
import com.usableapps.components.rubix.facades.Rubix
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object RevenuePanel {

  case class Props()

  val component = ReactComponentB[Props]("revenue-panel")
                    .stateless
                    .render( $ =>
                      Grid()(
                        Row()(
                          Col(xs= 12, `class` = Some("text-center"))(
                            <.br(),
                            <.div(
                              <.h4("Gross Revenue"),
                              <.h2(^.`class` := "fg-green visible-xs visible-md visible-lg", "NGN 9,362.74"),
                              <.h4(^.`class` := "fg-green visible-sm", 9,362.74)
                            ),
                            <.hr(^.`class` := "border-green"),
                            <.div(
                              <.h4("Net Revenue"),
                              <.h2(^.`class` := "fg-green visible-xs visible-md visible-lg", "NGN 9,362.74"),
                              <.h4(^.`class` := "fg-green visible-sm", 9,362.74)
                            )
                          )
                        )
                      )
                    ).build

  def apply() = component(Props())

}
