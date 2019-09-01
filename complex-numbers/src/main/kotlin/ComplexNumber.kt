import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    override fun equals(that: Any?): Boolean {
        if (that !is ComplexNumber) return false
        return this.real == that.real && this.imag == that.imag

    }
    operator fun plus(that: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real + that.real, this.imag + that.imag)
    }
    operator fun minus(that: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real - that.real, this.imag - that.imag)
    }
    operator fun times(that: ComplexNumber): ComplexNumber {
        val a = this.real
        val b = this.imag
        val c = that.real
        val d = that.imag
        return ComplexNumber(a * c - b * d, b * c + a * d)
    }
    operator fun div(that: ComplexNumber): ComplexNumber {
        val a = this.real
        val b = this.imag
        val c = that.real
        val d = that.imag
        return ComplexNumber(
                (a * c + b * d)/(c * c + d * d),
                (b * c - a * d) / (c * c + d * d))
    }
    val abs
        get() = sqrt(this.real * this.real + this.imag * this.imag)
    fun conjugate(): ComplexNumber {
        return ComplexNumber(this.real, -1 * this.imag )
    }
    companion object {
        fun exponential(num: ComplexNumber): ComplexNumber {
            // e^a
            val expA = exp(num.real)
            // e^(a + i * b) = e^a * e^(i * b) = (e^a * cos(b)) + (i * e^a * sin(b))
            return ComplexNumber(expA * cos(num.imag), expA * sin(num.imag))
        }
    }

}
