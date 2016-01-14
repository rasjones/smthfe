package com.smoothpay.client.services

import diode._
import diode.react._
import org.querki.jquery
import com.usableapps.components.rubix.bootstrap._


/**
  * Created by uenyioha on 12/28/15.
  */

case class RubixSidebarUI(activeSidebar: Integer,
                          layoutDir : String = null, openState: SidebarOpenState = null,
                           repositionState: SidebarRepositionState = null, changeState: SidebarChangeState = SidebarChangeState(false))

case class SidebarOpenState(child_node: jquery.Selector, open: Boolean = false)
case class SidebarRepositionState(child_node: jquery.Selector, top: Double, height: Double)
case class SidebarChangeState(open: Boolean)

case class MenuBar()

case class UIContainer(sidebar: RubixSidebarUI, menuBar: MenuBar)

case class DataContainer()

// base model of our application
case class NewRootModel(ui: UIContainer, data: DataContainer)

sealed trait LayoutEvent
case class LayoutDirEvent() extends LayoutEvent

class SidebarControlBtnHandler[M](modelRW: ModelRW[M, Integer]) extends ActionHandler(modelRW) {
  override def handle = {
    case SidebarControlBtnEvent(params) => {
      updated(params)
    }
  }
}

class SidebarKeyChangeHandler[M](modelRW: ModelRW[M, Integer]) extends ActionHandler(modelRW) {
  override def handle = {
    case SidebarKeyChangeEvent(activeSidebar) => updated(activeSidebar)
  }
}

class SidebarOpenStateHandler[M](modelRW: ModelRW[M, SidebarOpenState]) extends ActionHandler(modelRW) {
  override def handle = {
    case SidebarOpenStateEvent(params) => updated(params)
  }
}

class SidebarRepositionHandler[M](modelRW: ModelRW[M, SidebarRepositionState]) extends ActionHandler(modelRW) {
  override def handle = {
    case SidebarRepositionEvent(params) => updated(params)
  }
}

class SidebarUpdateHandler[M](modelRW: ModelRW[M, Unit]) extends ActionHandler(modelRW) {
  override def handle = {
    case SidebarUpdateEvent => noChange
  }
}

class SidebarChangeStateHandler[M](modelRW: ModelRW[M, SidebarChangeState]) extends ActionHandler(modelRW) {
  override def handle = {

    case SidebarChangeStateEvent(params) => {
      updated(SidebarChangeState(params))
    }
  }
}


object AppCircuit extends Circuit[NewRootModel] with ReactConnector[NewRootModel] {

  override protected var model = NewRootModel(
                                      UIContainer(RubixSidebarUI(null), MenuBar()),
                                      DataContainer()
                                 )

  override val actionHandler = combineHandlers(
    new SidebarControlBtnHandler[NewRootModel](zoomRW(_.ui.sidebar.activeSidebar)((m, v) => {
      println("copying new data SidebarControlBtnHandler")
      m.copy(ui = m.ui.copy(sidebar =
        m.ui.sidebar.copy(activeSidebar = v)))
    })),
    new SidebarKeyChangeHandler[NewRootModel](zoomRW(_.ui.sidebar.activeSidebar)((m, v) => m.copy(ui = m.ui.copy(sidebar =
      m.ui.sidebar.copy(activeSidebar= v))))),
    new SidebarOpenStateHandler[NewRootModel](zoomRW(_.ui.sidebar.openState)((m, v) => m.copy(ui = m.ui.copy(sidebar =
      m.ui.sidebar.copy(openState = v))))),
    new SidebarRepositionHandler[NewRootModel](zoomRW(_.ui.sidebar.repositionState)((m, v) => m.copy(ui = m.ui.copy(sidebar =
      m.ui.sidebar.copy(repositionState = v))))),
    new SidebarChangeStateHandler[NewRootModel](zoomRW(_.ui.sidebar.changeState)((m, v) => {
      m.copy(ui = m.ui.copy(sidebar =
        m.ui.sidebar.copy(changeState = v)))
    }))
  )

}