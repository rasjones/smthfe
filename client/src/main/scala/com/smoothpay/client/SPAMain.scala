package com.smoothpay.client

import com.smoothpay.client.location.Location
import com.smoothpay.client.location.Location._
import com.smoothpay.client.logger.log
import japgolly.scalajs.react.ReactDOM
import japgolly.scalajs.react.extra.router._
import org.scalajs.dom
import com.usableapps.components.rubix.bootstrap.SidebarMixin
import com.smoothpay.client.gui.SPDashboard

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport("SPAMain")
object SPAMain extends js.JSApp {

    def routes = RouterConfigDsl[Page].buildRule { dsl =>
      import dsl._

      values.map ( e =>
        staticRoute(e.routerPath, e) ~> renderR(r => SidebarMixin(SPDashboard(router = r, page = e)))
      ).reduce(_ | _)

    }

  // configure the router
  val routerConfig = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    // wrap/connect components to the circuit
    ( trimSlashes
      | staticRoute(root, Location.default) ~> renderR(ctl => SidebarMixin(SPDashboard(ctl, Location.default)))
      | routes
      )
      .notFound(redirectToPage(Location.default)(Redirect.Replace))
      .renderWith(layout)

  }

  // base layout for all pages
  def layout(c: RouterCtl[Page], r: Resolution[Page]) = {

    SidebarMixin(SPDashboard(c, r.page, None))

  }



  @JSExport
  def main(): Unit = {
    log.warn("Application starting")
    // send log messages also to the server
    log.enableServerLogging("/logging")
    log.info("This message goes to server as well")

    // create stylesheet
    // GlobalStyles.addToDocument()
    // create the router
    val router = Router(BaseUrl.until_#, routerConfig)
    // tell React to render the router in the document body
    ReactDOM.render(router(), dom.document.getElementById("app-container"))
  }
}