package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.ObjectPlaneClassification
import yellowstarsoftware.yellowstar.math.geometry.objects.*
import yellowstarsoftware.yellowstar.utils.reference.ObjectReference
import kotlin.math.sqrt

/**
 * Checks if [sphere] intersects [plane].
 * In case of intersection writes [Circle3D]
 * of intersection to [intersectionReference],
 * otherwise leaves [intersectionReference]'s value unchanged.
 */
fun intersectsSpherePlane(
    sphere: Sphere,
    plane: Plane,
    intersectionReference: ObjectReference<in Circle3D>
): Boolean {
    val t = (plane.point - sphere.center) dot plane.normal
    val circleRadiusSquared = sphere.radiusSquared - t * t
    return if (circleRadiusSquared >= 0) {
        intersectionReference.value = Circle3D(
            center = sphere.center + plane.normal * t,
            radius = sqrt(circleRadiusSquared),
            normal = plane.normal
        )
        true
    } else {
        false
    }
}

/**
 * Classifies [sphere] relative to [plane].
 */
fun classifySpherePlane(
    sphere: Sphere,
    plane: Plane
): ObjectPlaneClassification {
    // TODO: use signed distance method?
    val t = (plane.point - sphere.center) dot plane.normal
    if (t < -sphere.radius) return ObjectPlaneClassification.RIGHT
    if (t > sphere.radius) return ObjectPlaneClassification.LEFT
    return ObjectPlaneClassification.INTERSECTS
}