package umang.kamboj.mvvmdemokotlin.view.ui


import android.content.Intent


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import umang.kamboj.mvvmdemokotlin.R
import umang.kamboj.mvvmdemokotlin.databinding.ActivityLoginBinding
import umang.kamboj.mvvmdemokotlin.view.callback.LoginActivityCallback
import umang.kamboj.mvvmdemokotlin.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity(), LoginActivityCallback {

    private var activityLoginBinding: ActivityLoginBinding?=null
    private var userViewModel: UserViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding= DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding?.loginActivityCallback=this
        userViewModel= ViewModelProviders.of(this, UserViewModel.Factory(this)).get(UserViewModel::class.java)
    }

    override fun onLoginClick(view: View) {
        observeLogin(activityLoginBinding?.edtEmail?.text.toString(), activityLoginBinding?.edtPassword?.text.toString())
    }

    override fun onRegisterClick(view: View) {
        val mainIntent=Intent(this, RegisterActivity::class.java)
        startActivity(mainIntent)
    }

    private fun observeLogin(email: String, password: String){

        Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
        val mainIntent=Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
        finish()
//        userViewModel?.loginUser(email, password)?.observe(this, Observer { loginUser->
//            if(loginUser!=null){
//               Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
//                val mainIntent=Intent(this, MainActivity::class.java)
//                startActivity(mainIntent)
//                finish()
//            }else{
//                Toast.makeText(applicationContext, "Login Failed, please try again", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}
