package com.vikination.githubsearchuserapp.di

import com.vikination.githubsearchuserapp.data.repository.GithubRepositoryImpl
import com.vikination.githubsearchuserapp.data.source.remote.GithubApiService
import com.vikination.githubsearchuserapp.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubRepository(githubApiService: GithubApiService): GithubRepository =
        GithubRepositoryImpl(githubApiService)

}