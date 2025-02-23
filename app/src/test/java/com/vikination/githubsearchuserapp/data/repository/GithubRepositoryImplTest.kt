package com.vikination.githubsearchuserapp.data.repository

import app.cash.turbine.test
import com.vikination.githubsearchuserapp.data.models.ResultState
import com.vikination.githubsearchuserapp.data.models.SearchUserResponse
import com.vikination.githubsearchuserapp.data.source.local.dao.UserDao
import com.vikination.githubsearchuserapp.data.source.remote.GithubApiService
import com.vikination.githubsearchuserapp.data.source.remote.utils.NetworkUtils
import com.vikination.githubsearchuserapp.data.utils.Dummy
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertEquals

class GithubRepositoryImplTest {
    private val apiService :GithubApiService = mockk()
    private val userDao :UserDao = mockk()
    private val networkUtils :NetworkUtils = mockk()
    private lateinit var repo :GithubRepositoryImpl

    @Before
    fun setup(){
        repo = GithubRepositoryImpl(apiService, userDao, networkUtils)
    }

    @After
    fun tearDown(){
        clearAllMocks()
    }

    @Test
    fun `getCachedUsers should return users from database`() = runTest{
        val users = listOf(Dummy.getDummyUser())

        coEvery { userDao.getAllLocalUsers() } returns flowOf(users.map { it.toUserEntity() })

        repo.getCachedUsers().test {
            assertEquals(users, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `getUserDetail should return user from database if available`() = runTest {
        val username = Dummy.getDummyUserEntity().username
        val cachedUser = Dummy.getDummyUserEntity().toUser()

        every { userDao.getUserDetail(username) } returns flowOf(Dummy.getDummyUserEntity())
        every { networkUtils.isInternetAvailable() } returns false

        repo.getUserDetail(username).test {
            assertEquals(ResultState.Loading, awaitItem())
            assertEquals(ResultState.Success(cachedUser), awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `searchUser should return API result and cache them`() = runTest {
        val query = "viki"
        val users = listOf(Dummy.getDummyGithubUser())
        val apiResponse = SearchUserResponse(
            totalCount = 1,
            incompleteResults = false,
            items = users
        )

        every { networkUtils.isInternetAvailable() } returns true
        coEvery { apiService.searchUsers(query) } returns Response.success(apiResponse)
        coEvery { userDao.clearUsers() } just Runs
        coEvery { userDao.insertUsers(any()) } just Runs

        repo.searchUser(query).test {
            assertEquals(ResultState.Loading, awaitItem())
            assertEquals(ResultState.Success(users.map { it.toUser() }), awaitItem())
            awaitComplete()
        }

    }
}