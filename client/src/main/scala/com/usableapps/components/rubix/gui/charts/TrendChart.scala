package com.usableapps.components.rubix.gui.charts

import com.usableapps.components.rubix.bootstrap.PanelBody
import com.usableapps.components.rubix.facades.Rubix
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
 * Created by uenyioha on 1/4/16.
 */
object TrendChart {

  case class Props()

  import js.JSConverters._

  val component = ReactComponentB[Props]("chart")
                    .stateless
                    .render( $ =>
                      PanelBody(paddingTop = Some(5))(
                        <.div(^.id := "main-chart")
                      )
                    ).componentDidMount( $ => Callback {
                        val chart = new Rubix("#main-chart",
                          Map(
                            "width" -> "100%",
                            "height" -> 500,
                            "title" -> "Revenue",
                            "titleColor" -> "#23B398",
                            "subtitle" -> "Period: 2010 to 2015",
                            "subtitleColor" -> "2EB398",
                            "axis" -> Map(
                              "x" -> Map(
                                "type" -> "datetime",
                                "tickCount" -> 3,
                                "label" -> "Time",
                                "labelColor" -> "#2EB398"
                              ),
                              "y" -> Map(
                                "type" -> "linear",
                                "tickFormat" -> "d",
                                "tickCount" -> 2,
                                "labelColor" -> "#2EB398"
                              )
                            ),
                            "tooltip" -> Map(
                              "color" -> "#55C9A6",
                              "format" -> Map(
                                "y" -> ".0f",
                                "x" -> "%x"
                              )
                            ),
                            "margin" -> Map(
                              "top" -> 25,
                              "left" -> 50,
                              "right" -> 25
                            ),
                            "interpolate" -> "linear",
                            "master_detail" -> true
                          ).toJSDictionary
                        )

                        val total_users = chart.area_series(
                          Map(
                            "name" -> "Date",
                            "color" -> "#2EB398",
                            "marker" -> "circle",
                            "fillopacity" -> 0.7,
                            "noshadow" -> true
                        ).toJSDictionary)

                        chart.extent = Array(1297110663*850+(86400000*20*(.35*40)),
                          1297110663*850+(86400000*20*(.66*40))).toJSArray

                        var t: Int = 1297110663 * 850
                        val v = List(5, 10, 2, 20, 40, 35, 30, 20, 25, 10, 20,
                                        10, 20, 15, 25, 20, 30, 25, 30, 25, 30,
                                        35, 40, 20, 15, 20, 10, 25, 15, 20, 10,
                                        25, 30, 30, 25, 20, 10, 50, 60, 30)



                        val data = v.map( x =>
                          Map[String, Int](
                            "x" -> { t = t + 86400000 * 20; t},
                            "y" -> x
                          ).toJSDictionary
                        )

                        total_users.addData(data.toJsArray)

                      }
                    ).build

  def apply() = component(Props())

}
