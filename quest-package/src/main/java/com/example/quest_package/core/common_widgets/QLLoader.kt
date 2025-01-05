import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quest_package.R


@Composable
fun ZoomInZoomOutLoader() {
    val scale: Float = animateFloatAsState(
        targetValue = 1.5f, // Zoom-in scale
    ).value

    val image: Painter = painterResource(id = R.drawable.jyve_logo) // Replace with your actual image resource

    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale
                )
                .align(Alignment.Center)

        )
    }

}
