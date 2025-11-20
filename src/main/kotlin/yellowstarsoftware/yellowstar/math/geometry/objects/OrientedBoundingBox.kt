package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.*

/**
 * Rotated bounding box.
 * [BoundingBox], rotated around [BoundingBox.min] using [rotation].
 * @property boundingBox boundingBox without orientation
 * @property rotation quaternion that defines rotation
 */
data class OrientedBoundingBox(
    val boundingBox: BoundingBox,
    val rotation: Quaternion
) {

    /**
     * "Right" direction of the instance of unit size.
     */
    val rightDirection get() = rotation.rotateVector(Vector3D.I)

    /**
     * "Up" direction of the instance of unit size.
     */
    val upDirection get() = rotation.rotateVector(Vector3D.J)

    /**
     * "Forth" direction of the instance of unit size.
     */
    val forthDirection get() = rotation.rotateVector(Vector3D.K)

    companion object {

        /**
         * Creates an [OrientedBoundingBox] by its
         * [center], [size] and [rotation].
         */
        fun fromCenterSize(
            center: Vector3D,
            size: Vector3D,
            rotation: Quaternion
        ): OrientedBoundingBox {
            val sizeDiv2 = size.times(0.5f)
            val min = center - rotation.rotateVector(sizeDiv2)
            return OrientedBoundingBox(
                BoundingBox(min, min + size),
                rotation
            )
        }
    }
}

/**
 * Checks if [this] [OrientedBoundingBox] contains [point].
 */
operator fun OrientedBoundingBox.contains(
    point: Vector3D
): Boolean {
    val (w, h, l) = this.boundingBox.size
    val v = point - this.boundingBox.min
    val x = v dot this.rightDirection
    if (x < 0f || x > w) return false
    val y = v dot this.upDirection
    if (y < 0f || y > h) return false
    val z = v dot this.forthDirection
    if (z < 0f || z > l) return false
    return true
}