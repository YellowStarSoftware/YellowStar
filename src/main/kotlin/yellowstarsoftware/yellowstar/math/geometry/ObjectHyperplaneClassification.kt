package yellowstarsoftware.yellowstar.math.geometry

/**
 * Classification of an object relative to a hyperplane.
 */
enum class ObjectHyperplaneClassification {

    /**
     * An object is to the right of a hyperplane.
     * The object is in the direction of the hyperplane's normal.
     */
    RIGHT,

    /**
     * An object is to the left of a hyperplane.
     * The object is in the direction of the hyperplane's normal * -1.
     */
    LEFT,

    /**
     * An object intersects a hyperplane.
     */
    INTERSECTS
}