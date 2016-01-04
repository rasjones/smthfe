package com.usableapps.components.rubix.bootstrap.common

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
  * Created by uenyioha on 12/11/15.
  */
object ButtonClasses {

  sealed trait ButtonClass
  case object XtraSmallButton extends ButtonClass { override def toString = "btn-xs"}
  case object SmallButton extends ButtonClass { override def toString = "btn-sm"}
  case object LargeButton extends ButtonClass { override def toString = "btn-lg"}
  case object BlockButton extends ButtonClass { override def toString = "btn-block"}
  case object NavbarButton extends ButtonClass { override def toString = "navbar-btn"}
  case object RoundedButton extends ButtonClass { override def toString = "btn-rounded"}

  def genClasses(xsBtn : Boolean = false, smBtn : Boolean = false, lgBtn : Boolean = false,
                 blockBtn : Boolean = false, navBarBtn : Boolean = false, inverseBtn : Boolean = false,
                 roundedBtn : Boolean = false, outlinedBtn : Boolean = false,
                 bStyle: Option[String] = None, active : Boolean = false,
                 onlyOnHover: Boolean = false, retainBackground : Boolean = false) = {

    val stylesString = (for {
      array <- bStyle.map(_.split(""""\s|,"""))
      merge = array.map("btn-" + _)
    } yield {
      merge.mkString(" ")
    }).getOrElse("btn-default")

    ^.classSet1(s"btn $stylesString".trim,
                "btn-xs" -> xsBtn,
                "btn-lg" -> lgBtn,
                "active" -> active,
                "btn-block" -> blockBtn,
                "navbar-btn" -> navBarBtn,
                "btn-inverse" -> inverseBtn,
                "btn-rounded" -> roundedBtn,
                "btn-onlyOnHover" -> onlyOnHover,
                "btn-outlined" -> outlinedBtn,
                "btn-retainBg" -> retainBackground)
  }
}
