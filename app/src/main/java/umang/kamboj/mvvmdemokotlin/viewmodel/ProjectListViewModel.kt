package umang.kamboj.mvvmdemokotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


import umang.kamboj.mvvmdemokotlin.service.model.Project
import umang.kamboj.mvvmdemokotlin.service.repository.ProjectRepository


class ProjectListViewModel(application: Application): AndroidViewModel(application) {
    private val projectListObservable= ProjectRepository.getInstance().getProjectList("Google")

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    fun getProjectListObservable(): LiveData<List<Project>> {
        return projectListObservable
    }
}