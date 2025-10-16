package yellowstarsoftware.yellowstar.math.geometry

import kotlin.math.*

/**
 * Two-dimensional vector.
 * @property x x
 * @property y y
 */
data class Vector2D(
    val x: Float,
    val y: Float
) {

    /**
     * Length of the instance.
     */
    val length get() = sqrt(lengthSq)

    /**
     * Returns a vector orthogonal to this instance.
     * Obtained by rotating this vector counterclockwise by pi/2.
     */
    val orthogonal get() = Vector2D(-y, x)

    /**
     * Normalized vector.
     * [length] of this instance should not be zero.
     */
    val normalized get() = this.div(length)

    /**
     * Vector sum.
     */
    operator fun plus(a: Vector2D): Vector2D {
        return Vector2D(x + a.x, y + a.y)
    }

    /**
     * Vector difference.
     */
    operator fun minus(a: Vector2D): Vector2D {
        return Vector2D(x - a.x, y - a.y)
    }

    /**
     * Negative vector.
     */
    operator fun unaryMinus(): Vector2D {
        return Vector2D(-x, -y)
    }

    /**
     * Vector multiplication by value.
     */
    operator fun times(k: Float): Vector2D {
        return Vector2D(x * k, y * k)
    }

    /**
     * Per-component vector multiplication.
     */
    operator fun times(a: Vector2D): Vector2D {
        return Vector2D(x * a.x, y * a.y)
    }

    /**
     * Vector division by value.
     */
    operator fun div(k: Float): Vector2D {
        return Vector2D(x / k, y / k)
    }

    /**
     * Per-component vector division.
     */
    operator fun div(a: Vector2D): Vector2D {
        return Vector2D(x / a.x, y / a.y)
    }

    /**
     * Dot product.
     */
    infix fun dot(a: Vector2D): Float {
        return x * a.x + y * a.y
    }

    companion object {

        /**
         * Vector(1, 0).
         */
        val I = Vector2D(1f, 0f)

        /**
         * Vector(0, 1).
         */
        val J = Vector2D(0f, 1f)

        /**
         * Vector(0, 0).
         */
        val ZERO = Vector2D(0f, 0f)

        /**
         * Creates a unit-size vector from polar coordinates.
         */
        fun fromPolar(angle: Float): Vector2D {
            return Vector2D(cos(angle), sin(angle))
        }
    }
}

/**
 * Squared length of the instance.
 */
val Vector2D.lengthSq get() = x * x + y * y

/**
 * Angle of the instance with the OX axis.
 * Counted from OX counterclockwise.
 */
val Vector2D.angle get() = atan2(y.toDouble(), x.toDouble()).toFloat()

/**
 * Multiplication of vectors treated as complex numbers.
 */
infix fun Vector2D.multAsComplex(z: Vector2D): Vector2D {
    return Vector2D(
        x * z.x - y * z.y,
        x * z.y + y * z.x
    )
}

/**
 * Division of vectors treated as complex numbers.
 */
infix fun Vector2D.divAsComplex(z: Vector2D): Vector2D {
    val zLength = z.lengthSq
    return Vector2D(
        (x * z.x + y * z.y) / zLength,
        (y * z.x - x * z.y) / zLength
    )
}

/**
 * Linear interpolation.
 */
fun Vector2D.lerp(b: Vector2D, t: Float): Vector2D {
    val d = b.minus(this)
    return this.plus(d.times(t))
}

/**
 * @see Vector2D.times
 */
operator fun Float.times(a: Vector2D): Vector2D {
    return a.times(this)
}