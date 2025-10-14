package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Quaternion
import yellowstarsoftware.yellowstar.math.geometry.objects.BoundingBox
import yellowstarsoftware.yellowstar.math.geometry.objects.OrientedBoundingBox
import yellowstarsoftware.yellowstar.math.geometry.objects.Sphere
import yellowstarsoftware.yellowstar.math.geometry.objects.radiusSquared

/**
 * Checks if [sphere] intersects [boundingBox].
 */
fun intersectsSphereBoundingBox(
    sphere: Sphere,
    boundingBox: BoundingBox
): Boolean {
    return intersectsSphereBoundingBox(
        sphere,
        OrientedBoundingBox(boundingBox, Quaternion.NO_ROTATION)
    )
}

/**
 * Checks if [sphere] intersects [boundingBox].
 */
fun intersectsSphereBoundingBox(
    sphere: Sphere,
    boundingBox: OrientedBoundingBox
): Boolean {
    val distanceSquared = boundingBox.distanceToPointSquared(sphere.center)
    return distanceSquared <= sphere.radiusSquared
}