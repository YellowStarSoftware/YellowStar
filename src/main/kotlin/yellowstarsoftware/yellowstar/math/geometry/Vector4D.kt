package yellowstarsoftware.yellowstar.math.geometry

import kotlin.math.sqrt

/**
 * Four-dimensional vector.
 * @property x x
 * @property y y
 * @property z z
 * @property w w
 */
data class Vector4D(
    val x: Float,
    val y: Float,
    val z: Float,
    val w: Float
) {

    /**
     * Length of the instance.
     */
    val length get() = sqrt(lengthSquared)

    /**
     * Returns a vector orthogonal to this instance.
     */
    val orthogonal get() = Vector4D(w, z, -y, -x)

    /**
     * Normalized vector.
     * [length] of this instance should not be zero.
     */
    val normalized get() = this.div(length)

    /**
     * Vector sum.
     */
    operator fun plus(a: Vector4D): Vector4D {
        return Vector4D(
            x + a.x,
            y + a.y,
            z + a.z,
            w + a.w
        )
    }

    /**
     * Vector difference.
     */
    operator fun minus(a: Vector4D): Vector4D {
        return Vector4D(
            x - a.x,
            y - a.y,
            z - a.z,
            w - a.w
        )
    }

    /**
     * Negative vector.
     */
    operator fun unaryMinus(): Vector4D {
        return Vector4D(-x, -y, -z, -w)
    }

    /**
     * Vector multiplication by value.
     */
    operator fun times(k: Float): Vector4D {
        return Vector4D(
            x * k,
            y * k,
            z * k,
            w * k
        )
    }

    /**
     * Per-component vector multiplication.
     */
    operator fun times(a: Vector4D): Vector4D {
        return Vector4D(
            x * a.x,
            y * a.y,
            z * a.z,
            w * a.w
        )
    }

    /**
     * Vector division by value.
     */
    operator fun div(k: Float): Vector4D {
        return Vector4D(
            x / k,
            y / k,
            z / k,
            w / k
        )
    }

    /**
     * Per-component vector division.
     */
    operator fun div(a: Vector4D): Vector4D {
        return Vector4D(
            x / a.x,
            y / a.y,
            z / a.z,
            w / a.w
        )
    }

    /**
     * Dot product.
     */
    infix fun dot(a: Vector4D): Float {
        return a.x * x + a.y * y + a.z * z + a.w * w
    }

    companion object {

        /**
         * Vector4D(0, 0, 0, 0).
         */
        val ZERO = Vector4D(0f, 0f, 0f, 0f)
    }
}

/**
 * Squared length of the instance.
 */
val Vector4D.lengthSquared get() = x * x + y * y + z * z + w * w

/**
 * Linear interpolation.
 */
fun Vector4D.lerp(b: Vector4D, t: Float): Vector4D {
    val d = b.minus(this)
    return this.plus(d.times(t))
}

/**
 * Obtains a [Vector3D] from [this] vector
 * treated as homogeneous coordinates.
 */
fun Vector4D.fromHomogeneousCoordinates(): Vector3D {
    return Vector3D(
        x = x / w,
        y = y / w,
        z = z / w
    )
}

/**
 * @see Vector4D.times
 */
operator fun Float.times(a: Vector4D): Vector4D {
    return a.times(this)
}