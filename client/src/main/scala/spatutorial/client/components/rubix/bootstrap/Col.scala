package spatutorial.client.components.rubix.bootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactElement}

import scala.scalajs.js

/**
 * Created by uenyioha on 11/28/15.
 */

object Col {

  sealed trait GutterOption
  case object GutterLeft extends GutterOption { override def toString = "gutter-left" }
  case object GutterRight extends GutterOption { override def toString = "gutter-right" }
  case object GutterTop extends GutterOption { override def toString = "gutter-top" }
  case object GutterBottom extends GutterOption { override def toString = "gutter-bottom" }

  sealed trait Screen
  case object XtraSmallScreen extends Screen { override def toString = "col-xs" }
  case object SmallScreen extends Screen { override def toString = "col-sm" }
  case object MediumScreen extends Screen { override def toString = "col-md" }
  case object LargeScreen extends Screen { override def toString = "col-lg" }

  sealed trait CollapseOption
  case object CollapseLeft extends CollapseOption { override def toString = "collapse-left" }
  case object CollapseRight extends CollapseOption { override def toString = "collapse-right" }
  case object CollapseTop extends CollapseOption { override def toString = "collapse-top" }
  case object CollapseBottom extends CollapseOption { override def toString = "collapse-bottom" }

  case class Props(`class` : Option[String] = None, id : Option[String] = None,
                   xs : Int = 0, sm : Int = 0, md : Int = 0, lg : Int = 0,
                   collapseLeft: Boolean = false, collapseRight : Boolean = false,
                   collapseTop : Boolean = false, collapseBottom: Boolean = false,
                   gutterRight : Boolean = false, gutterLeft : Boolean = false,
                   gutterTop : Boolean = false, gutterBottom : Boolean = false,
                   clearfix: Boolean = false, hidden : Boolean = false, visible : Option[String] = None,
                   push : Boolean = false, pull : Boolean = false, offset : Boolean = false) {

    def genClasses = {

      // optionals
      val modifiers = if (push) "-push" else if (pull) "-pull" else if (offset) "-offset" else ""

      // xs
      val sizeClassSet = ^.classSet1(`class`.getOrElse(""),
        s"col-xs$modifiers-$xs" -> (xs > 0),
        s"col-sm$modifiers-$sm" -> (sm > 0),
        s"col-md$modifiers-$md" -> (md > 0),
        s"col-lg$modifiers-$lg" -> (lg > 0)
      )

      val xtraSmallScreenSet = if (xs > 0) Set[Screen](XtraSmallScreen) else Set()
      val smallScreenSet = if (sm > 0) Set[Screen](SmallScreen) else Set()
      val mediumScreenSet = if (md > 0) Set[Screen](MediumScreen) else Set()
      val largeScreenSet = if (lg > 0) Set[Screen](LargeScreen) else Set()

      val screenSet = xtraSmallScreenSet ++ smallScreenSet ++ mediumScreenSet ++ largeScreenSet

      val collapseLeftSet = if (collapseLeft) Set[CollapseOption](CollapseLeft) else Set()
      val collapseRightSet = if (collapseRight) Set[CollapseOption](CollapseRight) else Set()
      val collapseTopSet = if (collapseTop) Set[CollapseOption](CollapseTop) else Set()
      val collapseBottomSet = if (collapseBottom) Set[CollapseOption](CollapseBottom) else Set()

      val collapseSet = collapseLeftSet ++ collapseRightSet ++ collapseTopSet ++ collapseBottomSet

      val gutterLeftSet = if (gutterLeft) Set[GutterOption](GutterLeft) else Set()
      val gutterRightSet = if (gutterRight) Set[GutterOption](GutterRight) else Set()
      val gutterTopSet = if (gutterTop) Set[GutterOption](GutterTop) else Set()
      val gutterBottomSet = if (gutterBottom) Set[GutterOption](GutterBottom) else Set()

      val gutterSet = gutterLeftSet ++ gutterRightSet ++ gutterTopSet ++ gutterBottomSet

      def combine[A, B] = (val1 : A, val2: B) => s"$val1-$val2" -> true

      val screenCollapseCrossProduct = for {
        screen <- screenSet
        collapse <- collapseSet
      } yield (screen, collapse)

      val screenGutterCrossProduct = for {
        screen <- screenSet
        gutter <- gutterSet
      } yield (screen, gutter)

      // collapse
      val screenCollapseClassSet = ^.classSetM(screenCollapseCrossProduct.foldLeft(Map[String, Boolean]())((a, b) => a + combine.tupled(b)))

      // gutter
      val screenGutterClassSet = ^.classSetM(screenGutterCrossProduct.foldLeft(Map[String, Boolean]())((a, b) => a + combine.tupled(b)))

      // clearfix, hidden, visible
      val clearFixClassSet = ^.classSet("clearfix" -> clearfix, "hidden" -> hidden,
        s"visible-${visible.getOrElse("")}" -> visible.isDefined)

      sizeClassSet + screenCollapseClassSet + screenGutterClassSet + clearFixClassSet

    }
  }

  val component = ReactComponentB[Props]("col")
    .stateless
    .render { $ =>
      <.div(
        ^.id := $.props.id,
        $.props.genClasses,
        $.propsChildren
      )
    }
    .build

  def apply(`class` : Option[String] = None, id: Option[String] = None,
            xs : Int = 0, sm : Int = 0, md : Int = 0, lg : Int = 0,
            collapseLeft: Boolean = false, collapseRight : Boolean = false,
            collapseTop : Boolean = false, collapseBottom: Boolean = false,
            gutterRight : Boolean = false, gutterLeft : Boolean = false,
            gutterTop : Boolean = false, gutterBottom : Boolean = false,
            clearfix: Boolean = false, hidden : Boolean = false, visible : Option[String] = None,
            push : Boolean = false, pull : Boolean = false, offset : Boolean = false,
            ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactElement*) =
    component.set(key, ref)(Props(`class`, id,
                xs, sm, md, lg,
                collapseLeft, collapseRight,
                collapseTop, collapseBottom,
                gutterRight, gutterLeft,
                gutterTop, gutterBottom,
                clearfix, hidden, visible,
                push, pull, offset), children : _*)
}
