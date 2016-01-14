package com.smoothpay.client.gui.pages

import com.smoothpay.client.gui.charts.PaymentsChart
import com.usableapps.components.rubix.bootstrap._
import com.usableapps.components.rubix.facades.DataTablesQueryXtras
import com.usableapps.components.rubix.gui.charts._
import com.usableapps.components.rubix.gui.panels._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
 * Created by uenyioha on 1/4/16.
 */
object PaymentsPage {

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
                  PaymentsChart()
                )),
              PanelContainer()()(
                PanelBody()(
                  Grid()(
                    Row()(
                      Col(xs = 12)(
                        <.table( ^.id := "example", ^.`class` := "display", ^.cellSpacing := 0, ^.width := 100.pct,
                          <.thead(
                            <.tr(
                              <.th("Amount"),
                              <.th("Id"),
                              <.th("Status"),
                              <.th("Date"),
                              <.th("Time")
                            )
                          ),
                          <.tfoot(
                            <.tr(
                              <.th("Amount"),
                              <.th("Id"),
                              <.th("Status"),
                              <.th("Date"),
                              <.th("Time")
                            )
                          ),
                          <.tbody(
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            ),
                            <.tr(
                              <.td("NGN 20"),
                              <.td("ch_7fCLKcTosL1hUt"),
                              <.td("Refunded"),
                              <.td("2016/01/05"),
                              <.td("10:21:29")
                            )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
      )
    }
    .componentDidMount { b => Callback {
      import DataTablesQueryXtras._
      import org.querki.jquery._

      import js.JSConverters._

      $("#example")
        .addClass("noWrap")
        .dataTable(
          Map(
            "responsive" -> true,
            "columnDefs" -> Array(
              Map("targets" -> Array(-1, -3),
                "className" -> "dt-body-right").toJSDictionary
            ).toJSArray
          ).toJSDictionary
        )
      }
    }
    .build

  def apply() = component(Props())

}