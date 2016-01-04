package com.usableapps.components.rubix.gui

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import com.usableapps.components.rubix.bootstrap._
import com.usableapps.components.rubix.gui.Location._

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
                                    HeaderNavigation(router = $.props.router)
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
