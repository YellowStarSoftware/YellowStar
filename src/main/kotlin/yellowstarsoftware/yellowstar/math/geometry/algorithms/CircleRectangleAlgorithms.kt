package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Complex
import yellowstarsoftware.yellowstar.math.geometry.objects.Circle2D
import yellowstarsoftware.yellowstar.math.geometry.objects.OrientedRectangle
import yellowstarsoftware.yellowstar.math.geometry.objects.Rectangle
import yellowstarsoftware.yellowstar.math.geometry.objects.radiusSquared

/**
 * Checks if [circle] intersects [rectangle].
 */
fun intersectsCircleRectangle(
    circle: Circle2D,
    rectangle: Rectangle
): Boolean {
    return intersectsCircleRectangle(
        circle,
        OrientedRectangle(rectangle, Complex.ONE)
    )
}

/**
 * Checks if [circle] intersects [rectangle].
 */
fun intersectsCircleRectangle(
    circle: Circle2D,
    rectangle: OrientedRectangle
): Boolean {
    val distanceSquared = rectangle.distanceToPointSquared(circle.center)
    return distanceSquared <= circle.radiusSquared
}