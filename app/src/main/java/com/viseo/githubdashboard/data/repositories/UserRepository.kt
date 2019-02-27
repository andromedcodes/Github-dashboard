package com.viseo.githubdashboard.data.repositories

import com.viseo.githubdashboard.network.GithubServices
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: GithubServices) {

    fun getUser(username: String) = api.lookupUsersByUsernameAsync(username)
}