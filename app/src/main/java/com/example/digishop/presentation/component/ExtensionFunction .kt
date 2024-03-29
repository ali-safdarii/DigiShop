package com.example.digishop.presentation.component

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp


fun displayToast(context:Context, msg:String){

    Toast.makeText(context,msg, Toast.LENGTH_LONG).show()
}




// Define a custom modifier that draws a bottom border with the specified color and stroke width
fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx / 2

            // Draw the bottom border
            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)


fun Modifier.topBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            // Draw the top border
            drawLine(
                color = color,
                start = Offset(x = 0f, y = strokeWidthPx / 2),
                end = Offset(x = size.width, y = strokeWidthPx / 2),
                strokeWidth = strokeWidthPx
            )
        }
    }
)
