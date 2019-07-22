package umang.kamboj.mvvmdemokotlin.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import umang.kamboj.mvvmdemokotlin.service.model.Project
import umang.kamboj.mvvmdemokotlin.service.repository.ProjectRepository


class ProjectViewModel(application: Application, projectID: String): AndroidViewModel(application) {
    private val projectObservable: LiveData<Project> = ProjectRepository.getInstance().getProjectDetails("Google", projectID)
    var project: ObservableField<Project> = ObservableField()
    fun getObservableProject(): LiveData<Project> {
        return projectObservable
    }

    fun setProject(project: Project) {
        this.project.set(project)
    }

    class Factory(private val application: Application, private val projectID: String) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ProjectViewModel(application, projectID) as T
        }
    }
}