package yellowstarsoftware.yellowstar.math.geometry

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

/**
 * Quaternion.
 * @property x i coefficient
 * @property y j coefficient
 * @property z j coefficient
 * @property w real part
 */
data class Quaternion(
    val x: Float,
    val y: Float,
    val z: Float,
    val w: Float
) {

    /**
     * Vector part of the quaternion.
     */
    val vectorPart get() = Vector3D(x, y, z)

    /**
     * Rotation angle of the quaternion.
     */
    val angle get() = atan2(vectorPart.length, w) * 2.0f

    /**
     * Conjugate quaternion.
     */
    val conjugate get() = Quaternion(-x, -y, -z, w)

    /**
     * Quaternion multiplication.
     */
    operator fun times(q2: Quaternion): Quaternion {
        val q1 = this
        return Quaternion(
            x = q1.x * q2.w + q1.w * q2.x + q1.y * q2.z - q1.z * q2.y,
            y = q1.w * q2.y + q1.y * q2.w + q1.z * q2.x - q1.x * q2.z,
            z = q1.w * q2.z + q1.z * q2.w + q1.x * q2.y - q1.y * q2.x,
            w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z
        )
    }

    companion object {

        /**
         * Quaternion defining no rotation.
         */
        val NO_ROTATION = Quaternion(0f, 0f, 0f, 1f)

        /**
         * Creates a [Quaternion] for rotating
         * vectors around [axis] at [angle].
         */
        fun fromRotation(
            axis: Vector3D,
            angle: Float
        ): Quaternion {
            val angleDiv2 = angle * 0.5f
            val sin = sin(angleDiv2)
            return Quaternion(
                x = axis.x * sin,
                y = axis.y * sin,
                z = axis.z * sin,
                w = cos(angleDiv2)
            )
        }
    }
}

/**
 * Rotates vector [v].
 */
fun Quaternion.rotateVector(v: Vector3D): Vector3D {
    val res = this.times(Quaternion(v.x, v.y, v.z, 0.0f)).times(this.conjugate)
    return Vector3D(res.x, res.y, res.z)
}