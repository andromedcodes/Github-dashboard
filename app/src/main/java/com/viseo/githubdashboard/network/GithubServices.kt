package com.viseo.githubdashboard.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubServices {

    @GET("/search/users")
    fun lookupUsersByUsername(@Query("q") username: String): Response<Void>

    @GET("/users/{username}/repos")
    fun getReposByUsername(@Path("username") username: String): Response<Void>

    @GET("/repos/{username}/{repo_name}")
    fun getRepoDetails(
        @Path("username") username: String,
        @Path("repo_name") repoName: String
    ): Response<Void>
}