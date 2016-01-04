package spatutorial.client.components.rubix.bootstrap

/**
  * Created by uenyioha on 12/27/15.
  */

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import org.querki.jquery._
import org.scalajs.dom
import org.scalajs.dom.raw.HTMLElement
import spatutorial.client.components.Modernizr
import spatutorial.client.components.rubix.gui.Dashboard
import spatutorial.client.components.rubix.gui.Location._
import spatutorial.client.services.{SidebarChangeState, AppCircuit, SidebarOpenState, SidebarRepositionState}

import scala.language.implicitConversions
import scala.scalajs.js

sealed trait SidebarEvent
case class SidebarControlBtnEvent(sidebar: Int) extends SidebarEvent { override def toString = "sidebar:controlbtn" }
case class SidebarKeyChangeEvent(sidebarKeyChangeValue: Int) extends SidebarEvent { override def toString = "sidebar:keychange" }
case class SidebarReinitializeEvent(params: AnyRef) extends SidebarEvent { override def toString = "sidebar:reinitialize" }
case class SidebarDestroyEvent(params: AnyRef) extends SidebarEvent { override def toString = "sidebar:destroy" }
case class SidebarRepositionEvent(repositionStatex: SidebarRepositionState) extends SidebarEvent { override def toString = "sidebar:reposition" }
case object SidebarUpdateEvent extends SidebarEvent { override def toString = "sidebar:update" }
case class SidebarOpenStateEvent(params: SidebarOpenState) extends SidebarEvent { override def toString = "sidebar:openstate" }
case class SidebarChangeStateEvent(open: Boolean) extends SidebarEvent { override def toString = "sidebar" }


@js.native
trait JQueryExtraFunctions extends JQuery {
  def perfectScrollbar(`object`: js.Any) : HTMLElement = js.native
  def animate(properties: js.Any, duration: js.Any = ???, easing: String = ???, complete: js.Function = ???): JQuery = js.native
}

object JQueryXtras {
  implicit def newFxns (jq: JQuery) : JQueryExtraFunctions  = jq.asInstanceOf[JQueryExtraFunctions]
}

object SidebarMixin {

  def openState = if (!Modernizr.touch)
                      if (dom.localStorage.getItem("sidebar-open-state") == "true")
                        true
                      else
                        false
                  else
                      false

  case class State(open: Boolean)

  case class Props(ComposedComponent : (Boolean) => ReactComponentU[Dashboard.Props, Unit, Unit, TopNode])

  class Backend($ : BackendScope[Props, State]) {

    def sidebarStateChangeCallback(state: State)(open: Boolean) = Callback {
      if (!isOpen(state)(open)) {

        $.modState(s => State(open = !s.open)).runNow()

        dom.localStorage.setItem("sidebar-open-state", s"$openState")
      }
    }.runNow()

    def isOpen(state: State)(open: Boolean) = {
      state.open == open
    }



    def render(props: Props, state: State) = {
      props.ComposedComponent(state.open)
    }
  }

  var sidebarOpenStateUnsubscribe : () => Unit = null

  val component = ReactComponentB[Props]("sidebar-mixin")
                  .initialState_P(props => State(openState))
                  .renderBackend[Backend]
                  .componentWillMount( f =>
                    Callback {
                      sidebarOpenStateUnsubscribe = AppCircuit.subscribe(() =>
                        f.backend.sidebarStateChangeCallback(f.state)(AppCircuit.zoom(_.ui.sidebar.changeState).value.open),
                                                                                                  _.ui.sidebar.changeState)
                    }
                  )
                  .componentWillUnmount( f => Callback {
                      sidebarOpenStateUnsubscribe()
                    }
                  ).build

  def apply(ComposedComponent : (Boolean) => ReactComponentU[Dashboard.Props, Unit, Unit, TopNode]) =
    component(Props(ComposedComponent))
}

object SidebarControls {

  case class Props(`class`: Option[String] = None, dir : Option[String] = None)

  val component = ReactComponentB[Props]("sidebar-controls")
                    .stateless
                    .render { $ =>
                      <.div(
                        ^.classSet1("sidebar-controls-container",
                          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
                        ),
                        ^.dir := "ltr",
                        <.div(
                          ^.`class` := "sidebar-controls",
                          ^.tabIndex := -1,
                          $.propsChildren
                        )
                      )
                    }.build

