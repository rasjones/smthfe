package com.usableapps.components.rubix.bootstrap

import scalacss.Defaults._
import scalacss.mutable

/**
  * Created by uenyioha on 12/12/15.
  */
class RubixStyles(implicit r: mutable.Register) extends StyleSheet.Inline()(r) {
  import dsl._

  def commonStyle[A](domain: Domain[A], base: String) = styleF(domain)(opt =>
    styleS(addClassNames(base, s"$base-$opt"))
  )

  def singleStyle[A](domain: Domain[A]) = styleF(domain)(opt => styleS(addClassNames(s"$opt")))

  def styleWrap(classNames: String*) = style(addClassNames(classNames: _*))

  object Gutter {
    sealed trait GutterOption
    case object GutterLeft extends GutterOption { override def toString = "grid-gutter-left" }
    case object GutterRight extends GutterOption { override def toString = "grid-gutter-right" }
    case object GutterTop extends GutterOption { override def toString = "grid-gutter-top" }
    case object GutterBottom extends GutterOption { override def toString = "grid-gutter-bottom" }

    val gutterDomain = Domain.ofValues(GutterLeft, GutterRight, GutterBottom, GutterTop)
    val gutterOpt = commonStyle(gutterDomain, "rubix-grid")
  }

  object Screen {
    sealed trait Screen
    case object XtraSmallScreen extends Screen { override def toString = "xs" }
    case object SmallScreen extends Screen { override def toString = "ss" }
    case object MediumScreen extends Screen { override def toString = "ms" }
    case object LargeScreen extends Screen { override def toString = "ls" }

    val screenDomain = Domain.ofValues(XtraSmallScreen, SmallScreen, MediumScreen, LargeScreen)
    val gutterOpt = singleStyle(screenDomain)
  }

  object Alert {
    sealed trait Alert
    case object AlertInfo extends Alert { override def toString = "alert-info" }
    case object AlertDanger extends Alert { override def toString = "alert-danger" }
    case object AlertSuccess extends Alert { override def toString = "alert-success" }
    case object AlertWarning extends Alert { override def toString = "alert-warning" }

    val alertDomain = Domain.ofValues(AlertInfo, AlertDanger, AlertSuccess, AlertWarning)
    val alertOption = commonStyle(alertDomain, "alert")
  }

  val hidden = styleWrap("hidden")
}