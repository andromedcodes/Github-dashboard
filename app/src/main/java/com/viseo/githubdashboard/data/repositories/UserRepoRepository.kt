package com.viseo.githubdashboard.data.repositories

import com.viseo.githubdashboard.data.responses.UserRepositoriesResponse
import com.viseo.githubdashboard.network.GithubServices
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class UserRepoRepository @Inject constructor(private val api: GithubServices) {

    fun getRepositories(username: String): Deferred<UserRepositoriesResponse> =
        api.getReposByUsernameAsync(username)
}