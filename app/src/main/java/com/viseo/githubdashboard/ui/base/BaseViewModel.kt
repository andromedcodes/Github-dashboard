package com.viseo.githubdashboard.ui.base

import android.arch.lifecycle.ViewModel
import com.viseo.githubdashboard.di.DaggerViewModelComponent
import com.viseo.githubdashboard.di.ViewModelComponent
import com.viseo.githubdashboard.di.modules.DataModule
import com.viseo.githubdashboard.di.modules.NetworkingModule
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {

    lateinit var asyncJob: Job

    private val injector: ViewModelComponent =
        DaggerViewModelComponent.builder()
            .bindDataModule(DataModule)
            .bindNetworkModule(NetworkingModule)
            .build()

    init {
        when (this) {
            //is
        }
    }

    override fun onCleared() {
        asyncJob.cancel()
        super.onCleared()
    }
}