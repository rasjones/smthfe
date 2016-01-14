package com.smoothpay.client.gui.pages

import com.usableapps.components.rubix.bootstrap._
import com.usableapps.components.rubix.facades.DataTablesQueryXtras
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
 * Created by uenyioha on 1/5/16.
 */
object CustomerPage {

  case class Props()

  def component = ReactComponentB[Props]("Body")
    .stateless
    .render { $ =>
      Container(id = Some("body"))(
        Grid()(
          Row()(
            Col(xs = 12)(
              PanelContainer()()(
                Panel()(
                  PanelBody()(
                    Grid()(
                      Row()(
                        Col(xs = 12)(
                          <.table( ^.id := "example", ^.`class` := "display", ^.cellSpacing := 0, ^.width := 100.pct,
                            <.thead(
                              <.tr(
                                <.th("CustomerId"),
                                <.th("Customer"),
                                <.th("Date"),
                                <.th("Time")
                              )
                            ),
                            <.tfoot(
                              <.tr(
                                <.th("CustomerId"),
                                <.th("Customer"),
                                <.th("Date"),
                                <.th("Time")
                              )
                            ),
                            <.tbody(
                              <.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),
                              <.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
                              ),<.tr(
                                <.td("cus_7fB2agoDUj3zyV"),
                                <.td("ugo.enyioha@gmail.com"),
                                <.td("Jan 5, 2016"),
                                <.td("09:00:27")
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
            "iDisplayLength" -> 15,
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
