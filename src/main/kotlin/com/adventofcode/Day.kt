package com.adventofcode

import com.adventofcode.Counter.prioritySum
import com.adventofcode.Counter.process


private const val ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun priorityOf(x: Char) = ORDER.indexOf(x) + 1

object Counter {

  private val buf = mutableSetOf<Set<Int>>()

  var prioritySum = 0L; private set

  fun process(elf: Set<Int>) {
    buf.add(elf)
    if (buf.size < 3) {
      return
    }
    prioritySum += buf.reduce { acc: Set<Int>, ints: Set<Int> -> acc.intersect(ints) }.sum()
    buf.clear()
  }
}

fun process(line: String) {
  val elf = line.map(::priorityOf).toSet()
  process(elf)
}

fun solution(): Long {
  return prioritySum
}

fun main() {
  ::main.javaClass
    .getResourceAsStream("/input")!!
    .bufferedReader()
    .forEachLine(::process)
  println(solution())
}