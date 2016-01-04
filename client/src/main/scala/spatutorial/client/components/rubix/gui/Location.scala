package spatutorial.client.components.rubix.gui

import japgolly.scalajs.react.ReactElement
import spatutorial.client.components.rubix.example.loc.BlankPage

/**
 * Created by uenyioha on 1/3/16.
 */
object Location {

  sealed abstract class Page(val title: String, val routerPath: String,  val render : () => ReactElement,
                             val active: Boolean = false, val glyph : Option[String] = None,
                             val bundle : Option[String] = Some("fontello"))

  case object Lock extends Page("Lock Page", "#lock", () => BlankPage.content, glyph = Some("lock"))
  case object Blank extends Page("Blank Page", "#blank", () => BlankPage.content, active = true, glyph = Some("gauge"))
  case object Menu extends Page("Menu", "#menu", () => BlankPage.content, glyph = Some("lock"))
  case object Inbox extends Page("Inbox", "#inbox", () => BlankPage.content, glyph = Some("inbox"), bundle = Some("feather"))
  case object Mail extends Page("Mail", "#mail", () => BlankPage.content, glyph = Some("mail-open"), bundle = Some("outlined"))
  case object Compose extends Page("Compose", "#compose", () => BlankPage.content, glyph = Some("message"), bundle = Some("dripicons"))
  case object Home extends Page("Home Page", "#home", () => BlankPage.content, glyph = Some("message"), bundle = Some("dripicons"))


  val values = List[Page](
      Blank, Menu, Inbox, Mail, Compose, Lock
    )

  def default: Page = values.head

}
