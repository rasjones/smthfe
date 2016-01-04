package spatutorial.client.components.rubix.example.loc

import japgolly.scalajs.react.ReactElement
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import spatutorial.client.components.rubix.bootstrap.SidebarNavItem

/**
 * Created by uenyioha on 1/2/16.
 */

sealed abstract class Location(val title: String, val routerPath: String,  val render : () => ReactElement,
                               val active: Boolean = false, val glyph : Option[String] = None,
                               val bundle : Option[String] = None)

object Location {

//  case object Home extends Location("Home Page", "home", () => BlankPage.content)
//  case object Lock extends Location("Lock Page", "lock", () => BlankPage.content)
//  case object Blank extends Location("Blank Page", "blank", () => BlankPage.content)
//  case object Menu extends Location("Menu", "menu", () => BlankPage.content)
//  case object Inbox extends Location("Inbox", "inbox", () => BlankPage.content)
//  case object Mail extends Location("Mail", "mail", () => BlankPage.content)
//  case object Compose extends Location("Compose", "mail", () => BlankPage.content)
//
//  val values = List[Location](
//    Blank, Menu, Inbox, Mail, Compose
//  )
//
//  def default: Location = values.head
//
//  def routes = RouterConfigDsl[Location].buildRule { dsl =>
//    import dsl._
//
//    values.map ( e =>
//      staticRoute(e.routerPath, e) ~> renderR(r => component(Props(current = e, router = r)))
//    ).reduce(_ | _)
//
//  }

}