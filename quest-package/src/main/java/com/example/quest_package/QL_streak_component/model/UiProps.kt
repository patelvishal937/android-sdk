package com.example.quest_package.QL_streak_component.model

data class UiProps(
    val BrandTheme: BrandTheme,
    val apiKey: String,
    val entityId: String,
    val filledStreakImg: String,
    val metric: String,
    val pendingStreakImg: String,
    val questThemeData: QuestThemeData,
    val stepDetails: List<StepDetail>,
    val styleConfig: StyleConfig,
    val token: String,
    val userId: String
)