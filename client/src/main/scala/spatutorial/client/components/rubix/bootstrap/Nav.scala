package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._, vdom.prefix_<^._


import scala.collection.mutable
import scala.scalajs.js

/**
  * Created by uenyioha on 12/13/15.
  */

object Nav {

  case class Props(`class`: Option[String] = None, id: Option[String] = None,
                   left : Boolean = false, right : Boolean = false,
                   onItemSelect : Option[() => Callback] = None, role: Option[String])

  class Backend($: BackendScope[Props, String]) {

    def render(props: Props, state: String, children: PropsChildren) = {
      navs -= state

      val rChildren = React.Children.toArray(children).map((n : ReactNode) =>
        React.cloneElement(n.asInstanceOf[ReactDOMElement],
          Map("on-item-select" -> props.onItemSelect, "nav-id" -> state))
      )

      <.ul(
        ^.classSet1( "nav navbar-nav",
          props.`class`.getOrElse("") -> props.`class`.isDefined
        ),
        ^.role := props.role,
        rChildren
      )
    }
  }

  val component = ReactComponentB[Props]("Nav")
    .initialState_P(f => f.id.getOrElse(increaseGlobalId().toString))
    .renderBackend[Backend]
    .componentWillUnmount(scope => Callback { navs -= scope.state })
    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None,
            left : Boolean = false, right : Boolean = false,
            onItemSelect : Option[() => Callback] = None, role: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id, left, right, onItemSelect, role), children : _*)
}

object NavButton {
  case class Props(`class`: Option[String] = None, role : Option[String] = None,
                   left: Boolean = false, right : Boolean = false)

  val component = ReactComponentB[Props]("NavButton")
                      .stateless
                      .render { $ =>

                        val leftString = if ($.props.left) "navbar-left " else ""
                        val rightString = if ($.props.right) "navbar-right " else ""
                        val classString = $.props.`class`.getOrElse("")

                        Button(`class` = Some(s"$leftString $rightString $classString".trim))(<.div($.propsChildren))
                      }
                      .build

  def apply(`class`: Option[String], role: Option[String] = None,
            left: Boolean = false, right : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, role, left, right), children : _*)}

object NavLink {

  case class Props(`class`: Option[String] = None, role : Option[String] = None,
                   left: Boolean = false, right : Boolean = false)

  val component = ReactComponentB[Props]("NavLink")
                    .stateless
                    .render { $ =>

                      val leftString = if ($.props.left) "navbar-left " else ""
                      val rightString = if ($.props.right) "navbar-right " else ""
                      val classString = $.props.`class`.getOrElse("")

                      val roleString = $.props.role.getOrElse("")

                      <.a(
                        ^.`class` := s"navbar-link $leftString $rightString $classString".trim,
                        ^.role := roleString,
                        $.propsChildren
                      )
                    }.build

  def apply(`class`: Option[String], role: Option[String] = None,
            left: Boolean = false, right : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, role, left, right), children : _*)

}

object NavText {
  case class Props(`class`: Option[String] = None, role : Option[String] = None,
                   left: Boolean = false, right : Boolean = false)

  val component = ReactComponentB[Props]("NavText")
    .stateless
    .render { $ =>

      val leftString = if ($.props.left) "navbar-left " else ""
      val rightString = if ($.props.right) "navbar-right " else ""
      val classString = $.props.`class`.getOrElse("")

      val roleString = $.props.role.getOrElse("")

      <.p(
        ^.`class` := s"nav-text $leftString $rightString $classString".trim,
        ^.role := roleString,
        $.propsChildren
      )
    }.build

  def apply(`class`: Option[String], role: Option[String] = None,
            left: Boolean = false, right : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, role, left, right), children : _*)
}

object NavForm {
  case class Props(`class`: Option[String], role: Option[String] = None,
                   left: Boolean = false, right : Boolean = false)

  val component = ReactComponentB[Props]("NavForm")
    .stateless
    .render { $ =>

      val leftString = if ($.props.left) "navbar-left " else ""
      val rightString = if ($.props.right) "navbar-right " else ""

      Form(Some(s"navbar-form form-inline $leftString $rightString".trim),
        role = $.props.role)(<.div($.propsChildren))
    }
    .build

