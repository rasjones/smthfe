package com.usableapps.components.rubix.gui.charts


import com.usableapps.components.rubix.facades.Rubix
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
 * Created by uenyioha on 1/4/16.
 */
object MaleFemaleChart {

  case class Props()

  import js.JSConverters._

  val component = ReactComponentB[Props]("male-female-chart")
                    .stateless
                    .render( $ =>
                      <.div(
                        ^.id := "make-female-chart"
                      )
                    )
                    .componentDidMount( $ => Callback {

                      val chart = new Rubix("#make-female-chart",
                        Map(
                          "height" -> 200,
                          "title" -> "Demographics",
                          "subtitle" -> "Customers",
                          "axis" -> Map(
                            "x" -> Map(
                              "type" -> "ordinal",
                              "tickFormat" -> "d",
                              "tickCount" -> 2,
                              "label" -> "Time"
                            ),
                            "y" -> Map(
                              "type" -> "linear",
                              "tickFormat" -> "d"
                            )
                          ),
                          "tooltip" -> Map(
                            "theme_style" -> "dark",
                            "format" -> Map(
                              "y" -> ".0f"
                            ),
                            "abs" -> Map(
                              "y" -> true
                            )
                          ),
                          "stacked" -> true,
                          "interpolate" -> true,
                          "show_markers" -> true
                        ).toJSDictionary
                        )

                        val column = chart.column_series(
                          Map(
                            "name" -> "Male Customers",
                            "color" -> "#2D89EF",
                            "marker" -> "cross"
                          ).toJSDictionary
                        )

                      import js.JSConverters._

                      val data = Seq(
                          Map("x" -> 2005, "y" -> 21).toJSDictionary,
                          Map("x" -> 2006, "y" -> 44).toJSDictionary,
                          Map("x" -> 2007, "y" -> 14).toJSDictionary,
                          Map("x" -> 2008, "y" -> 18).toJSDictionary,
                          Map("x" -> 2009, "y" -> 23).toJSDictionary,
                          Map("x" -> 20010, "y" -> 21).toJSDictionary
                        ).toJsArray

                        column.addData(data)

                        val column1 = chart.column_series(
                          Map(
                            "name" -> "Female Customers",
                            "color" -> "#FF0097",
                            "marker" -> "diamond"
                          ).toJSDictionary
                        )

                        val data1 = Seq(
                          Map("x" -> 2005, "y" -> -79).toJSDictionary,
                          Map("x" -> 2006, "y" -> -56).toJSDictionary,
                          Map("x" -> 2007, "y" -> -86).toJSDictionary,
                          Map("x" -> 2008, "y" -> -82).toJSDictionary,
                          Map("x" -> 2009, "y" -> -77).toJSDictionary,
                          Map("x" -> 20010, "y" -> -79).toJSDictionary
                        ).toJSArray

                        column1.addData(data1)
                      }
                    )
                  .build

  def apply() = component(Props())

}
