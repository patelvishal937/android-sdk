package com.example.quest_package.QL_streak_component.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quest_package.QL_streak_component.api_service.RetrofitInstance
import com.example.quest_package.QL_streak_component.model.QLStreakComponentResponse
import com.example.quest_package.QL_streak_component.model.QL_streak_counter.QLStreakCounter
import com.example.quest_package.QL_streak_component.repository.QLStreakRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import java.text.SimpleDateFormat
import java.util.*

//class QLStreakViewModel : ViewModel() {
//    private val repository = QLStreakRepository(RetrofitInstance.qlStreakComponentApiService)
//
//    private val _streakDetails = MutableLiveData<QLStreakComponentResponse?>()
//    val streakDetails: LiveData<QLStreakComponentResponse?> = _streakDetails
//
//    private val _streakCounterData = MutableLiveData<QLStreakCounter?>()
//    val streakCounterData: LiveData<QLStreakCounter?> = _streakCounterData
//
//    private val _isLoading = MutableLiveData<Boolean>()
//    val isLoading: LiveData<Boolean> = _isLoading
//
//    private val _errorMessage = MutableLiveData<String?>()
//    val errorMessage: LiveData<String?> = _errorMessage
//
//    fun fetchStreakDetailsAndCounter(
//        entityId: String,
//        campaignsId: String,
//        apiKey: String,
//        userId: String,
//        metricName: String
//    ) {
//        viewModelScope.launch {
//            _isLoading.value = true
//            _errorMessage.value = null
//
//            try {
//                // Fetch streak details
//                val counterData = repository.qLStreakDetails(
//                    entityId= "e-d06283d3-d671-4f3c-a829-ffcfdb0f29f7",
//                    apiKey = "k-6fe7e7dc-ac8f-44a1-8bbf-a1754ddf88be",
//                    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1LTE5NzYzOWYxLWNmNGUtNGJiYy1hNDEyLTYxN2I2Zjc4NDhjMiIsImlhdCI6MTczNjA3NDE5OSwiZXhwIjoxNzM4NjY2MTk5fQ.sIBuvoucZf2J0UmCAhtrwRrKdJuRkylHBRc07NiLams",
//                    campaignsId = "c-917e4fc9-67a8-4b1c-87d4-148491dde192",
//                    userIdHeader = "u-197639f1-cf4e-4bbc-a412-617b6f7848c2"
//                )
//                _streakDetails.value = counterData
//                // Fetch streak counter data using metric name from details
//                val details = repository.qLStreakCounterDetails(
//                    userId = "u-197639f1-cf4e-4bbc-a412-617b6f7848c2",
//                    metricName = "5xp-streak",
//                    apiKey = "k-55efda92-975a-4070-8283-f1a77eb2b1c5",
//                    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1LTE5NzYzOWYxLWNmNGUtNGJiYy1hNDEyLTYxN2I2Zjc4NDhjMiIsImlhdCI6MTczNjA3NDE5OSwiZXhwIjoxNzM4NjY2MTk5fQ.sIBuvoucZf2J0UmCAhtrwRrKdJuRkylHBRc07NiLams",
//                    entityId = "e-d06283d3-d671-4f3c-a829-ffcfdb0f29f7"
//                )
//                _streakCounterData.value = details
//            } catch (e: Exception) {
//                _errorMessage.value = e.localizedMessage
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
//}



//class QLStreakViewModel : ViewModel() {
//    private val repository = QLStreakRepository(RetrofitInstance.qlStreakComponentApiService)
//
//    // Replace LiveData with mutableStateOf
//    private val _streakDetails = mutableStateOf<QLStreakComponentResponse?>(null)
//    val streakDetails: State<QLStreakComponentResponse?> = _streakDetails
//
//    private val _streakCounterData = mutableStateOf<QLStreakCounter?>(null)
//    val streakCounterData: State<QLStreakCounter?> = _streakCounterData
//
//    private val _isLoading = mutableStateOf(false)
//    val isLoading: State<Boolean> = _isLoading
//
//    private val _errorMessage = mutableStateOf<String?>(null)
//    val errorMessage: State<String?> = _errorMessage
//
//    // Function to fetch streak details and counter
//    fun fetchStreakDetailsAndCounter(
//        entityId: String,
//        campaignsId: String,
//        apiKey: String,
//        userId: String,
//        metricName: String
//    ) {
//        viewModelScope.launch {
//            _isLoading.value = true
//            _errorMessage.value = null
//
//            try {
//                // Fetch streak details
//                val counterData = repository.qLStreakDetails(
//                    entityId = "e-d06283d3-d671-4f3c-a829-ffcfdb0f29f7",
//                    apiKey = "k-6fe7e7dc-ac8f-44a1-8bbf-a1754ddf88be",
//                    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1LTE5NzYzOWYxLWNmNGUtNGJiYy1hNDEyLTYxN2I2Zjc4NDhjMiIsImlhdCI6MTczNjA3NDE5OSwiZXhwIjoxNzM4NjY2MTk5fQ.sIBuvoucZf2J0UmCAhtrwRrKdJuRkylHBRc07NiLams",
//                    campaignsId = "c-917e4fc9-67a8-4b1c-87d4-148491dde192",
//                    userIdHeader = "u-197639f1-cf4e-4bbc-a412-617b6f7848c2"
//                )
//                _streakDetails.value = counterData
//
//                // Fetch streak counter data using metric name from details
//                val details = repository.qLStreakCounterDetails(
//                    userId = "u-197639f1-cf4e-4bbc-a412-617b6f7848c2",
//                    metricName = "5xp-streak",
//                    apiKey = "k-55efda92-975a-4070-8283-f1a77eb2b1c5",
//                    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1LTE5NzYzOWYxLWNmNGUtNGJiYy1hNDEyLTYxN2I2Zjc4NDhjMiIsImlhdCI6MTczNjA3NDE5OSwiZXhwIjoxNzM4NjY2MTk5fQ.sIBuvoucZf2J0UmCAhtrwRrKdJuRkylHBRc07NiLams",
//                    entityId = "e-d06283d3-d671-4f3c-a829-ffcfdb0f29f7"
//                )
//                _streakCounterData.value = details
//            } catch (e: Exception) {
//                _errorMessage.value = e.localizedMessage
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
//}

