package spatutorial.client

import japgolly.scalajs.react.ReactDOM
import japgolly.scalajs.react.extra.router._
import org.scalajs.dom
import spatutorial.client.components.rubix.bootstrap.SidebarMixin
import spatutorial.client.components.rubix.gui.{Location, Dashboard}
import spatutorial.client.components.rubix.gui.Location._
import spatutorial.client.logger._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport("SPAMain")
object SPAMain extends js.JSApp {

    def routes = RouterConfigDsl[Page].buildRule { dsl =>
      import dsl._

      values.map ( e =>
        staticRoute(e.routerPath, e) ~> renderR(r => SidebarMixin(Dashboard(router = r, page = e)))
      ).reduce(_ | _)

    }

  // configure the router
  val routerConfig = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    // wrap/connect components to the circuit
    ( trimSlashes
      | staticRoute(root, Location.default) ~> renderR(ctl => SidebarMixin(Dashboard(ctl, Location.default)))
      | routes
      )
      .notFound(redirectToPage(Location.default)(Redirect.Replace))
      .renderWith(layout)

  }

  // base layout for all pages
  def layout(c: RouterCtl[Page], r: Resolution[Page]) = {

    SidebarMixin(Dashboard(c, r.page, None))

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