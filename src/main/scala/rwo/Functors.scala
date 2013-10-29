package rwo

import scala.language.higherKinds
import scala.language.reflectiveCalls

/*
 * "A trivial example", c.f. Chapter 9.
 */
object ATrivialExample {
  trait XIntSig {
    def x: Int
  }
  def increment(M: XIntSig): XIntSig = new XIntSig {
    def x = M.x + 1
  }
  val Three = new XIntSig {
    def x = 3
  }
  val Four = increment(Three)
  val hopefullyOne = Four.x - Three.x
}

object ATrivialExampleWithStructuralTypes {
  type XIntSig = { def x: Int }
  def increment(M: XIntSig): XIntSig = new {
    def x = M.x + 1
  }
  val Three = new {
    def x = 3
  }
  val Four = increment(Three)
  val hopefullyOne = Four.x - Three.x
}
