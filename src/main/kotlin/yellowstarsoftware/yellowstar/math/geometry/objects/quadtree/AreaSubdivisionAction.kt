package yellowstarsoftware.yellowstar.math.geometry.objects.quadtree

/**
 * Quadtree area subdivision action.
 */
sealed interface AreaSubdivisionAction<T> {

    /**
     * Drop the area action.
     * That means the area is empty and requires no nodes.
     */
    class DropArea<T> : AreaSubdivisionAction<T>

    /**
     * Create a leaf action.
     * That means the area is a solid object
     * and no further subdivision is needed.
     * @property item item of the node that will be created
     */
    class CreateLeaf<T>(
        val item: T
    ) : AreaSubdivisionAction<T>

    /**
     * Subdivide an area action.
     * That means the area should be subdivided further.
     * @property item item of the node that will be created
     */
    class Subdivide<T>(
        val item: T
    ) : AreaSubdivisionAction<T>
}
