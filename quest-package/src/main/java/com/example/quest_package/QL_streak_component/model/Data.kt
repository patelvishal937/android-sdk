package com.example.quest_package.QL_streak_component.model

data class Data(
    val __v: Int,
    val _id: String,
    val actions: List<Any>,
    val campaignId: String,
    val campaignVariationId: String,
    val createdAt: String,
    val description: String,
    val entityId: String,
    val hasReferral: Boolean,
    val isChild: Boolean,
    val isClaimed: Boolean,
    val isEnabled: Boolean,
    val isParent: Boolean,
    val metadata: Metadata,
    val referralXp: Int,
    val rewards: List<Reward>,
    val sdkConfig: SdkConfig,
    val tags: List<Any>,
    val title: String,
    val updatedAt: String,
    val variation: String,
    val visibility: String
)