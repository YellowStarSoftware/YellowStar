package yellowstarsoftware.yellowstar.math.geometry

import yellowstarsoftware.yellowstar.math.utils.indexOfMin
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Three-dimensional vector.
 * @property x x
 * @property y y
 * @property z z
 */
data class Vector3D(
    val x: Float,
    val y: Float,
    val z: Float
) {

    /**
     * Length of the instance.
     */
    val length get() = sqrt(lengthSquared)

    /**
     * Returns a vector orthogonal to this instance.
     */
    val orthogonal get() = when (indexOfMin(abs(x), abs(y), abs(z))) {
        0 -> Vector3D(0f, -z, y)
        1 -> Vector3D(-z, 0f, x)
        else -> Vector3D(-y, x, 0f)
    }

    /**
     * Normalized vector.
     * [length] of this instance should not be zero.
     */
    val normalized get() = this.div(length)

    /**
     * Vector sum.
     */
    operator fun plus(a: Vector3D): Vector3D {
        return Vector3D(
            x + a.x,
            y + a.y,
            z + a.z
        )
    }

    /**
     * Vector difference.
     */
    operator fun minus(a: Vector3D): Vector3D {
        return Vector3D(
            x - a.x,
            y - a.y,
            z - a.z
        )
    }

    /**
     * Negative vector.
     */
    operator fun unaryMinus(): Vector3D {
        return Vector3D(-x, -y, -z)
    }

    /**
     * Vector multiplication by value.
     */
    operator fun times(k: Float): Vector3D {
        return Vector3D(
            x * k,
            y * k,
            z * k
        )
    }

    /**
     * Per-component vector multiplication.
     */
    operator fun times(a: Vector3D): Vector3D {
        return Vector3D(
            x * a.x,
            y * a.y,
            z * a.z
        )
    }

    /**
     * Vector division by value.
     */
    operator fun div(k: Float): Vector3D {
        return Vector3D(
            x / k,
            y / k,
            z / k
        )
    }

    /**
     * Per-component vector division.
     */
    operator fun div(a: Vector3D): Vector3D {
        return Vector3D(
            x / a.x,
            y / a.y,
            z / a.z
        )
    }

    /**
     * Dot product.
     */
    infix fun dot(a: Vector3D): Float {
        return a.x * x + a.y * y + a.z * z
    }

    /**
     * Cross product.
     */
    infix fun cross(a: Vector3D): Vector3D {
        return Vector3D(
            y * a.z - z * a.y,
            z * a.x - x * a.z,
            x * a.y - y * a.x
        )
    }

    companion object {

        /**
         * Vector3D(1, 0, 0).
         */
        val I = Vector3D(1f, 0f, 0f)

        /**
         * Vector3D(0, 1, 0).
         */
        val J = Vector3D(0f, 1f, 0f)

        /**
         * Vector3D(0, 0, 1).
         */
        val K = Vector3D(0f, 0f, 1f)

        /**
         * Vector3D(0, 0, 0).
         */
        val ZERO = Vector3D(0f, 0f, 0f)

        /**
         * Creates a unit-size vector from spherical coordinates.
         * @param angleAlpha angle between the OX axis and the projection of the vector onto the XOZ plane
         *             parallel to the OY axis (measured from OX)
         * @param angleBeta angle between the XOZ plane and the vector (measured from the XOZ plane)
         */
        fun fromSpherical(
            angleAlpha: Float,
            angleBeta: Float
        ): Vector3D {
            val y = sin(angleBeta)
            val cosB = cos(angleBeta)
            val x = cos(angleAlpha) * cosB
            val z = sin(angleAlpha) * cosB
            return Vector3D(x, y, z)
        }
    }
}

/**
 * Squared length of the instance.
 */
val Vector3D.lengthSquared get() = x * x + y * y + z * z

/**
 * Linear interpolation.
 */
fun Vector3D.lerp(b: Vector3D, t: Float): Vector3D {
    val d = b.minus(this)
    return this.plus(d.times(t))
}

/**
 * Obtains the homogeneous coordinates of
 * [this] vector treated as a point.
 */
fun Vector3D.toHomogeneousCoordinates() : Vector4D {
    return Vector4D(
        x = x,
        y = y,
        z = z,
        w = 1f
    )
}

/**
 * @see Vector3D.times
 */
operator fun Float.times(a: Vector3D): Vector3D {
    return a.times(this)
}