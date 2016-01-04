package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.ReactComponentB
import spatutorial.client.components.rubix.bootstrap.common.ButtonClasses
import spatutorial.client.components.rubix.bootstrap.common.ButtonClasses._

import scala.scalajs.js

/**
  * Created by uenyioha on 12/12/15.
  */
object Input {

  case class Props(`class`: Option[String] = None, smallInput : Boolean = false, largeInput : Boolean = false,
                   formControl: Boolean = false, bStyle: Option[String] = None, `type`: Option[String] = None,
                   active : Boolean = false, onlyOnHover: Boolean = false, inverse: Boolean = false,
                   outlined: Boolean = false, retainBackground : Boolean = false)


  val component = ReactComponentB[Props]("Input")
    .stateless
    .render { $ =>

      val buttonTypes = Set("button", "reset", "submit")
      val formControlTypes = Set("tel","url","date","time","week","text","color","month",
                                        "email","number","search","password","datetime","datetime-local")

      val typeClassString = $.props.`type`.getOrElse("")

      val buttonClassSet = if (buttonTypes.contains(typeClassString))
                                  ButtonClasses.genClasses(bStyle = $.props.bStyle,
                                    active = $.props.active, onlyOnHover = $.props.onlyOnHover,
                                    inverseBtn = $.props.inverse, outlinedBtn = $.props.outlined,
                                    retainBackground = $.props.retainBackground)
                              else
                                  ^.classSet(
                                    $.props.`class`.getOrElse("") -> $.props.`class`.isDefined,
                                    "input-sm" -> $.props.smallInput,
                                    "input-lg" -> $.props.largeInput,
                                    "form-control" -> formControlTypes.contains(typeClassString)
                                  )

      <.input(
        ^.ref := "input",
        buttonClassSet
      )
    }
    .build

    def apply(`class`: Option[String] = None, smallInput : Boolean = false, largeInput : Boolean = false,
              formControl: Boolean = false, bStyle: Option[String] = None, `type`: Option[String] = None,
              active : Boolean = false, onlyOnHover: Boolean = false, inverse: Boolean = false,
              outlined: Boolean = false, retainBackground : Boolean = false,
              ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
      component.set(key, ref)(Props(`class`, smallInput, largeInput, formControl, bStyle,
          `type`,active, onlyOnHover, inverse,outlined, retainBackground))

}
