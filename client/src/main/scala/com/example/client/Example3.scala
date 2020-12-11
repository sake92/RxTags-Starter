package com.example.client

import org.scalajs.dom
import scalatags.JsDom.all._
import ba.sake.rxtags._

// Reactive attributes
object Example3 {

  val class$ = Var("style1")

  def content(): Frag =
    div(
      button(onclick := randomClass())("Random style!"),
      br,
      div(cls := class$)(
        "Div content example..."
      )
    )

  def randomClass(): (dom.Event => Unit) =
    e =>
      class$.set {
        val rand = 1 + ((Math.random() * 10).toInt / 3) // 1,2 or 3
        s"style$rand"
      }
}
