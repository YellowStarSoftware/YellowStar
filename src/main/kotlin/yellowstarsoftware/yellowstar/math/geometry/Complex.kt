package yellowstarsoftware.yellowstar.math.geometry

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Complex number.
 * @property x real part
 * @property y imaginary part
 */
data class Complex(
    val x: Float,
    val y: Float
) {

    /**
     * Length of the instance.
     */
    val length get() = sqrt(lengthSq)

    /**
     * Complex conjugate.
     */
    val conjugate get() = Complex(x, -y)

    /**
     * Sum of complex numbers.
     */
    operator fun plus(z: Complex): Complex {
        return Complex(x + z.x, y + z.y)
    }

    /**
     * Difference of complex numbers.
     */
    operator fun minus(z: Complex): Complex {
        return Complex(x - z.x, y - z.y)
    }

    /**
     * Negative complex number.
     */
    operator fun unaryMinus(): Complex {
        return Complex(-x, -y)
    }

    /**
     * Complex numbers multiplication.
     */
    operator fun times(z: Complex): Complex {
        return Complex(
            x * z.x - y * z.y,
            x * z.y + y * z.x
        )
    }

    /**
     * Complex numbers division.
     */
    operator fun div(z: Complex): Complex {
        val zLength = z.lengthSq
        return Complex(
            (x * z.x + y * z.y) / zLength,
            (y * z.x - x * z.y) / zLength
        )
    }
    
    companion object {

        /**
         * Real unit.
         */
        val ONE = Complex(1.0f, 0.0f)

        /**
         * Imaginary unit.
         */
        val I = Complex(0.0f, 1.0f)

        /**
         * Returns a complex number with given argument [angle] and 1 size.
         * @param angle argument
         */
        fun fromPolar(angle: Float): Complex {
            return Complex(
                x = cos(angle),
                y = sin(angle)
            )
        }
    }
}

/**
 * Squared length of the instance.
 */
val Complex.lengthSq get() = x * x + y * y

/**
 * Rotates vector [v].
 */
fun Complex.rotate(v: Vector2D): Vector2D {
    return Vector2D(
        x * v.x - y * v.y,
        y * v.x + x * v.y
    )
}