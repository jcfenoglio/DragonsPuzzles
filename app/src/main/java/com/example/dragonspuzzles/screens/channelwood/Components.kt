package com.example.dragonspuzzles.screens.channelwood

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.graphics.shapes.transformed
import com.example.dragonspuzzles.ui.theme.DragonsPuzzlesTheme
import kotlin.math.max

@Composable
fun gridBase() {
    val color = MaterialTheme.colorScheme.onPrimaryContainer
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp),
    ) {
        drawLine(
            color = color,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width / 3, y = 0f),
            end = Offset(x = size.width / 3, y = size.height)
        )
        drawLine(
            color = color,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 2 / 3, y = 0f),
            end = Offset(x = size.width * 2 / 3, y = size.height)
        )
        drawLine(
            color = color,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height / 3),
            end = Offset(x = size.width, y = size.height / 3)
        )
        drawLine(
            color = color,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 2 / 3),
            end = Offset(x = size.width, y = size.height * 2 / 3)
        )
    }
}

@Composable
fun semicircle(modifier: Modifier) {
    val color = MaterialTheme.colorScheme.onTertiaryContainer
    Canvas(
        modifier = modifier
            .padding(5.dp)) {
        drawArc(
            color = color,
            startAngle = 90f,
            sweepAngle = 180f,
            useCenter = true
        )
    }
}

@Composable
fun cyanArc(modifier: Modifier) {
    val color = MaterialTheme.colorScheme.onTertiaryContainer
    val background = MaterialTheme.colorScheme.tertiaryContainer
    Canvas(
        modifier = modifier
            .padding(5.dp)
    ) {
        drawArc(
            color = color,
            startAngle = 60f,
            sweepAngle = -300f,
            useCenter = true
            )
        drawArc(
            color = background,
            startAngle = 60f,
            sweepAngle = -300f,
            useCenter = true,
            topLeft = Offset(size.width/4, size.height/4),
            size = Size(size.width/2, size.height/2)

        )
    }
}

@Composable
fun cross(modifier: Modifier) {
    val color = MaterialTheme.colorScheme.onTertiaryContainer
    Canvas(
        modifier = modifier
            .padding(5.dp)) {
        drawLine(
            color = color,
            start = Offset(size.width/2, 0f),
            end = Offset(size.width/2, size.height),
            strokeWidth = size.width/3
        )
        drawLine(
            color = color,
            start = Offset(0f, size.height/2),
            end = Offset(size.width, size.height/2),
            strokeWidth = size.width/3
        )
    }
}

@Composable
fun downUp(modifier: Modifier) {
    val color = MaterialTheme.colorScheme.onTertiaryContainer
    Canvas(
        modifier = modifier
            .padding(5.dp)) {
        drawLine(
            color = color,
            start = Offset(size.width/2, 0f),
            end = Offset(size.width/2, size.height),
            strokeWidth = size.width/3
        )
        val pathUp = Path()
        pathUp.moveTo(0f, 0f)
        pathUp.lineTo(size.width/3, 0f)
        pathUp.lineTo(size.width/6, size.height)
        pathUp.close()
        drawPath(
            path = pathUp,
            color = color,
        )
        val pathDown = Path()
        pathDown.moveTo(size.width * 5 / 6, 0f)
        pathDown.lineTo(size.width, size.height)
        pathDown.lineTo(size.width * 2 / 3, size.height)
        pathDown.close()
        drawPath(
            path = pathDown,
            color = color
        )
    }
}

@Composable
fun moonMountain(modifier: Modifier) {
    val color = MaterialTheme.colorScheme.onTertiaryContainer
    Canvas(
        modifier = modifier
            .padding(5.dp)) {
        drawCircle(
            color = color,
            radius = size.width / 4,
            center = Offset(size.width / 2, size.height / 4)
        )
        val pathLeft = Path()
        pathLeft.moveTo(0f, size.height)
        pathLeft.lineTo(size.width / 3, size.height)
        pathLeft.lineTo(size.width / 6, size.height / 2)
        pathLeft.close()
        drawPath(
            path = pathLeft,
            color = color
        )
        val pathMiddle = Path()
        pathMiddle.moveTo(size.width / 3, size.height)
        pathMiddle.lineTo(size.width * 2 / 3, size.height)
        pathMiddle.lineTo(size.width / 2, size.height / 2)
        pathMiddle.close()
        drawPath(
            path = pathMiddle,
            color = color
        )
        val pathRight = Path()
        pathRight.moveTo(size.width * 2 / 3, size.height)
        pathRight.lineTo(size.width, size.height)
        pathRight.lineTo(size.width * 5 / 6, size.height / 2)
        pathRight.close()
        drawPath(
            path = pathRight,
            color = color
        )
    }
}

@Composable
fun LeftFacingButton(modifier: Modifier) {
    val color = MaterialTheme.colorScheme.tertiary
    Box(
        modifier = modifier
            .drawWithCache {
                val roundedPolygon = RoundedPolygon(
                    numVertices = 3,
                    radius = size.minDimension / 2,
                    centerX = size.width / 2,
                    centerY = size.height / 2,
                    rounding = CornerRounding(
                        size.minDimension / 10f,
                        smoothing = 0.1f
                    )
                )
                val roundedPolygonPath = roundedPolygon.toPath().asComposePath()
                onDrawBehind {
                    rotate(180f){
                        drawPath(roundedPolygonPath, color = color)
                    }
                }
            }
    )
}

@Composable
fun RightFacingButton(modifier: Modifier) {
    val color = MaterialTheme.colorScheme.tertiary
    Box(
        modifier = modifier
            .drawWithCache {
                val roundedPolygon = RoundedPolygon(
                    numVertices = 3,
                    radius = size.minDimension / 2,
                    centerX = size.width / 2,
                    centerY = size.height / 2,
                    rounding = CornerRounding(
                        size.minDimension / 10f,
                        smoothing = 0.1f
                    )
                )
                val roundedPolygonPath = roundedPolygon.toPath().asComposePath()
                onDrawBehind {
                    drawPath(roundedPolygonPath, color = color)
                }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun Previews() {
    DragonsPuzzlesTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            semicircle(Modifier.size(60.dp))
            cyanArc(Modifier.size(60.dp))
            cross(Modifier.size(60.dp))
            downUp(Modifier.size(60.dp))
            moonMountain(Modifier.size(60.dp))
            LeftFacingButton(Modifier.size(60.dp))
            RightFacingButton(Modifier.size(60.dp))
        }
    }
}