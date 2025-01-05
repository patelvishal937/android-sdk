package com.example.quest_package.QL_streak_component.repository

import com.example.quest_package.QL_streak_component.api_service.QLStreakComponentApiService
import com.example.quest_package.QL_streak_component.model.QLStreakComponentResponse
import com.example.quest_package.QL_streak_component.model.QL_streak_counter.QLStreakCounter

class QLStreakRepository(private val apiService: QLStreakComponentApiService) {

    suspend fun qLStreakDetails(
        entityId: String,
        apiKey: String,
        token: String,
        campaignsId: String,
        userIdHeader: String
    ): QLStreakComponentResponse {
        return apiService.fetchStreakDetails(
            entityId = entityId,
            apiKey = apiKey,
            token = token,
            campaignsId = campaignsId,
            userIdHeader = userIdHeader,
        )
    }

    suspend fun qLStreakCounterDetails(
        entityId: String,
        metricName: String,
        apiKey: String,
        token: String,
        userId: String
    ): QLStreakCounter {
        return apiService.fetchStreakCounterData(
            entityId = entityId,
            apiKey = apiKey,
            token = token,
            userIdHeader = userId,
            metricName = metricName,
            userId = userId,
        )
    }
}

