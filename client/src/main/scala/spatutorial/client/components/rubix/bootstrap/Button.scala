package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.ClassNameAttr
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.Attr
import spatutorial.client.components.rubix.bootstrap.common.ButtonClasses
import spatutorial.client.components.rubix.bootstrap.common.ButtonClasses.ButtonClass

import scala.scalajs.js


/**
  * Created by uenyioha on 12/10/15.
  */
object Button {
  case class Props(`class`: Option[String] = None, xsBtn : Boolean = false, smBtn : Boolean = false,
                   lgBtn : Boolean = false, blockBtn : Boolean = false, navBarBtn : Boolean = false,
                   inverseBtn : Boolean = false, roundedBtn : Boolean = false, outlinedBtn : Boolean = false,
                   bStyle: Option[String] = None, active : Boolean = false, onlyOnHover: Boolean = false,
                   retainBackground : Boolean = false, close: Boolean = false, `type` : Option[String] = None,
                   dToggle: Option[String] = None, onClick : Option[(ReactEvent) => Callback] = None,
                   onTouchEnd : Option[(ReactEvent) => Callback] = None)

  val component = ReactComponentB[Props]("Button")
    .stateless
    .render { $ =>

      val buttonClassString = if ($.props.close) ^.classSet1("close")
                              else ButtonClasses.genClasses(xsBtn = $.props.xsBtn, smBtn = $.props.smBtn,
                                    lgBtn = $.props.lgBtn, blockBtn = $.props.blockBtn, navBarBtn = $.props.navBarBtn,
                                    inverseBtn = $.props.inverseBtn, roundedBtn = $.props.roundedBtn,
                                    outlinedBtn = $.props.outlinedBtn, bStyle = $.props.bStyle, active = $.props.active,
                                    onlyOnHover = $.props.onlyOnHover, retainBackground = $.props.retainBackground)
      if ($.props.close)
        <.button(
          ^.role := "button",
          ^.`type` := $.props.`type`,
          buttonClassString + ^.classSet($.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
          dataToggle := $.props.dToggle,
          $.props.onClick.isDefined ?= ^.onClick ==> $.props.onClick.get,
          $.props.onTouchEnd.isDefined ?= ^.onTouchEnd ==> $.props.onTouchEnd.get,
          <.span( <.span( ^.aria.hidden := true, "×"), <.span( ^.`class` := "sr-only", "Close"))
        )
      else
        <.button(
          ^.role := "button",
          ^.`type` := $.props.`type`,
          buttonClassString + ^.classSet($.props.`class`.getOrElse("") -> $.props.`class`.isDefined),
          dataToggle := $.props.dToggle,
          $.props.onClick.isDefined ?= ^.onClick ==> $.props.onClick.get,
          $.props.onTouchEnd.isDefined ?= ^.onTouchEnd ==> $.props.onTouchEnd.get,
          $.propsChildren
        )
    }
    .build

  def apply(`class`: Option[String] = None, xsBtn : Boolean = false, smBtn : Boolean = false, lgBtn : Boolean = false,
            blockBtn : Boolean = false, navBarBtn : Boolean = false, inverseBtn : Boolean = false,
            roundedBtn : Boolean = false, outlinedBtn : Boolean = false, bStyle: Option[String] = None,
            active : Boolean = false, onlyOnHover: Boolean = false, retainBackground : Boolean = false,
            close: Boolean = false, `type` : Option[String] = None, dToggle: Option[String] = None,
            onClick : Option[(ReactEvent) => Callback] = None, onTouchEnd : Option[(ReactEvent) => Callback] = None,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, xsBtn, smBtn, lgBtn, blockBtn, navBarBtn, inverseBtn,
                                roundedBtn, outlinedBtn, bStyle, active, onlyOnHover, retainBackground, close,
                                `type`, dToggle, onClick, onTouchEnd), children: _*)

}