  def apply(`class`: Option[String] = None, dir : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, dir),
      children : _*)

}

object SidebarControlBtn {

  var unsubscribe : () => Unit = null

  case class Props(`class` : Option[String] = None, active: Boolean,
                   sidebar: Int, bundle : Option[String] = None,
                   glyph : Option[String] = None)

  case class State(active: Boolean, sidebar: AnyRef = Nil)

  class Backend($ : BackendScope[Props, State]) {

    def handleState(thisSidebar: Int)(clickedSidebar: Int) = {


      if (thisSidebar == clickedSidebar) {
        $.modState(s => s.copy(active = true)).runNow()
      }
      else {
        $.modState(s => s.copy(active = false)).runNow()
      }
    }

    def render(props: Props, state: State, propsChildren: PropsChildren) = {

      val handleClick = (e: ReactEvent) => Callback {
        e.preventDefault()
        e.stopPropagation()
        AppCircuit.dispatch(SidebarControlBtnEvent(props.sidebar))
        AppCircuit.dispatch(SidebarKeyChangeEvent(props.sidebar))
      }

      <.li(
        ^.tabIndex := -1,
        ^.classSet1("sidebar-control-btn",
          "active" -> state.active,
          props.`class`.getOrElse("") -> props.`class`.isDefined
        ),
        ^.onClick ==> handleClick,
        <.a(
          ^.href := "#",
          Icon(bundle = props.bundle, glyph = props.glyph)
        )
      )

    }

  }

  val component = ReactComponentB[Props]("sidebar-control-btn")
                    .initialState_P(props => State(props.active))
                    .renderBackend[Backend]
                    .componentDidMount { f => Callback {
                        unsubscribe = AppCircuit.subscribe(() =>
                          f.backend.handleState(f.props.sidebar)(AppCircuit.zoom(_.ui.sidebar.activeSidebar).value),
                                                                                      _.ui.sidebar.activeSidebar)
                        val scrollToTop = () => {
                          if ($(dom.window).scrollTop() != 0) {
                            dom.setTimeout( () => {
                                $("html, body, #body").scrollTop(0)
                                $(dom.window).scrollTop(0)
                              }, 15
                            )
                          }
                        }
                        scrollToTop()
                      }
                    }
                    .componentWillUnmount{ f => Callback {
                        unsubscribe()
                      }
                    }
                    .build

  def apply(`class` : Option[String] = None, active: Boolean = false,
            sidebar: Int, bundle : Option[String] = None,
            glyph : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})
                                    = component.set(key, ref)(Props(`class`, active, sidebar, bundle, glyph))
}

object Sidebar {

  var timer : Int = -1

  val sidebarRef = Ref[HTMLElement]("sidebar")
  val innerSidebarRef = Ref[HTMLElement]("innersidebar")

  var sidebarKeyChangeUnsubscribe : () => Unit = null
  var sidebarReinitializeUnsubscribe : () => Unit = null
  var sidebarDestroyScrollbarUnsubscribe : () => Unit = null
  var sidebarUpdateScrollbarUnsubscribe : () => Unit = null
  var sidebarRepositionScrollbarUnsubscribe : () => Unit = null


  case class Props(`class` : Option[String] = None, sidebar: Int, active: Boolean = false)

  case class State(left: Int, visibility : Option[String] = None)

  class Backend(b : BackendScope[Props, State]) {

    def handleKeyChange(thisProps: Props)(clickedSidebar: Int): Unit = {
      val newLeft = (thisProps.sidebar * 100) - (clickedSidebar * 100)

      b.setState(State(
        left = newLeft,
        visibility = Some("visible")
      ),
        cb = Callback {
          if (newLeft != 0) {
            dom.setTimeout(() => b.modState(s => s.copy(visibility = Some("hidden"))).runNow(), 300)
          } else {
            sidebarRef(b).foreach { x =>
              val height = $(x).height()
              if ($("html").hasClass("static")) {
                $("#body").css("min-height", height.toInt + 400)
              } else {
                $("#body").css("min-height", "")
              }
            }
          }
        }
      )
    }

    import JQueryXtras._

    def updateScrollbar() = {
      if (!Modernizr.touch) {
        sidebarRef(b).foreach((x: HTMLElement) => {
          $(x).perfectScrollbar("update")
        })
      }
    }

