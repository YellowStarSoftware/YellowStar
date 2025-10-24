package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import yellowstarsoftware.yellowstar.math.geometry.lengthSquared
import yellowstarsoftware.yellowstar.math.geometry.objects.OrientedRectangle

/**
 * Squared distance from [this] to [point].
 */
fun OrientedRectangle.distanceToPointSquared(
    point: Vector2D
): Float {
    val aabb = this.rectangle
    val a = aabb.min - point
    val part1 = distanceFunctionPart(
        linearTerm = 2.0f * (a dot this.rightDirection),
        maxX = aabb.width
    )
    val part2 = distanceFunctionPart(
        linearTerm = 2.0f * (a dot this.upDirection),
        maxX = aabb.height
    )
    return part1 + part2 + a.lengthSquared
}