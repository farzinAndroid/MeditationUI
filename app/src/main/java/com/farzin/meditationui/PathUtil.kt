package com.farzin.meditationui

import androidx.compose.ui.geometry.Offset
import java.nio.file.Path
import kotlin.math.abs


fun androidx.compose.ui.graphics.Path.standardQuadFromTo(
    from:Offset,
    to:Offset
){
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f
    )
}