    def repositionScrollbar(rps: SidebarRepositionState) = {

        dom.clearTimeout(timer)

        sidebarRef(b).foreach { sidebarNode =>
          val scrollTo = rps.top - sidebarNode.offsetTop + sidebarNode.scrollTop

          if ($(sidebarNode).find(rps.child_node).length > 0) {
            if (scrollTo > $(dom.window).height() / 2) {
              timer = dom.setTimeout( () =>
                $(sidebarNode).scrollTop(scrollTo - ($(dom.window).height() / 2) + 100),
                15
              )
            }
          }

        if (!Modernizr.touch) {
          updateScrollbar()
        }
      }
    }

    def destroyScrollbar() = {
      sidebarRef(b).foreach(x => {
        $(x).perfectScrollbar("destroy")
      })
    }

    def initializeScrollbar() = {
      sidebarRef(b).foreach(x => {
        $(x).perfectScrollbar(
          Map("suppressScrollX" -> true)
        )
      })
    }

    def render(props: Props, state: State, children: PropsChildren) = {
      <.div(
        ^.ref := sidebarRef,
        ^.left := state.left.pct,
        ^.classSet1("sidebar",
          props.`class`.getOrElse("") -> props.`class`.isDefined
        ),
        ^.visibility := state.visibility,
        ^.transition := "all 0.3s ease",
        <.div(
          ^.ref := innerSidebarRef,
          children
        )
      )
    }

  }

  val component = ReactComponentB[Props]("sidebar")
                    .initialState_P(props => State( left = props.sidebar * 100,
                          visibility = Some(if (props.sidebar == 0) "visible" else "hidden")))
                    .renderBackend[Backend]
                    .componentWillMount(f =>
                      Callback {
                        sidebarReinitializeUnsubscribe = AppCircuit.subscribe(() =>
                          f.backend.initializeScrollbar()
                        )

                        sidebarDestroyScrollbarUnsubscribe = AppCircuit.subscribe(() =>
                          f.backend.destroyScrollbar()
                        )

                        sidebarUpdateScrollbarUnsubscribe = AppCircuit.subscribe(() =>
                          f.backend.updateScrollbar()
                        )

                        sidebarRepositionScrollbarUnsubscribe = AppCircuit.subscribe(() =>
                          f.backend.repositionScrollbar(AppCircuit.zoom(_.ui.sidebar.repositionState).value),
                          _.ui.sidebar.repositionState
                        )

                        sidebarKeyChangeUnsubscribe = AppCircuit.subscribe(() =>
                          f.backend.handleKeyChange(f.props)(AppCircuit.zoom(_.ui.sidebar.activeSidebar).value),
                          _.ui.sidebar.activeSidebar)
                      }
                    )
                    .componentDidMount(
                      f => Callback {
                        if(!Modernizr.touch)
                          f.backend.initializeScrollbar()

                        if(f.props.active) {
                          dom.setTimeout(
                            () => {
                              AppCircuit.dispatch(SidebarControlBtnEvent(f.props.sidebar))
                               AppCircuit.dispatch(SidebarKeyChangeEvent(f.props.sidebar))
                            }, 15
                          )
                        }
                      }
                    )
                    .componentWillUnmount(
                      f => Callback {
                        sidebarReinitializeUnsubscribe()
                        sidebarDestroyScrollbarUnsubscribe()
                        sidebarUpdateScrollbarUnsubscribe()
                        sidebarRepositionScrollbarUnsubscribe()
                        sidebarKeyChangeUnsubscribe()
                      }
                    )
                    .build

  def apply(`class` : Option[String] = None, sidebar: Int, active: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactElement*)
              = component.set(key, ref)(Props(`class`, sidebar, active), children : _*)

}

object SidebarNav {

  case class Props(`class`: Option[String] = None, mb: Option[Int] = None)

  val component = ReactComponentB[Props]("sidebar-nav")
                    .stateless
                    .render { $ =>
                      <.ul(
                        ^.classSet1( "sidebar-nav",
                          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
                        ),
                        ^.marginBottom := $.props.mb,
                        $.propsChildren
                      )
                    }
                    .build

  def apply(`class` : Option[String] = None, mb : Option[Int] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactElement*)
  = component.set(key, ref)(Props(`class`, mb), children : _*)

}

object SidebarBtn {

  case class Props(`class`: Option[String] = None)