  def apply(`class`: Option[String], role: Option[String] = None,
            left: Boolean = false, right : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, role, left, right), children : _*)
}

object NavToggle {

  case class Props(`class`: Option[String] = None, target: Option[String] = None)

  class Backend($: BackendScope[Props, Unit]) {

    def toggleNavContentsEvent(target: String)(e: ReactEvent) = {
      e.preventDefaultCB >>
        Callback(
          navContents += (target -> !navContents.getOrElse(target, true)) // starting default is false
        )
      }

    def render(props: Props, state : Unit, children : PropsChildren) = {

      if (props.target.isEmpty) throw new IllegalArgumentException("""No target property set for NavToggle. Please refer to Navbar documentation."""")

      val targetString = props.target.get

      val nChildren = <.span(
        <.span(^.classSet1("sr-only"),children),
        <.span(^.classSet1("icon-bar")),
        <.span(^.classSet1("icon-bar")),
        <.span(^.classSet1("icon-bar"))
      )

      Button(
          `class` = Some(s"navbar-toggle ${props.`class`.getOrElse("")}"),
          dToggle = Some("collapse"),
          onClick = Some(toggleNavContentsEvent(targetString)),
          onTouchEnd = Some(toggleNavContentsEvent(targetString))
      )(nChildren)
    }
  }

  val component = ReactComponentB[Props]("NavToggle")
    .stateless
    .renderBackend[Backend]
    .build

  def apply(`class`: Option[String] = None, target: Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, target), children : _*)

}

object NavItem {

  case class Props(`class`: Option[String] = None, id: Option[String] = None, dataId : Option[String] = None,
                   navId: Option[String] = None, divider: Boolean = false, dropDown: Boolean = false,
                   active : Boolean = false, href : Option[String] = None,
                   toggleOnHover : Option[(ReactEvent) => Callback] = None,
                   onClick : Option[() => Callback] = None, onTouchEnd : Option[() => Callback] = None,
                   onItemSelect : Option[() => Callback] = None)

  class Backend($: BackendScope[Props, String]) {

    def render(props: Props, state: String, children: PropsChildren) = {

      val navId = props.navId.getOrElse("")

      val dividerTag = <.li(
        ^.classSet1("divider") + props.`class`
      )

      if (props.divider)
        dividerTag
      else {
        val onShownEvent = () => { Callback( navs += { navId -> mutable.Map(state -> true)} ) }
        val onHiddenEvent = () => { Callback( navs += { navId -> mutable.Map(state -> false)} ) }

        val combinedClasses = ^.classSet1(props.`class`.getOrElse(""),
                                          "dropdown" -> props.dropDown,
                                          "active" -> props.active)

        val handleClickEvent = (e: ReactEvent) => { e.preventDefaultCB >> Callback {
                                                      navs.updated(navId, navs.getOrElse(navId, false))
                                                          .map{ case (key, value) => (key, false) } //deactivate-nav-items
                                                      navs.getOrElseUpdate(navId, mutable.Map("active" -> false))
                                                      props.onClick.foreach(fn => fn().runNow())
                                                      props.onTouchEnd.foreach(fn => fn().runNow())
                                                      props.onItemSelect.foreach(fn => fn().runNow())
                                                   } }



        val childrenArray = if (props.dropDown)
          React.Children.toArray(children).map((n: ReactNode) =>
            React.cloneElement(n.asInstanceOf[ReactElement],
              Map("dropdown" -> props.id,
                "toggleOnHover" -> props.toggleOnHover.orNull,
                "onShown" -> onShownEvent,
                "onHidden" -> onHiddenEvent,
                "key" -> scala.util.Random.nextInt())))
        else React.Children.toArray(children)

        if (props.href.isDefined)
          <.li(
            combinedClasses,
            <.a(
              ^.href := props.href.getOrElse("#"),
              ^.onClick ==> handleClickEvent,
              ^.onTouchEnd ==> handleClickEvent,
              childrenArray
            )
          )
        else
          <.li(
            combinedClasses,
            childrenArray
          )
      }
    }
  }

