package com.usableapps.components.rubix.gui

import japgolly.scalajs.react.ReactElement
import com.usableapps.components.rubix.example.loc.BlankPage

/**
 * Created by uenyioha on 1/3/16.
 */
object Location {

  sealed abstract class Page(val title: String, val routerPath: String,  val render : () => ReactElement,
                             val active: Boolean = false, val glyph : Option[String] = None,
                             val bundle : Option[String] = Some("fontello"))

  case object Dashboard extends Page("Dashboard", "#dashboard", () => BlankPage.content, active = true, glyph = Some("gauge"))
  case object Customers extends Page("Customers", "#customers", () => BlankPage.content, glyph = Some("lock"))
  case object Payments extends Page("Payments", "#payments", () => BlankPage.content, glyph = Some("inbox"), bundle = Some("feather"))
  case object Transfers extends Page("Transfers", "#mail", () => BlankPage.content, glyph = Some("mail-open"), bundle = Some("outlined"))
  case object Balance extends Page("Balance", "#balance", () => BlankPage.content, glyph = Some("message"), bundle = Some("dripicons"))


  val values = List[Page](
      Dashboard, Customers, Payments, Transfers, Balance
    )

  def default: Page = values.head

}
