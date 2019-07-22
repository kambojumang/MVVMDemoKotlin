package umang.kamboj.mvvmdemokotlin.app

import android.app.Application
import android.util.Log
import androidx.room.Room
import umang.kamboj.mvvmdemokotlin.service.room.UserDatabase


class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
//        MyApp.database= Room.databaseBuilder(this, UserDatabase::class.java, "users.db").allowMainThreadQueries().build()
    }
    companion object {
//        lateinit var database: UserDatabase
    }
}