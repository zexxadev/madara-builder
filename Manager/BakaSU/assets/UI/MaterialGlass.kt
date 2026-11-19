package org.bakasu.bakasu.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object GlassPalette {
    val GlassFillLight = Color(0x33FFFFFF)
    val GlassFillDark = Color(0x24FFFFFF)
    val GlassBorderLight = Color(0x55FFFFFF)
    val GlassBorderDark = Color(0x38FFFFFF)
    val GlassHighlightTop = Color(0x28FFFFFF)
    val GlassHighlightBottom = Color(0x0AFFFFFF)
}

@Composable
fun GlassBackdrop(
    modifier: Modifier = Modifier,
    topColor: Color = Color(0xFF101827),
    bottomColor: Color = Color(0xFF070B14),
    accentGlow: Color = Color(0x2638BDF8),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(topColor, bottomColor)
            )
        )
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(accentGlow, Color.Transparent)
                    )
                )
        )
        content()
    }
}

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = true,
    shape: Shape = RoundedCornerShape(20.dp),
    borderWidth: Dp = 1.dp,
    contentPadding: Dp = 14.dp,
    content: @Composable BoxScope.() -> Unit
) {
    val baseFill = if (darkTheme) GlassPalette.GlassFillDark else GlassPalette.GlassFillLight
    val borderColor = if (darkTheme) GlassPalette.GlassBorderDark else GlassPalette.GlassBorderLight

    Surface(
        modifier = modifier,
        shape = shape,
        color = Color.Transparent,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        border = BorderStroke(borderWidth, borderColor)
    ) {
        Box(
            modifier = Modifier
                .background(baseFill)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            GlassPalette.GlassHighlightTop,
                            GlassPalette.GlassHighlightBottom
                        )
                    )
                )
                .padding(contentPadding),
            content = content
        )
    }
}

@Composable
fun GlassPill(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.22f),
    borderColor: Color = Color.White.copy(alpha = 0.25f),
    shape: Shape = RoundedCornerShape(50),
    content: @Composable BoxScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = containerColor,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        border = BorderStroke(1.dp, borderColor),
        content = { Box(content = content) }
    )
}