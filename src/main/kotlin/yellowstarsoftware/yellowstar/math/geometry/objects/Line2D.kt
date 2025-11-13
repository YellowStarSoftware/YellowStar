package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import kotlin.math.abs

/**
 * Two-dimensional line.
 * @property point point on the line
 * @property direction of the line (must be unit length)
 */
data class Line2D(
    val point: Vector2D,
    val direction: Vector2D
) {

    /**
     * Normal to the line of unit length.
     */
    val normal get() = direction.orthogonalClockwise

    companion object {

        /**
         * Creates a line defined with given equation A*x + B*y + C = 0.
         * A*B must not be zero.
         */
        fun fromLineEquation(A: Float, B: Float, C: Float): Line2D {
            return Line2D(
                // we compare abs(A) and abs(B) to prevent zero division
                point = if (abs(A) > abs(B)) {
                    Vector2D(-C / A, 0.0f)
                } else {
                    Vector2D(0.0f, -C / B)
                },
                direction = Vector2D(A, B).normalized.orthogonalCounterclockwise
            )
        }
    }
}

/**
 * Signed distance from [this] line to [point].
 */
fun Line2D.signedDistanceTo(
    point: Vector2D
): Float {
    return (point - this.point) dot this.normal
}