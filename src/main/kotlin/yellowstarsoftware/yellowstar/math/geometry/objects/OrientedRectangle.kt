package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Complex
import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import yellowstarsoftware.yellowstar.math.geometry.rotate

/**
 * Rotated rectangle.
 * [Rectangle], rotated around [Rectangle.min] using [rotation].
 * @property rectangle rectangle without orientation
 * @property rotation complex number that defines rotation
 */
data class OrientedRectangle(
    val rectangle: Rectangle,
    val rotation: Complex
) {

    /**
     * "Right" direction of the instance of unit size.
     */
    val rightDirection: Vector2D get() = rotation.rotate(Vector2D.I)

    /**
     * "Up" direction of the instance of unit size.
     */
    val upDirection: Vector2D get() = rotation.rotate(Vector2D.J)

    companion object {

        /**
         * Creates an [OrientedRectangle] by its
         * [center], [size] and [rotation].
         */
        fun fromCenterSize(
            center: Vector2D,
            size: Vector2D,
            rotation: Complex
        ): OrientedRectangle {
            val sizeDiv2 = size.times(0.5f)
            val min = center - rotation.rotate(sizeDiv2)
            return OrientedRectangle(
                Rectangle(min, min + size),
                rotation
            )
        }
    }
}

/**
 * Checks if [this] [OrientedRectangle] contains [point].
 */
operator fun OrientedRectangle.contains(
    point: Vector2D
): Boolean {
    val v = point - this.rectangle.min
    val (w, h) = this.rectangle.size
    val x = v dot this.rightDirection
    if (x < 0f || x > w) return false
    val y = v dot this.upDirection
    if (y < 0f || y > h) return false
    return true
}