  def handleSidebarStateChange(props: Props)() = {
    AppCircuit.dispatch(SidebarChangeStateEvent(open = !AppCircuit.zoom(_.ui.sidebar.changeState).value.open))
  }

  val component = ReactComponentB[Props]("sidebar-btn")
                    .stateless
                    .render { $ =>
                      NavContent($.props.`class`)(
                        Nav(onItemSelect = Some(() => Callback {handleSidebarStateChange($.props) }))(
                          NavItem(`class`=Some("sidebar-btn"), href = Some("/"), dataId=Some("sidebar-btn"),
                          onItemSelect = Some(() => Callback { handleSidebarStateChange($.props) })
                          )(
                            Icon( bundle=Some("fontello"), glyph=Some("th-list-5"))
                          )
                        )
                      )
                    }.build

  def apply(`class`: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})
  = component.set(key, ref)(Props(`class`))

}

/** new **/

object SidebarNavItem {

  var timer : Int = -1

  val nodeRef = Ref[HTMLElement]("sidebar")

  case class Props(`class`: Option[String] = None, open : Boolean = false, active : Boolean = false,
                   href : Option[String] = None, autoHeight : Boolean = false, name : Option[String] = None,
                   onClick : Option[() => Callback] = None, target: Option[Page],
                   glyph: Option[String] = None, bundle : Option[String] = None, routerCtl: RouterCtl[Page])

  case class State(open : Boolean, active : Boolean, toggleOpen : Boolean, dir: String, opposite: Boolean)

  class Backend(b : BackendScope[Props, State]) {

    def emitOpen(open: Boolean = false) = {
      nodeRef(b).foreach(n =>
        if (open)
          AppCircuit.dispatch(SidebarOpenState(n, open))
        else
          AppCircuit.dispatch(SidebarOpenState(n))
      )
    }

    def collapse(node: HTMLElement, cb: Callback) = {
      import JQueryXtras._

      b.modState(s => s.copy(toggleOpen = false), Callback {
        val height = $(node).height()
        $(node).css("height", height.toInt).animate(Map(
          height -> 45.px
        ), 125, "easeInOutSine", () => {
          $(node).css("height", "")
          b.modState(s => s.copy(open = false, toggleOpen = false), cb)
        })
      }
      ).runNow()
    }

    def expand(node: HTMLElement, cb: Callback, disableAnimation: Boolean = false) = {
      import JQueryXtras._

      if (disableAnimation) {
        $(node).css("height", "").addClass("open")
      } else {
        b.modState(s => s.copy(toggleOpen = true),
          Callback {
            val height = $(node).addClass("open").height()
            $(node).removeClass("open")
            $(node).css("height", 45.px).animate(
              Map("height" -> height), 125, "easeInOutSine", () => {
                $(node).css("height", "")
                b.modState(s => s.copy(open = false, toggleOpen = false), cb)
              }
            )
          }
        ).runNow()
      }
    }

    def handleOpenState(state: State)(os: SidebarOpenState): Unit = {
        dom.clearTimeout(timer)
        timer = dom.setTimeout(handler = () =>
          nodeRef(b).foreach { n =>
            if (os != null && os.open) {
              if (os != null && $(n).find(os.child_node).length > 0) {
                b.modState(s => s.copy(open = true, toggleOpen = true)).runNow()
                expand(n, Callback(
                  AppCircuit.dispatch(SidebarUpdateEvent)
                ), disableAnimation = true)
              }
              return
            }
            if (os != null && $(n).is(os.child_node)) {
              if (state.open) {
                collapse(n, Callback(AppCircuit.dispatch(SidebarUpdateEvent)))
              } else {
                expand(n, Callback(AppCircuit.dispatch(SidebarUpdateEvent)))
              }
              return
            }
            if (os != null && $(n).find(os.child_node).length == 0) {
              if (state.open)
                collapse(n, Callback.empty)
            }
          },
          timeout = 15)
    }

    def handleLayoutDirChange(dir: String) = {
        b.modState(s => s.copy(
          dir = if (dir == "ltr") "left" else "right",
          opposite = if (dir == "ltr") false else true
        )).runNow()
    }

    def activateNavItem(props: Props): Unit = {
      if (props.active) {
        emitOpen(true)
        dom.setTimeout( () => {
          b.modState(s => s.copy(active = true)).runNow()
          nodeRef(b).foreach { n =>
            val height = $(n).height()
            val top = $(n).offset().top
            AppCircuit.dispatch(SidebarRepositionEvent(SidebarRepositionState(n, top, height)))
          }
        },
          15
        )
      } else {
        b.modState(s => s.copy(active = false)).runNow()
      }
    }

