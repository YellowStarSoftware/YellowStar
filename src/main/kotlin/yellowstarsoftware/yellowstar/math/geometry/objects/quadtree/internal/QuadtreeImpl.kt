package yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.internal

import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import yellowstarsoftware.yellowstar.math.geometry.objects.Rectangle
import yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.AreaSubdivisionAction
import yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.Quadtree
import yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.QuadtreeNode
import yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.QuadtreeSubdivisionStrategy

/**
 * [Quadtree] implementation.
 * @param root root of the three
 */
internal class QuadtreeImpl<T>(
    override val root: QuadtreeNode<T>
) : Quadtree<T> {

    companion object {

        /**
         * Creates a [Quadtree] of [area] with given [strategy].
         */
        fun <T> create(
            area: Rectangle,
            strategy: QuadtreeSubdivisionStrategy<T>
        ): Quadtree<T>? {
            val root = createQuadtreeNode(
                strategy = strategy,
                area = area,
                depth = 0
            )
            return if (root == null) {
                null
            } else {
                QuadtreeImpl(root = root)
            }
        }
    }
}

private fun <T> createQuadtreeNode(
    strategy: QuadtreeSubdivisionStrategy<T>,
    area: Rectangle,
    depth: Int
): QuadtreeNode<T>? {
    val action = strategy.processArea(
        area = area,
        depth = depth
    )
    return when (action) {
        is AreaSubdivisionAction.DropArea -> {
            null
        }
        is AreaSubdivisionAction.CreateLeaf -> {
            QuadtreeNodeImpl(
                area = area,
                item = action.item,
                children = emptyList()
            )
        }
        is AreaSubdivisionAction.Subdivide -> {
            val childWidth = area.width / 2f
            val childWidthDiv2 = childWidth / 2f
            val childHeight = area.height / 2f
            val childHeightDiv2 = childHeight / 2f
            val childrenOffsets = listOf(
                // first quadrant
                Vector2D(childWidthDiv2, childHeightDiv2),
                // second quadrant
                Vector2D(-childWidthDiv2, childHeightDiv2),
                // third quadrant
                Vector2D(-childWidthDiv2, -childHeightDiv2),
                // fourth quadrant
                Vector2D(childWidthDiv2, -childHeightDiv2),
            )
            QuadtreeNodeImpl(
                area = area,
                item = action.item,
                children = childrenOffsets.mapNotNull { offset ->
                    createQuadtreeNode(
                        strategy = strategy,
                        area = Rectangle.fromCenterSize(
                            center = area.center + offset,
                            size = Vector2D(childWidth, childHeight)
                        ),
                        depth = depth + 1
                    )
                }
            )
        }
    }
}