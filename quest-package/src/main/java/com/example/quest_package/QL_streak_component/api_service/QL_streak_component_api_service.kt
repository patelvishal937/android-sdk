package com.example.quest_package.QL_streak_component.api_service

import com.example.quest_package.QL_streak_component.model.QLStreakComponentResponse
import com.example.quest_package.QL_streak_component.model.QL_streak_counter.QLStreakCounter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path



interface QLStreakComponentApiService {
    @GET("api/entities/{entityId}/users/{userId}/metrics/{metricName}")
    suspend fun fetchStreakCounterData(
        @Path("entityId") entityId: String,
        @Path("userId") userId: String,
        @Path("metricName") metricName: String,
        @Header("apikey") apiKey: String,
        @Header("token") token: String,
        @Header("userid") userIdHeader: String
    ): QLStreakCounter

    @GET("api/v2/entities/{entityId}/campaigns/{campaignsId}")
    suspend fun fetchStreakDetails(
        @Path("entityId") entityId: String,
        @Path("campaignsId") campaignsId: String,
        @Header("apikey") apiKey: String,
        @Header("token") token: String,
        @Header("userid") userIdHeader: String
    ): QLStreakComponentResponse
}

object RetrofitInstance {
    private const val BASE_URL = "https://staging-api.questlabs.ai/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val qlStreakComponentApiService: QLStreakComponentApiService by lazy {
        retrofit.create(QLStreakComponentApiService::class.java)
    }
}
