package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.UndefOr

/**
  * Created by uenyioha on 12/10/15.
  */
object ButtonGroup {

  sealed trait ButtonGroupClass
  case class VerticalButtonGroup() extends ButtonGroupClass
  case class LargeButtonGroup() extends ButtonGroupClass
  case class SmallButtonGroup() extends  ButtonGroupClass
  case class XtraSmallButtonGroup() extends ButtonGroupClass
  case class JustifiedButtonGroup() extends ButtonGroupClass

  case class Props(`class`: Option[String] = None, id: Option[String] = None,
                   onSetSelectItem: (ReactEvent) => Callback,
                    btnGroup : Boolean = false, btnGroupVertical : Boolean = false,
                    btnGroupLarge: Boolean = false, btnGroupSmall : Boolean = false,
                    btnGroupXtraSmall : Boolean = false, btnGroupJustified : Boolean = false,
                    dropUp : Boolean = false,
                    dropDown : Boolean = false, toggleOnHover: Boolean = false)

  class Backend($: BackendScope[Props, String]) {

    def render(props: Props, state: String, propsChildren: PropsChildren) = {

      val children= React.Children.map ( propsChildren,
        (child: ReactNode, key: Int) => React.cloneElement(child.asInstanceOf[ReactElement],
                                Map("dropdown" -> state,
                                    "toggleOnHover" -> props.toggleOnHover,
                                    "onDropdownSetSelectItem" -> props.onSetSelectItem,
                                    "key" -> key)))

        <.div(
          ^.classSet(
            "btn-group" -> props.btnGroup,
            "btn-group-vertical" -> props.btnGroupVertical,
            "btn-group-lg" -> props.btnGroupLarge,
            "btn-group-sm" -> props.btnGroupSmall,
            "btn-group-xs" -> props.btnGroupXtraSmall,
            "btn-group-justified" -> props.btnGroupJustified,
            "dropup" -> props.dropUp,
            "dropdown" -> props.dropDown
          ),
          children.asInstanceOf[js.Array[ReactNode]]
        )
      }

  }

  val component = ReactComponentB[Props]("ButtonGroup")
                    .initialState_P(p => p.id.getOrElse(increaseGlobalId().toString))
                    .renderBackend[Backend]
                    .build

  def apply(`class`: Option[String] = None, id: Option[String] = None, onSetSelectItem: (ReactEvent) => Callback,
              btnGroup : Boolean = false, btnGroupVertical : Boolean = false,
              btnGroupLarge: Boolean = false, btnGroupSmall : Boolean = false,
              btnGroupXtraSmall : Boolean = false, btnGroupJustified : Boolean = false,
              dropUp : Boolean = false,
              dropDown : Boolean = false, toggleOnHover: Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id, onSetSelectItem,
                                btnGroup, btnGroupVertical,
                                btnGroupLarge, btnGroupSmall,
                                btnGroupXtraSmall, btnGroupJustified,
                                dropUp,
                                dropDown, toggleOnHover), children: _*)

}
