package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.lengthSq
import yellowstarsoftware.yellowstar.math.geometry.objects.OrientedBoundingBox

/**
 * Squared distance from [this] to [point].
 */
fun OrientedBoundingBox.distanceToPointSquared(
    point: Vector3D
): Float {
    val aabb = this.boundingBox
    val a = aabb.min - point
    val part1 = distanceFunctionPart(
        linearTerm = 2.0f * (a dot this.rightDirection),
        maxX = aabb.width
    )
    val part2 = distanceFunctionPart(
        linearTerm = 2.0f * (a dot this.upDirection),
        maxX = aabb.height
    )
    val part3 = distanceFunctionPart(
        linearTerm = 2.0f * (a dot this.forthDirection),
        maxX = aabb.length
    )
    return part1 + part2 + part3 + a.lengthSq
}