package umang.kamboj.mvvmdemokotlin.view.ui


import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


import kotlinx.android.synthetic.main.activity_register.*
import umang.kamboj.mvvmdemokotlin.R
import umang.kamboj.mvvmdemokotlin.databinding.ActivityRegisterBinding
import umang.kamboj.mvvmdemokotlin.service.model.User
import umang.kamboj.mvvmdemokotlin.view.callback.RegisterActivityCallback
import umang.kamboj.mvvmdemokotlin.viewmodel.UserViewModel

class RegisterActivity : AppCompatActivity(), RegisterActivityCallback {
    lateinit var activityRegisterBinding: ActivityRegisterBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding= DataBindingUtil.setContentView(this, R.layout.activity_register)
        activityRegisterBinding.registerActivityCallback=this
        userViewModel= ViewModelProviders.of(this, UserViewModel.Factory(this)).get(UserViewModel::class.java)

    }

    override fun onRegisterClick(view: View) {
        observeRegister(User(activityRegisterBinding.edtName.text.toString(),
                            activityRegisterBinding.edtEmail.text.toString(),
                            activityRegisterBinding.edtMobile.text.toString(),
                            activityRegisterBinding.edtPassword.text.toString()))
    }

    private fun observeRegister(user: User){
        userViewModel?.registerUser(user).observe(this, Observer { user->
            if (user != null) {
                Toast.makeText(applicationContext, "Register Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Register Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
