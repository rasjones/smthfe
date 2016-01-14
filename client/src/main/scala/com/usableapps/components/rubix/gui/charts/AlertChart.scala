package com.usableapps.components.rubix.gui.charts

import com.usableapps.components.rubix.facades.Rubix
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

/**
 * Created by uenyioha on 1/4/16.
 */
object AlertChart {

  case class Props()

  import js.JSConverters._

  val component = ReactComponentB[Props]("male-female-chart")
    .stateless
    .render( $ =>
      <.div(
        ^.id := "alert-chart", ^.`class` := "rubix-chart"
      )
    )
    .componentDidMount( $ => Callback {

      val chart = new Rubix("#alert-chart",
          Map(
            "width" -> "100%",
            "height" -> 200,
            "hideLegend" -> true,
            "hideAxisAndGrid" -> true,
            "focusLineColor" -> "#fff",
            "theme_style" -> "dark",
            "axis" -> Map(
              "x" -> Map(
                "type" -> "linear"
              ),
              "y" -> Map(
                "type" -> "linear",
                "tickFormat" -> "d"
              )
            ),
            "tooltip" -> Map(
              "color" -> "#fff",
              "format" -> Map(
                "x" -> "d",
                "y" -> "d"
              )
            ),
            "margin" -> Map(
            "left" -> 25,
            "top" -> 50,
            "right" -> 25,
            "bottom" -> 25
            )
          ).toJSDictionary
        )

        val alerts = chart.column_series(
          Map(
            "name" -> "Load",
            "color" -> "#7CD5BA",
            "nostroke" -> true
          ).toJSDictionary
        )

        import js.JSConverters._

        val data = Seq(
          Map("x" -> 0, "y" -> 30).toJSDictionary,
          Map("x" -> 1, "y" -> 40).toJSDictionary,
          Map("x" -> 2, "y" -> 15).toJSDictionary,
          Map("x" -> 3, "y" -> 30).toJSDictionary,
          Map("x" -> 4, "y" -> 35).toJSDictionary,
          Map("x" -> 5, "y" -> 70).toJSDictionary,
          Map("x" -> 6, "y" -> 50).toJSDictionary,
          Map("x" -> 7, "y" -> 60).toJSDictionary,
          Map("x" -> 8, "y" -> 35).toJSDictionary,
          Map("x" -> 9, "y" -> 30).toJSDictionary,
          Map("x" -> 10, "y" -> 40).toJSDictionary,
          Map("x" -> 11, "y" -> 30).toJSDictionary,
          Map("x" -> 12, "y" -> 50).toJSDictionary,
          Map("x" -> 13, "y" -> 35).toJSDictionary
        ).toJsArray

        alerts.addData(data)
      }
    )
    .build

  def apply() = component(Props())

}
