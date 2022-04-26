package com.beni.mrben.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository ) : ViewModel() {
    val allUsers : LiveData<List<User>> = userRepository.allUsers.asLiveData()

    fun insert(user: User) = viewModelScope.launch{
        userRepository.insert(user)
    }

    class UserViewModelFactory(
        private val userRepository: UserRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}