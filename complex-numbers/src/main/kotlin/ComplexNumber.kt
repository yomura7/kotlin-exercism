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
        return ComplexNumber(this.real * that.real, this.imag * that.imag)
    }
    operator fun div(that: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real / that.real, this.imag / that.imag)
    }
    val abs
        get() = sqrt(this.real * this.real + this.imag + this.imag)
    fun conjugate(): ComplexNumber {
        return ComplexNumber(this.abs * this.abs, 0.0 )
    }
    companion object {
        fun exponential(that: ComplexNumber): ComplexNumber {
            return that
        }
    }

}
