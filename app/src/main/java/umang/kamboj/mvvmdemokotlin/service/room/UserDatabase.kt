package umang.kamboj.mvvmdemokotlin.service.room


import androidx.room.Database
import androidx.room.RoomDatabase
import umang.kamboj.mvvmdemokotlin.service.model.User


@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}