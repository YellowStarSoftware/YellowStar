package yellowstarsoftware.yellowstar.math.geometry.transformations

/**
 * Creates a [Pair] of scale and translate
 * such that for any t:
 * scale * t + translate = map(t, a1, a2, b1, b2).
 */
internal fun createIntervalMappingScaleTranslate(
    a1: Float,
    a2: Float,
    b1: Float,
    b2: Float
): Pair<Float, Float> {
    val scale = (b2 - b1) / (a2 - a1)
    val translate = b1 - scale * a1
    return scale to translate
}