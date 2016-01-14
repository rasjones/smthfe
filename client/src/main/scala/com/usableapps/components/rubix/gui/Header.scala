package com.usableapps.components.rubix.gui

import com.smoothpay.client.location.Location.Page
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import com.usableapps.components.rubix.bootstrap._

/**
  * Created by uenyioha on 12/26/15.
  */

object Brand {

  case class Props(router: RouterCtl[Page])

  val component = ReactComponentB[Props]("brand")
                    .stateless
                    .render { $ =>
                      NavHeader()(
                        NavBrand(tabIndex = Some(-1))(
                          <.img(
                            ^.src := "/imgs/logo.png",
                            ^.alt := "rubix",
                            ^.width := 111,
                            ^.height := 28.px
                          )
                        )
                      )
                    }.build

  def apply(router : RouterCtl[Page]) = component(Props(router))
}

object HeaderNavigation {

  case class Props(`class` : Option[String] = None, router: RouterCtl[Page])

  var component = ReactComponentB[Props]("header-navigation")
    .stateless
    .render { $ =>

      val combinedClasses = (for {
        str1 <- $.props.`class`
        str2 <- Some("pull-right")
      } yield str1 + str2).getOrElse("pull-right")

      NavContent(`class` = Some(combinedClasses))(
        Nav()(
          NavItem(`class` = Some("logout"), href = Some("#"))(
            Icon(bundle = Some("fontello"), glyph = Some("off-1"))
          )
        )
      )
    }.build

  def apply(`class` : Option[String] = None,router : RouterCtl[Page]) =
                component(Props(`class`, router))
}

object Header {
  case class Props(router: RouterCtl[Page])

  var component = ReactComponentB[Props]("header")
                    .stateless
                    .render { $ =>
                      Grid(id = Some("navbar"))(
                        Row()(
                          Col(xs = 12)(
                            NavBar(fixedTop = true, id = Some("rubix-nav-header"))(
                              Container(fluid = true)(
                                Row()(
                                  Col(xs = 3, visible = Some("xs"))(
                                    SidebarBtn()
                                  ),
                                  Col(xs = 6, sm = 4)(
                                    Brand($.props.router)
                                  ),
                                  Col(xs = 3, sm = 8)(
                                    SmoothHeaderNavigation(router = $.props.router)
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    }.build

  def apply(router : RouterCtl[Page]) = component(Props(router))

}

object SmoothHeaderNavigation {

  case class Props(`class` : Option[String] = None, router: RouterCtl[Page])

  var component = ReactComponentB[Props]("header-navigation")
                    .stateless
                    .render { $ =>
                      NavContent(`class` = Some("pull-right"))(
                        Nav(`class` = Some("hidden-xs"))(
                          NavItem( divider = true)(),
                          DirectNavItem(glyph = Some("user-male"), path = Some("/app/profile")),
                          DirectNavItem(glyph = Some("cog-7"), path = Some("/app/config")),
                          NavItem( divider = true)(),
                          DirectNavItem(),
                          NavItem( divider = true)(),
                          NavItem(href = Some("/app/profile"))(
                            Icon(bundle = Some("fontello"), glyph = Some("bullhorn")),
                            Badge(`class` = Some("badge-default fg-darkbrown bg-orange notification-badge"))(<.span("4"))
                          ),
//                          DirectNavItem(glyph = Some("bullhorn"), path = Some("/app/profile")),
                          NavItem( divider = true)(),
                          DirectNavItem(),
                          NavItem(`class` = Some("logout"), href = Some("#"))(
                            Icon(bundle = Some("fontello"), glyph = Some("off-1"))
                          )
                        )
                      )
                    }
                    .build

  def apply(`class` : Option[String] = None,router : RouterCtl[Page]) =
    component(Props(`class`, router))
}

object DirectNavItem {

  case class Props(path : Option[String] = None, bundle : Option[String], glyph : Option[String])

  var component = ReactComponentB[Props]("direct-nav-item")
                    .stateless
                    .render { $ =>
                      NavItem(href = Some("/app/social"))(
                        Icon(bundle = $.props.bundle orElse Some("fontello"), glyph = $.props.glyph)
                      )
                    }.build

  def apply(path : Option[String] = None, bundle : Option[String] = None, glyph : Option[String] = None) =
    component(Props(path, bundle, glyph))

}