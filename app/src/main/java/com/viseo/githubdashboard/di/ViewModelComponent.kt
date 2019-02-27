package com.viseo.githubdashboard.di

import com.viseo.githubdashboard.di.modules.DataModule
import com.viseo.githubdashboard.di.modules.NetworkingModule
import com.viseo.githubdashboard.ui.viewmodels.UserReposViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataModule::class, NetworkingModule::class]
)
interface ViewModelComponent {

    /**
     * inject required dependencies into MediaListViewModel
     */
    fun inject(viewModel: UserReposViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelComponent

        fun bindDataModule(dataModule: DataModule): Builder

        fun bindNetworkModule(networkingModule: NetworkingModule): Builder
    }

}