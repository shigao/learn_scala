package com.h7d1w0

trait RNG {
  def nextInt: (Int, RNG)
}


object RNG {
  case class SimpleRNG(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRNG = SimpleRNG(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRNG)
    }
  }

  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (i, r) = rng.nextInt
    (if (i < 0 ) -(i + 1) else i, r)
  }

  def double(rng: RNG): (Double, RNG) = {
    val (i, r) = rng.nextInt
    (i / (Int.MaxValue.toDouble + 1), r)
  }

  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (i, r) = rng.nextInt
    val (d, r1) =  double(r)
    ((i, d), r1)
  }

  type Rand[+A] = RNG => (A, RNG)

//  val int: Rand[Int] = RNG.nonNegativeInt
  val int: Rand[Int] = _.nextInt
  val int2: Rand[Int] = (x: RNG) => x.nextInt

  def unit[A](a: A): Rand[A] = rng => (a, rng)

  def map[A, B](s: Rand[A])(f: A => B): Rand[B] =
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  def double2(rng: RNG): Rand[Double] =  map(_.nextInt)(_ / (Int.MaxValue.toDouble + 1))


}


