package umang.kamboj.mvvmdemokotlin.service.repository


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import umang.kamboj.mvvmdemokotlin.app.MyApp
import umang.kamboj.mvvmdemokotlin.service.model.User

class UserRepository {
    companion object {
        private var loginRepository: UserRepository? = null
        private var context: Context?=null
        @Synchronized
        @JvmStatic
        fun getInstance(context: Context): UserRepository {
            this.context=context
            if (loginRepository == null) loginRepository = UserRepository()
            return loginRepository!!
        }
    }

    fun login(email: String, password: String): LiveData<User> {
        val loginData= MutableLiveData<User>()
//        val user= MyApp.database?.userDao()?.getUser(email, password)
//        loginData.value=user
        return loginData
    }

    fun register(user: User): LiveData<User>{
        val registerData=MutableLiveData<User>()
//        MyApp.database?.userDao()?.insertUser(user)
        registerData.value=user
        return registerData
    }
}