class QLStreakViewModel : ViewModel() {
    private val repository = QLStreakRepository(RetrofitInstance.qlStreakComponentApiService)

    private val _streakDetails = mutableStateOf<QLStreakComponentResponse?>(null)
    val streakDetails: State<QLStreakComponentResponse?> = _streakDetails

    private val _streakCounterData = mutableStateOf<QLStreakCounter?>(null)
    val streakCounterData: State<QLStreakCounter?> = _streakCounterData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    // Define variables for progress, total, and timeDifference
    private val _progress = mutableStateOf(0.0)
    val progress: State<Double> = _progress

    private val _total = mutableStateOf(24.0)
    val total: State<Double> = _total

    private val _timeDifference = mutableStateOf("24 hours")
    val timeDifference: State<String> = _timeDifference

    // Function to calculate time difference
    fun calculateTimeDifference(lastIncrementedAt: String) {
        // Define the date formatter
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC")

        // Convert the string to a date
        val date = formatter.parse(lastIncrementedAt)
        if (date == null) {
            // Fallback value if the date conversion fails
            _progress.value = 0.0
            _total.value = 24.0
            _timeDifference.value = "24 hours"
            return
        }

        // Get the current time
        val currentTime = Date()

        // Calculate the difference in time
        val timeDifferenceMillis = currentTime.time - date.time
        val totalMinutes = (timeDifferenceMillis / (1000 * 60)).toInt()

        // Subtract the time difference from 1440 minutes (24 hours)
        val remainingMinutes = 1440 - totalMinutes

        if (totalMinutes >= 1440) {
            _timeDifference.value = "24 hours"
            _progress.value = 0.0
            _total.value = 24.0
            return
        }

        if (remainingMinutes < 60) {
            _progress.value = 1440 - remainingMinutes.toDouble()
            _timeDifference.value = "$remainingMinutes minutes"
            _total.value = 1440.0
            return
        }

        val remainingHours = remainingMinutes / 60
        _progress.value = 24 - remainingHours.toDouble()
        _total.value = 24.0
        _timeDifference.value = "$remainingHours hours"
    }

    // Function to fetch streak details and counter
    fun fetchStreakDetailsAndCounter(
        entityId: String,
        campaignsId: String,
        apiKey: String,
        userId: String,
        metricName: String
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                // Fetch streak details
                val counterData = repository.qLStreakDetails(
                    entityId = "e-d06283d3-d671-4f3c-a829-ffcfdb0f29f7",
                    apiKey = "k-6fe7e7dc-ac8f-44a1-8bbf-a1754ddf88be",
                    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1LTE5NzYzOWYxLWNmNGUtNGJiYy1hNDEyLTYxN2I2Zjc4NDhjMiIsImlhdCI6MTczNjA3NDE5OSwiZXhwIjoxNzM4NjY2MTk5fQ.sIBuvoucZf2J0UmCAhtrwRrKdJuRkylHBRc07NiLams",
                    campaignsId = "c-917e4fc9-67a8-4b1c-87d4-148491dde192",
                    userIdHeader = "u-197639f1-cf4e-4bbc-a412-617b6f7848c2"
                )
                _streakDetails.value = counterData

                // Fetch streak counter data using metric name from details
                val details = repository.qLStreakCounterDetails(
                    userId = "u-197639f1-cf4e-4bbc-a412-617b6f7848c2",
                    metricName = "5xp-streak",
                    apiKey = "k-55efda92-975a-4070-8283-f1a77eb2b1c5",
                    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1LTE5NzYzOWYxLWNmNGUtNGJiYy1hNDEyLTYxN2I2Zjc4NDhjMiIsImlhdCI6MTczNjA3NDE5OSwiZXhwIjoxNzM4NjY2MTk5fQ.sIBuvoucZf2J0UmCAhtrwRrKdJuRkylHBRc07NiLams",
                    entityId = "e-d06283d3-d671-4f3c-a829-ffcfdb0f29f7"
                )
                _streakCounterData.value = details
            } catch (e: Exception) {
                _errorMessage.value = e.localizedMessage
            } finally {
                _isLoading.value = false
            }
        }
    }
}


