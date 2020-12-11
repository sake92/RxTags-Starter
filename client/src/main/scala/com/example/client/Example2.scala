package com.example.client

import org.scalajs.dom
import scalatags.JsDom.all._
import ba.sake.rxtags._

// List of reactive elements
object Example2 {

  case class CartItem(count: Int, name: String)

  val cartItems$ = Var(
    List(
      CartItem(10, "eggs"),
      CartItem(1, "milk"),
      CartItem(3, "bananas"),
      CartItem(2, "icecreams")
    )
  )

  def content(): Frag = div(
    h1("My cart items"),
    hr,
    ul(
      cartItems$.map2 { item =>
        li(
          b(item.count),
          s" ${item.name} ",
          button(onclick := delete(item))("Delete")
        )
      }
    )
  )

  def delete(item: CartItem): (dom.Event => Unit) =
    e => {
      cartItems$.set { currentItems =>
        currentItems.filterNot(i => i == item)
      }
    }
}
