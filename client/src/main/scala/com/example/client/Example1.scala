package com.example.client

import org.scalajs.dom
import org.scalajs.dom.html.Input
import scalatags.JsDom.all._
import ba.sake.rxtags._

// Single reactive element
object Example1 {

  val username$ = Var("")

  def content(): Frag =
    div(
      "Please enter your username: ",
      input(onkeyup := updateUsername()),
      br,
      username$.map { u =>
        "You entered: " + u
      }.asFrag
    )

  def updateUsername(): (dom.KeyboardEvent => Unit) =
    e => {
      val inputField = e.target.asInstanceOf[Input]
      username$.set(inputField.value)
    }
}
