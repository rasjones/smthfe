package com.smoothpay.client.gui.pages

import com.usableapps.components.rubix.bootstrap._
import com.usableapps.components.rubix.gui.charts.{AlertChart, MaleFemaleChart, TrendChart}
import com.usableapps.components.rubix.gui.panels.{RevenueActivityPanel, RevenuePanel}
import japgolly.scalajs.react.ReactComponentB

/**
 * Created by uenyioha on 1/4/16.
 */
object DashboardPage {

  case class Props()

  def component = ReactComponentB[Props]("Body")
    .stateless
    .render { $ =>
      Container(id = Some("body"))(
        Grid()(
          Row()(
            Col(sm = 12)(
              PanelContainer()()(
                Panel()(
                    Panel(horizontal = true, `class` = Some("force-collapse"))(
                      PanelRight(noRadius = true, `class` = Some("bg-lightgreen fg-white panel-sm-2"))(
                        RevenuePanel()
                      ),
                      PanelRight(`class` = Some("bg-green fg-green panel-sm-4"))(
                        Grid()(
                          RevenueActivityPanel(),
                          AlertChart()
                        )
                      ),
                      PanelBody(`class` = Some("panel-sm-4"), padding = Some(0))(
                        Grid()(
                          Row()(
                            Col( xs=12, collapseLeft = true, collapseRight = true)(
                              MaleFemaleChart()
                            )
                          )
                        )
                      )
                      )
                    )
                  ),
              PanelContainer()()(
                Panel()(
                  TrendChart()
                )
              )
            )
            )
          )
        )
    }.build

  def apply() = component(Props())

}