import android.app.Activity
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

fun showAlertQuest(activity: Activity) {
    activity.addContentView(
        ComposeView(activity).apply {
            setContent {
                dialogExample()
            }
        },
        ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    )
}


@Composable
fun dialogExample() {
    val openAlertDialog = remember { mutableStateOf(true) }

    // This is the main content of your composable
    when {
        openAlertDialog.value -> {
            // Replace AlertDialog with CustomDialog
            customDialog(
                onDismissRequest = { openAlertDialog.value = false },
            )
        }
    }
}

@Composable
fun customDialog(
    onDismissRequest: () -> Unit,
) {
    Dialog (
        onDismissRequest = {
            onDismissRequest()
        }
    ) {
        webViewScreen(
            url = "https://master.dx6twpukqhcfh.amplifyapp.com/jyve/spin-the-wheel/?userId=dha",
            modifier = Modifier
                .height(500.dp) // Set height to half of the screen height
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
        )
    }
}