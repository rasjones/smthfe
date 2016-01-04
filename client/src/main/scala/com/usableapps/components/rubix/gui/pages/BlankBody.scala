package com.usableapps.components.rubix.gui.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import com.usableapps.components.rubix.bootstrap._

/**
  * Created by uenyioha on 12/26/15.
  */
object BlankBody {

  case class Props()

  val component = ReactComponentB[Props]("Body")
                    .stateless
                    .render { $ =>
                      Container(id = Some("body"))(
                        Grid()(
                          Row()(
                            Col(sm = 12)(
                              PanelContainer()()(
                                Panel()(
                                  PanelBody(`class` = Some("text-center"))(
                                    <.p("BLANK PAGE")
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    }.build

  def apply() = component(Props())

}
