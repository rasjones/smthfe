package com.usableapps.components.rubix.gui

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.document
import com.usableapps.components.rubix.bootstrap._
import com.usableapps.components.rubix.gui.Location.Page

/**
  * Created by uenyioha on 12/27/15.
  */
object Footer {

  case class Props(router: RouterCtl[Page])

  case class State(version: String)

  class Backend($ : BackendScope[Props, State]) {

    def render(state: State) = {

      <.div(
        ^.id := "footer-container",
        Grid(id = Some("footer"), `class` = Some("text-center"))(
          Row()(
            Col(xs = 12)(
              <.div(s"© 2016 Usable Apps Inc - ${state.version}")
            )
          )
        )
      )

    }

  }

  val component = ReactComponentB[Props]("footer")
    .initialState(State(""))
    .renderBackend[Backend]
    .componentWillMount(scope =>
      scope.modState(s => s.copy(document.getElementsByTagName("body")(0).attributes.getNamedItem("data-version").value)
    ))
    .build

  def apply(router : RouterCtl[Page]) = component(Props(router))

}
