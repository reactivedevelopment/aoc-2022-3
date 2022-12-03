package com.adventofcode

import com.adventofcode.Counter.prioritySum
import com.adventofcode.Counter.process

private const val ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun priorityOf(x: Char) = ORDER.indexOf(x) + 1

object Counter {

  private val buf = mutableSetOf<Set<Int>>()

  var prioritySum = 0L; private set

  fun process(line: String) {
    line.map(::priorityOf).toSet().let(buf::add)
    if (buf.size < 3) {
      return
    }
    prioritySum += buf.reduce { acc: Set<Int>, ints: Set<Int> -> acc.intersect(ints) }.sum()
    buf.clear()
  }
}

fun main() {
  ::main.javaClass.getResourceAsStream("/input")!!.bufferedReader().forEachLine(::process)
  println(prioritySum)
}