package com.usableapps.components.rubix

import scala.collection.mutable
import scalacss.Defaults._

import japgolly.scalajs.react._, vdom.prefix_<^._

/**
 * Created by uenyioha on 11/28/15.
 */
package object bootstrap {

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