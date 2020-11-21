package com.example.client

import org.scalajs.dom

object Main {

  def main(args: Array[String]): Unit = {

    val content = Example1.content().render

    val root = dom.document.getElementById("root")
    root.appendChild(content)
  }
}
