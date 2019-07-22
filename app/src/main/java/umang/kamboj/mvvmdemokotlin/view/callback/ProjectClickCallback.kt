package umang.kamboj.mvvmdemokotlin.view.callback

import android.view.View
import umang.kamboj.mvvmdemokotlin.service.model.Project


interface ProjectClickCallback {
    fun onClick(view: View, project: Project)
}