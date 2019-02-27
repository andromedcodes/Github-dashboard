package com.viseo.githubdashboard.data.responses

import com.google.gson.annotations.SerializedName
import com.viseo.githubdashboard.data.models.User

data class SearchUserResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val isResultComplete: Boolean,
    @SerializedName("items") val items: List<User>
)