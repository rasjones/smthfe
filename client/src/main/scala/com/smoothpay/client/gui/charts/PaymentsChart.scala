package com.smoothpay.client.gui.charts

import com.usableapps.components.rubix.facades.Rubix
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.util.Random


/**
 * Created by uenyioha on 1/6/16.
 */
object PaymentsChart {

  case class Props()

  import js.JSConverters._

  val component = ReactComponentB[Props]("male-female-chart")
    .stateless
    .render( $ =>
      <.div(
        ^.id := "payments-chart", ^.`class` := "rubix-chart"
      )
    )
    .componentDidMount( $ => Callback {

      val chart = new Rubix("#payments-chart",
        Map(
          "title" -> "Successful Charges",
          "width" -> 100.pct,
          "height" -> 300,
          "tooltip" -> Map(
            "color" -> "#0054A9",
            "format" -> Map(
              "x" -> "%d/%m",
              "y" -> ".0f"
            )
          )
        ).toJSDictionary
      )

      val alerts = chart.line_series(
        Map(
          "name" -> "Series A",
          "color" -> "#0054A9"
        ).toJSDictionary
      )

      val rnd = new Random()

      val data = (1 to 100).foldLeft((Seq[Object](), 0))((a: (Seq[Object], Int), b: Int) =>
        (a._1 :+ Map("x" -> b, "y" ->  (-0.5 + rnd.nextInt( 200 - 2 + 1 )).toInt).toJSDictionary, a._2)
      )._1

      alerts.addData(data.toJsArray)
    }
    )
    .build

  def apply() = component(Props())

}