    def render(props: Props, state: State, children: PropsChildren) = {

      def handleClick = (e: ReactEvent) =>
        e.preventDefaultCB >>
          e.stopPropagationCB >>
          Callback {
            props.onClick.foreach(fn => fn().runNow())
            emitOpen()
          }

        val openString = if (state.open) "open" else ""
        val oppositeString = if (state.opposite) "opposite" else ""

        val toggleButtonClasses = s"toggle-button $openString $oppositeString".trim

        var toggleButton : ReactComponentU[Icon.Props, Unit, Unit, TopNode]  = null

        if (React.Children.toArray(children).length > 0) {
          toggleButton = Icon(`class` = Some(toggleButtonClasses), bundle = Some("fontello"), glyph =
            Some(s"${state.dir}-open-3"))
        }

        var icon : ReactComponentU[Icon.Props, Unit, Unit, TopNode] = null

        if (props.glyph.isDefined && props.bundle.isDefined) {
          icon = Icon(bundle = props.bundle, glyph = props.glyph)
        }

        val nameString = props.name.getOrElse("")

        <.li(
          ^.ref := nodeRef,
          props.autoHeight ?= (^.height := "auto"),
          ^.name := props.name,
          ^.tabIndex := -1,
          ^.classSet(
            "open" -> state.open,
            "active" -> state.active,
            props.`class`.getOrElse("") -> props.`class`.isDefined
          ),
          if (props.target.isDefined) {
            <.a(
              ^.tabIndex := -1,
              ^.href := props.href,
              props.routerCtl setOnClick props.target.get,
              props.autoHeight ?= (^.height := "auto"),
              icon,
              <.span(^.`class` := "name", nameString),
              toggleButton
            )
          } else {
              <.a(
                ^.tabIndex := -1,
                ^.href := props.href,
                ^.onClick ==> handleClick,
                props.autoHeight ?= (^.height := "auto"),
                icon,
                <.span(^.`class` := "name", nameString),
                toggleButton
              )
          },
          children
        )
    }
  }

  var sidebarHandleLayoutChangeUnsubscribe : () => Unit = null
  var sidebarOpenStateUnsubscribe : () => Unit = null

  val component = ReactComponentB[Props]("sidebar-nav-item")
                    .initialState_P(props =>
                      State(
                        open = props.open,
                        active = props.active,
                        toggleOpen = props.active,
                        dir = "left",
                        opposite = false
                      )
                    )
                    .renderBackend[Backend]
                    .componentWillReceiveProps( f => Callback {
                      f.$.backend.activateNavItem(f.nextProps)
                    })
                    .componentWillMount(f => Callback {
                        sidebarHandleLayoutChangeUnsubscribe = AppCircuit.subscribe( () =>
                            f.backend.handleLayoutDirChange(AppCircuit.zoom(_.ui.sidebar.layoutDir).value),
                            _.ui.sidebar.layoutDir
                          )
                        sidebarOpenStateUnsubscribe = AppCircuit.subscribe( () => {
                            val openState = AppCircuit.zoom(_.ui.sidebar.openState).value
                            f.backend.handleOpenState(f.state)(openState)
                          }
                        )
                      }
                    )
                    .componentDidMount(f => Callback {
                        f.backend.activateNavItem(f.props)
                      }
                    )
                    .componentWillUnmount(f =>
                      Callback {
                        sidebarHandleLayoutChangeUnsubscribe()
                        sidebarOpenStateUnsubscribe()
                      }
                    )
                    .build

  def apply(`class`: Option[String] = None, open : Boolean = false, active : Boolean = false,
            href : Option[String] = None, autoHeight : Boolean = false, name : Option[String] = None,
            onClick : Option[() => Callback] = None, target: Option[Page],
            glyph: Option[String] = None, bundle : Option[String] = None, routerCtl: RouterCtl[Page] = null,
            ref: js.UndefOr[String] = "", key: js.Any = {})
           (children: ReactElement*) = component.set(key, ref)(Props(`class`, open, active,
                                          href, autoHeight, name,onClick, target,
                                          glyph, bundle, routerCtl), children :_*)

}