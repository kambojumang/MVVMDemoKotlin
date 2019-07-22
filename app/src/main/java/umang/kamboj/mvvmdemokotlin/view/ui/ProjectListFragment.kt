package umang.kamboj.mvvmdemokotlin.view.ui




import android.os.Bundle

import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


import umang.kamboj.mvvmdemokotlin.R
import umang.kamboj.mvvmdemokotlin.databinding.FragmentProjectListBinding
import umang.kamboj.mvvmdemokotlin.service.model.Project
import umang.kamboj.mvvmdemokotlin.view.adapter.ProjectAdapter
import umang.kamboj.mvvmdemokotlin.view.callback.ProjectClickCallback
import umang.kamboj.mvvmdemokotlin.viewmodel.ProjectListViewModel


class ProjectListFragment: Fragment() {
    private var projectAdapter: ProjectAdapter? = null
    private var binding: FragmentProjectListBinding? = null
    private var projectList= mutableListOf<Project>()
    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?,
                              @Nullable savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false)

        projectAdapter = ProjectAdapter(projectList, projectClickCallback)
        binding?.projectList?.adapter = projectAdapter
        binding?.isLoad = true

        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(ProjectListViewModel::class.java)

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectListViewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, Observer<List<Project>> { projects ->
            if (projects != null) {
                binding?.isLoad=false
                projectList.clear()
                projectList.addAll(projects.toMutableList())
                projectAdapter?.notifyDataSetChanged()
            }
        })
    }

    private val projectClickCallback = object : ProjectClickCallback {
        override fun onClick(view: View, project: Project) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                (activity as MainActivity).show(project)
            }
        }
    }
    companion object {
        val TAG = "ProjectListFragment"
    }
}