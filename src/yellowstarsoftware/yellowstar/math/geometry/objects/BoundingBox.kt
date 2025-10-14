package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.*

/**
 * 3D axis aligned bounding box.
 * @property min point of the instance with minimal components
 * @property max point of the instance with maximal components
 */
data class BoundingBox(
    val min: Vector3D,
    val max: Vector3D
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
     * Length of the instance.
     */
    val length get() = max.z - min.z

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
            center: Vector3D,
            size: Vector3D
        ): BoundingBox {
            val sizeDiv2 = size.times(0.5f)
            return BoundingBox(
                center.minus(sizeDiv2),
                center.plus(sizeDiv2)
            )
        }
    }
}