package spatutorial.client.components.rubix.gui

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import spatutorial.client.SPAMain
import spatutorial.client.components.rubix.bootstrap._
import spatutorial.client.components.rubix.gui.Location._


/**
 * Created by uenyioha on 1/2/16.
 */
object Dashboard {

  case class Props(router: RouterCtl[Page], page: Page, open: Boolean = true, `class` : Option[String] = None)

  val component = ReactComponentB[Props]("Dashboard")
    .render { $ =>
      val openString = if ($.props.open) "container-open" else ""

      Container(id = Some("container"), `class` = Some(openString))(
        <.div(^.id := "sidebar",
          Avatar($.props.router),
          SidebarControls()(
            SidebarControlBtn(bundle = Some("fontello"), glyph = Some("docs"), sidebar = 0),
            SidebarControlBtn(bundle = Some("fontello"), glyph = Some("chat-1"), sidebar = 1),
            SidebarControlBtn(bundle = Some("fontello"), glyph = Some("chart-pie-2"), sidebar = 2),
            SidebarControlBtn(bundle = Some("fontello"), glyph = Some("th-list-2"), sidebar = 3),
            SidebarControlBtn(bundle = Some("fontello"), glyph = Some("bell-5"), sidebar = 4)
          ),
          SidebarBar($.props.router, $.props.page)
        ),
        Header($.props.router),
        Body($.props.router, $.props.page),
        Footer($.props.router)
      )
    }
    .build

  def apply(router: RouterCtl[Page], page: Page, `class` : Option[String] = None)(open: Boolean = true) = component(Props(router, page, open, `class`))
}

object Avatar {

  case class Props(router: RouterCtl[Page])

  val component = ReactComponentB[Props]("avatar")
    .render { p =>
      <.div(^.id := "avatar",
        Grid()(
          Row(`class` = Some("fg-white"))(
            Col(xs = 4, collapseRight = true)(
              <.img(
                ^.src := "/imgs/avatars/avatar0.png",
                ^.width := 40,
                ^.height := 40
              )
            ),
            Col(xs = 8, collapseLeft =  true, id = Some("avatar-col"))(
              <.div(
                ^.top:= 23, ^.fontSize := 16, ^.lineHeight := 1, ^.position := "relative",
                "Ugo Enyioha"
              ),
              <.div(
                Progress(id = Some("demo-progress"), value = 30, min = 0, max = 100, maybeColor = Some("#ffffff")),
                <.div(p.props.router.link(Blank)(
                  Icon(id = Some("demo-icon"), bundle=Some("fontello"), glyph=Some("lock-5"))
                ))
              )
            )
          )
        )
      )
    }.build

  def apply(router : RouterCtl[Page]) = component(Props(router))

}

object SidebarBar {

  case class Props(router: RouterCtl[Page], page: Page)

  val menu = ReactComponentB[Props]("sidebar-menu")
    .render_P { props =>
      def menuItem(l: Page) = {
        SidebarNavItem(name = Some(l.title),
          bundle = l.bundle, glyph = l.glyph, href = Some(l.routerPath),
          active = l == props.page, routerCtl = props.router, target = Some(l)
        )()
      }

      Sidebar(sidebar = 0, active = true )(
        <.div(^.`class` := "sidebar-nav-container",
          SidebarNav(mb = Some(0))(
            Location.values map menuItem : _*
          )
        )
      )
    }
    .build

  val component = ReactComponentB[Props]("sidebar-bar")
    .render_P { props =>
      <.div(
        ^.id := "sidebar-container",
        <.div(
          Grid()(
            Row()(
              Col(xs = 12)(
                <.div(^.`class` := "sidebar-header", "PAGES"),
                menu(props)
              )
            )
          )
        )
      )
    }.build

  def apply(router : RouterCtl[Page], page: Page) = component(Props(router, page))

}

object Body {

  case class Props(router: RouterCtl[Page], page: Page)

  val component = ReactComponentB[Props]("sidebar-bar")
    .render_P { props =>
      props.page.render()
    }.build

  def apply(router : RouterCtl[Page], page: Page) = component(Props(router, page))

}