  val component = ReactComponentB[Props]("NavItem")
    .initialState_P(f => f.id.getOrElse(increaseGlobalId().toString) )
    .renderBackend[Backend]
    .componentWillUnmount(scope => Callback { val navId = scope.props.navId.getOrElse("") ; navs(navId) -= scope.state })
    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None, dataId : Option[String] = None,
            navId: Option[String] = None, divider: Boolean = false, dropDown: Boolean = false,
            active : Boolean = false, href : Option[String] = None,
            toggleOnHover : Option[(ReactEvent) => Callback] = None,
            onClick : Option[() => Callback] = None, onTouchEnd : Option[() => Callback] = None,
            onItemSelect : Option[() => Callback] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id, dataId, navId, divider, dropDown, active, href, toggleOnHover,
                              onClick, onTouchEnd, onItemSelect), children : _*)
}


object NavContent {

  case class Props(`class`: Option[String] = None, id: Option[String], collapse: Boolean = false)

  class Backend($ : BackendScope[Props, String]) {

    def render(props: Props, state: String, children: PropsChildren) = {

      <.div(
        ^.classSet1("navbar-content",
          "collapse navbar-collapse" -> navContents.getOrElse(state, false), // starting default is false if not present
          props.`class`.getOrElse("") -> props.`class`.isDefined
        ),
        children
      )
    }
  }

  val component = ReactComponentB[Props]("NavContent")
    .initialState_P(p => p.id.getOrElse(increaseGlobalId().toString))
    .renderBackend[Backend]
    .componentWillUnmount(scope => Callback { navContents -= scope.state })
    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None, collapse: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id, collapse), children : _*)

}

object NavBrand {
  case class Props(`class`: Option[String] = None, href: Option[String] = None, tabIndex: Option[Int])

  val component = ReactComponentB[Props]("NavBrand")
    .stateless
    .render { $ =>
      <.div(
        ^.classSet1("navbar-brand",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        ^.href := $.props.href.getOrElse("#"),
        ^.tabIndex := $.props.tabIndex,
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None, href: Option[String] = None, tabIndex: Option[Int] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, href, tabIndex), children : _*)}

object NavHeader {

  case class Props(`class`: Option[String] = None)

  val component = ReactComponentB[Props]("NavHeader")
    .stateless
    .render { $ =>
      <.div(
        ^.classSet1("navbar-header",
          $.props.`class`.getOrElse("") -> $.props.`class`.isDefined
        ),
        $.propsChildren
      )
    }
    .build

  def apply(`class`: Option[String] = None,
            key : js.Any = {}, ref : js.UndefOr[String] = "")(children: ReactElement*)
  = component(Props(`class`), children : _*)

}

object NavBar {

  case class Props(id: Option[String] = None,
                   inverse: Boolean = false, fixedTop : Boolean = false, staticTop : Boolean = false,
                    fixedBottom : Boolean = false, style : Option[String] = None)

  class Backend($ : BackendScope[Props, Int]) {

    def render(props: Props, state: Int, children: PropsChildren) = {
      <.nav(
        ^.id := props.id,
        ^.classSet1(
          "navbar navbar-default",
          "navbar-inverse" -> props.inverse,
          "navbar-fixed-top" -> props.fixedTop,
          "navbar-static-top" -> props.staticTop,
          "navbar-fixed-bottom" -> props.fixedBottom
        ),
        ^.role := "navigation",
        ^.style := props.style,
        ^.zIndex := state,
        children
      )
    }
  }

  val component = ReactComponentB[Props]("NavBar")
    .initialState(decreaseZIndex())
    .renderBackend[Backend]
    .build

  def apply(id: Option[String] = None,
            `class`: Option[String] = None,inverse: Boolean = false, fixedTop : Boolean = false,
            staticTop : Boolean = false,
            fixedBottom : Boolean = false, style : Option[String] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(id, inverse, fixedTop, staticTop,fixedBottom, style), children : _*)
}