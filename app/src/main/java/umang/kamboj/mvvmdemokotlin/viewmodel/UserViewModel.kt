package umang.kamboj.mvvmdemokotlin.viewmodel


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


import umang.kamboj.mvvmdemokotlin.service.model.User
import umang.kamboj.mvvmdemokotlin.service.repository.UserRepository

class UserViewModel(val context: Context): ViewModel() {

    fun loginUser(email: String, password: String): LiveData<User> {
        return UserRepository.getInstance(context).login(email, password)
    }

    fun registerUser(user: User): LiveData<User>{
        return UserRepository.getInstance(context).register(user)
    }

    override fun onCleared() {
        super.onCleared()
    }

    class Factory(val context: Context) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return UserViewModel(context) as T
        }
    }
}