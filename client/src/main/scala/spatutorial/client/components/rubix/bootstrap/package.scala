package spatutorial.client.components.rubix

import scala.collection.mutable
import scalacss.Defaults._
import spatutorial.client.components.Bootstrap.CommonStyle._

import japgolly.scalajs.react._, vdom.prefix_<^._

/**
 * Created by uenyioha on 11/28/15.
 */
package object bootstrap {
//
//  sealed trait SelectOption
//  case class SmallSelect() extends SelectOption { override def toString = "input-sm" }
//  case class LargeSelect() extends SelectOption { override def toString = "input-lg" }
//
//  sealed trait FormType
//  case class InlineForm() extends FormType { override def toString = "form-inline" }
//  case class HorizontalForm() extends FormType { override def toString = "form-horizontal" }
//
//  sealed trait FormGroupType
//  case class SmallFormGroup() extends FormGroupType { override def toString = "form-group-sm" }
//  case class LargeFormGroup() extends FormGroupType { override def toString = "form-group-lg" }
//  case class ErrorFormGroup () extends FormGroupType { override def toString = "has-error" }
//  case class Success() extends FormGroupType{ override def toString = "has-success" }
//  case class Warning() extends FormGroupType{ override def toString = "has-warning" }
//  case class Feedback() extends FormGroupType{ override def toString = "feedback" }
//
//  sealed trait PaginationClass
//  case object SmallPaginationClass extends PaginationClass { override def toString = "pagination-sm" }
//  case object LargePaginationClass extends PaginationClass { override def toString = "pagination-lg"}

  var zIndexState : Int = 999999999
  var navContents : mutable.Map[String, Boolean] = mutable.Map[String, Boolean]()
  var navs: mutable.Map[String, mutable.Map[String, Boolean]] = mutable.Map[String, mutable.Map[String, Boolean]]()

  val dataToggle  = "data-toggle".reactAttr

  var globalId : Int = 0

  def increaseGlobalId() = { globalId += 1; globalId }
  def resetGlobalId() = globalId = 0

  def increaseZIndex() = { zIndexState += 1; zIndexState }
  def decreaseZIndex() = { zIndexState -= 1; zIndexState }
  def resetZIndex() = zIndexState = 999999999
}