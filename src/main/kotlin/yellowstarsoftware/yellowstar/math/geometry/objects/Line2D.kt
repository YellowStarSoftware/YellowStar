package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector2D

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
    val normal get() = direction.orthogonal
}

/**
 * Signed distance from [this] line to [point].
 */
fun Line2D.signedDistanceTo(
    point: Vector2D
): Float {
    return (point - this.point) dot this.normal
}