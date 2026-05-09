package yellowstarsoftware.yellowstar.math.geometry.objects.quadtree

/**
 * Checks if this [QuadtreeNode] is a leaf.
 */
val QuadtreeNode<*>.isLeaf get() = children.isEmpty()