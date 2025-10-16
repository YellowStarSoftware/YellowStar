package yellowstarsoftware.yellowstar.math.geometry

/**
 * Classification of an object relative to a plane.
 */
enum class ObjectPlaneClassification {

    /**
     * An object is to the right of a plane.
     * The object is in the direction of the plane's normal.
     */
    RIGHT,

    /**
     * An object is to the left of a plane.
     * The object is in the direction of the plane's normal * -1.
     */
    LEFT,

    /**
     * An object intersects a plane.
     */
    INTERSECTS
}