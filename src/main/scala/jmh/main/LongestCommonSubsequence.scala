package jmh.main

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode, OutputTimeUnit}

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.Throughput))
class LongestCommonSubsequence {

  @Benchmark
  def longestCommonSubsequenceDP(): String = {
    val s1 = "Pellentesque lacinia semper consectetur. Proin id porta velit, sed molestie orci"
    val s2 = "Mauris purus massa, porttitor in ultricies sit amet, laoreet at augue. Nunc eget"
    val up = 1
    val left = 2
    val charMatched = 3

    val s1Length = s1.length()
    val s2Length = s2.length()

    val lcsLengths = Array.fill[Int](s1Length + 1, s2Length + 1)(0)

    for (i <- 0 until s1Length) {
      for (j <- 0 until s2Length) {
        if (s1.charAt(i) == s2.charAt(j)) {
          lcsLengths(i + 1)(j + 1) = lcsLengths(i)(j) + 1
        } else {
          if (lcsLengths(i)(j + 1) >= lcsLengths(i + 1)(j)) {
            lcsLengths(i + 1)(j + 1) = lcsLengths(i)(j + 1)
          } else {
            lcsLengths(i + 1)(j + 1) = lcsLengths(i + 1)(j)
          }
        }
      }
    }

    val subSeq = new StringBuilder()
    var s1Pos = s1Length
    var s2Pos = s2Length

    do {
      if (lcsLengths(s1Pos)(s2Pos) == lcsLengths(s1Pos -1)(s2Pos)) {
        s1Pos -= 1
      } else if (lcsLengths(s1Pos)(s2Pos) == lcsLengths(s1Pos)(s2Pos - 1)) {
        s2Pos -= 1
      } else {
        assert(s1.charAt(s1Pos - 1) == s2.charAt(s2Pos - 1))
        subSeq += s1.charAt(s1Pos - 1)
        s1Pos -= 1
        s2Pos -= 1
      }

    } while (s1Pos > 0 && s2Pos > 0)

    subSeq.toString.reverse
  }

}
