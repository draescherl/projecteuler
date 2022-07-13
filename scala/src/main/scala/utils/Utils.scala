package utils

import scala.annotation.tailrec

object Utils {
  // Fibonacci sequence generator
  lazy val fibs: LazyList[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

  // Prime number generator
  lazy val primes: LazyList[Int] = 2 #:: LazyList.from(3, step = 2).filter(n => !primes.takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0))

  // Check if n is a prime number
  def isPrime(n: Long): Boolean = !(2L to math.sqrt(n).toLong).exists(n % _ == 0)

  // GCD calculator
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a.abs else gcd(b, a % b)

  // LCM calculator
  def lcm(a: Int, b: Int): Int = (a * b).abs / gcd(a, b)

  // Get program runtime
  def time[R](block: => R): R = {
    val t0 = System.currentTimeMillis()
    val result = block    // call-by-name
    val t1 = System.currentTimeMillis()
    println("Elapsed time: " + (t1 - t0) + "ms.")
    result
  }
}
