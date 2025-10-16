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
     * "Right" direction of the instance.
     */
    val rightDirection: Vector2D get() = rotation.rotate(Vector2D.I)

    /**
     * "Up" direction of the instance.
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