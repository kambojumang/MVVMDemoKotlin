package umang.kamboj.mvvmdemokotlin.service.room

import androidx.room.*
import androidx.room.OnConflictStrategy.FAIL
import umang.kamboj.mvvmdemokotlin.service.model.User


@Dao
interface UserDao {
    @Insert(onConflict = FAIL)
    fun insertUser(user: User)

    @Query("SELECT * FROM user where email= :email and password= :password")
    fun getUser(email: String, password: String): User

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>

    @Delete
    fun deleteUser(user: User)

    @Update
    fun updateUser(user: User)

    @Query("DELETE FROM user")
    fun deleteAllUser()

}