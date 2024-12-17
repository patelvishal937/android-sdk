import android.content.Context
import android.widget.Toolbar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

fun qlCoinComposeToolbar(context: Context, toolbar: Toolbar, imageUrl: String) {
    val composeView = ComposeView(context).apply {
        setContent {
            qlCoinComponent(imageUrl)
        }
    }

    val layoutParams = Toolbar.LayoutParams(
        Toolbar.LayoutParams.WRAP_CONTENT,
        Toolbar.LayoutParams.WRAP_CONTENT
    ).apply {
        gravity = android.view.Gravity.END // Align to the rightmost side
    }

    composeView.layoutParams = layoutParams

    // Add ComposeView to the toolbar at the start (index 0)
    toolbar.addView(composeView)
}

@Composable
fun qlCoinComponent(imageUrl: String) {
    Row (
        modifier = Modifier
            .padding(4.dp) // Margin around the Row
            .background(
                color = Color.White,
                shape = RoundedCornerShape(50) // Circular shape
            )
            .border(1.dp, Color.Gray, RoundedCornerShape(50)) // Border around the background
            .padding(4.dp), // Padding inside the Row
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier.width(4.dp))
//        AsyncImage(
//            model = imageUrl,
//            contentDescription = null,
//            modifier = Modifier.size(24.dp), // Set the desired size for the image
//            contentScale = androidx.compose.ui.layout.ContentScale.Fit
//        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("1",
            style = TextStyle(color = Color.Black)
        )
        Spacer(modifier = Modifier.width(4.dp))
    }

}