package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector2D

/**
 * 2D axis aligned rectangle.
 * @property min point of the instance with minimal components
 * @property max point of the instance with maximal components
 */
data class Rectangle(
    val min: Vector2D,
    val max: Vector2D
) {

    /**
     * Size of the instance.
     */
    val size get() = max.minus(min)

    /**
     * Width of the instance.
     */
    val width get() = max.x - min.x

    /**
     * Height of the instance.
     */
    val height get() = max.y - min.y

    /**
     * Center of the instance.
     */
    val center get() = min.plus(size.times(0.5f))

    companion object {

        /**
         * Creates a [BoundingBox] with given center and size.
         * @param center center
         * @param size size
         */
        fun fromCenterSize(
            center: Vector2D,
            size: Vector2D
        ): Rectangle {
            val sizeDiv2 = size.times(0.5f)
            return Rectangle(
                center.minus(sizeDiv2),
                center.plus(sizeDiv2)
            )
        }
    }
}
