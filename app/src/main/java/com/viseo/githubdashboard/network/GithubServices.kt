package com.viseo.githubdashboard.network

import com.viseo.githubdashboard.data.responses.SearchUserResponse
import com.viseo.githubdashboard.data.responses.UserRepositoriesResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubServices {

    @GET("/search/users")
    fun lookupUsersByUsernameAsync(@Query("q") username: String): Deferred<SearchUserResponse>

    @GET("/users/{username}/repos")
    fun getReposByUsernameAsync(@Path("username") username: String): Deferred<UserRepositoriesResponse>

    @GET("/repos/{username}/{repo_name}")
    fun getRepoDetailsAsync(
        @Path("username") username: String,
        @Path("repo_name") repoName: String
    ): Deferred<Void>
}