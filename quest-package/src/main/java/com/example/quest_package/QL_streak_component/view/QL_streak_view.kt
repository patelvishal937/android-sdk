import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quest_package.QL_streak_component.model.StepDetail
import com.example.quest_package.QL_streak_component.viewmodel.QLStreakViewModel



@Composable
fun StreakScreen(viewModel: QLStreakViewModel = viewModel()) {
    val streakDetails by viewModel.streakDetails
    val streakCounterData by viewModel.streakCounterData
    val progress by viewModel.progress
    val timeDifference by viewModel.timeDifference
    val total by viewModel.total
    val isLoading by viewModel.isLoading
    val errorMessage by viewModel.errorMessage

    LaunchedEffect(Unit) {
        viewModel.fetchStreakDetailsAndCounter(
            entityId = "your-entity-id",
            campaignsId = "your-campaign-id",
            apiKey = "your-api-key",
            userId = "your-user-id",
            metricName = "your-metric-name"
        )
    }

    // UI layout
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .shadow(7.dp, shape = RoundedCornerShape(16.dp)) // Shadow with rounded corners
                .clip(RoundedCornerShape(16.dp)) // Clip the content with rounded corners
                .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(16.dp))
                .padding(12.dp)
            , // Padding inside the column
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when {
                isLoading -> {
//                    Text("Loading....")
                    ZoomInZoomOutLoader()

                }
                errorMessage != null -> {
                    Text(text = "Error: $errorMessage", color = Color.Red)
                }
                streakCounterData != null && streakDetails != null -> {
                    val counterValue = streakCounterData?.data
                    val stepDetails = streakDetails?.data

                    Text(
                        text = "${counterValue?.counter ?: "N/A"}",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0d3821)
                    )
                    Text(
                        text = "Streak days",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF0d3821)
                    )
                    Text(
                        text = "This is longest Streak you have ever head ",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color(0xFF2c2c2c),
                        modifier = Modifier
                            .padding(vertical = 14.dp)
                    )

                    StreakStepDetails(stepDetails = stepDetails?.sdkConfig?.uiProps?.stepDetails ?: emptyList(), counterValue = counterValue?.counter ?: 0)


                    QlProgressBar(
                        value = progress,
                        total = total,
                        label = timeDifference
                    )
                }
            }
        }
    }


}

@Composable
fun StreakStepDetails(
    stepDetails: List<StepDetail>, // Assuming StepDetail is a data class holding step information
    counterValue: Int
) {
    Row(
        modifier = Modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp) // Equivalent to .padding(.trailing, 6)
    ) {
        stepDetails.forEach { stepDetail ->
            // Determine if the step is achieved or active
            val isAchieved = stepDetail.range < counterValue
            val isActive = stepDetail.range == counterValue
            QLEarnedPointsView(
                isAchieved = isAchieved,
                isActive = isActive,
                descreptionText = stepDetail.title
            )
        }
    }
}


@Preview
@Composable
fun Preview() {
    StreakScreen()
}



