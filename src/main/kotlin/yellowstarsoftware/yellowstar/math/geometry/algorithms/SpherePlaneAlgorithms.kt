package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.ObjectPlaneClassification
import yellowstarsoftware.yellowstar.math.geometry.objects.Circle3D
import yellowstarsoftware.yellowstar.math.geometry.objects.Plane
import yellowstarsoftware.yellowstar.math.geometry.objects.Sphere
import yellowstarsoftware.yellowstar.math.geometry.objects.radiusSquared
import kotlin.math.sqrt

/**
 * Finds [Circle3D] of intersection of [sphere] and [plane].
 */
fun intersectsSpherePlane(
    sphere: Sphere,
    plane: Plane
) : Circle3D? {
    val t = (plane.point - sphere.center) dot plane.normal
    val circleRadiusSquared = sphere.radiusSquared - t * t
    return if (circleRadiusSquared >= 0) {
        Circle3D(
            center = sphere.center + plane.normal * t,
            radius = sqrt(circleRadiusSquared),
            normal = plane.normal
        )
    } else {
        null
    }
}

/**
 * Classifies [sphere] relative to [plane].
 */
fun classifySpherePlane(
    sphere: Sphere,
    plane: Plane
) : ObjectPlaneClassification {
    val t = (plane.point - sphere.center) dot plane.normal
    if (t < -sphere.radius) return ObjectPlaneClassification.RIGHT
    if (t > sphere.radius) return ObjectPlaneClassification.LEFT
    return ObjectPlaneClassification.INTERSECTS
}