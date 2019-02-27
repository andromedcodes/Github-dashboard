package com.viseo.githubdashboard.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val userApiUrl: String,
    @SerializedName("html_url") val userHtmlUrl: String,
    @SerializedName("repos_url") val reposUrl: String
)