package rationals

import java.lang.IllegalArgumentException
import java.math.BigInteger
import java.util.*

class Rational(numerator: BigInteger, denominator: BigInteger) : Comparable<Rational>  {
    companion object {
        val ZERO = Rational(BigInteger.ZERO, BigInteger.ONE)
    }

    private val numerator: BigInteger
    private val denominator: BigInteger

    constructor(numerator: Int) : this(numerator.toBigInteger(), BigInteger.ONE)

    constructor(numerator: Long) : this(numerator.toBigInteger(), BigInteger.ONE)

    constructor(numerator: BigInteger) : this(numerator, BigInteger.ONE)


    init {
        if (denominator == BigInteger.ZERO) {
            throw IllegalArgumentException()
        }

        val (num, den) = normalize(numerator, denominator)

        this.numerator = num
        this.denominator = den
    }

    private fun normalize(numerator: BigInteger, denominator: BigInteger): Pair<BigInteger, BigInteger> {
        val gcd = numerator.gcd(denominator)
        val sign = denominator.signum().toBigInteger()

        var num = numerator / (gcd * sign)
        var den = denominator / (gcd * sign)

        return Pair(num, den)
    }

    private fun lcm(numerator: BigInteger, denominator: BigInteger): BigInteger {
        val num = numerator.abs()
        val den = denominator.abs()
        return num * (den / num.gcd(den))
    }

    operator fun unaryMinus() : Rational = Rational(-numerator, denominator)

    private fun negate() : Rational = unaryMinus()

    operator fun minus(rational: Rational) : Rational {
        return this.plus(rational.negate())
    }

    operator fun plus(rational: Rational) : Rational {
        if (this == ZERO) return rational
        if (rational == ZERO) return this

        val f = this.numerator.gcd(rational.numerator)
        val g = this.denominator.gcd(rational.denominator)

        val num = f * ((this.numerator / f) * (rational.denominator / g) + (rational.numerator / f) * (this.denominator / g))
        val den = lcm(this.denominator, rational.denominator)
        return Rational(num, den)
    }

    operator fun times(rational: Rational) : Rational {
        val c = Rational(this.numerator, rational.denominator)
        val d = Rational(rational.numerator, this.denominator)
        return Rational(c.numerator * d.numerator, c.denominator * d.denominator)
    }

    operator fun div (rational: Rational) : Rational {
        return this.times(rational.reciprocal())
    }

    private fun reciprocal() : Rational {
        return Rational(denominator, numerator)
    }

    override fun toString(): String {
        return if (denominator == BigInteger.ONE) "$numerator" else "$numerator/$denominator"
    }

    override fun hashCode(): Int {
        return Objects.hash(numerator, denominator)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        return compareTo(other as Rational) == 0
    }

    override fun compareTo(other: Rational): Int {
        val lhs = this.numerator * other.denominator
        val rhs = this.denominator * other.numerator
        return lhs.compareTo(rhs)
    }
}

infix fun Int.divBy(denominator: Int) : Rational = Rational(this) / Rational(denominator)

infix fun Long.divBy(denominator: Long) : Rational = Rational(this) / Rational(denominator)

infix fun BigInteger.divBy(denominator: BigInteger) : Rational = Rational(this) / Rational(denominator)

fun String.toRational() : Rational {
    val args = this.split("/");

    return if (args.size == 1) {
        Rational(args[0].toBigInteger())
    } else {
        Rational(args[0].toBigInteger(), args[1].toBigInteger())
    }
}