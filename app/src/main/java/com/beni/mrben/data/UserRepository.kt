package com.beni.mrben.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDAO) {
    val allUsers: Flow<List<User>> = userDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User) {
        0
        userDao.insert(user)
    }
}