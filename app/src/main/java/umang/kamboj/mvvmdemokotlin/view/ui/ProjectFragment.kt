package umang.kamboj.mvvmdemokotlin.view.ui



import android.os.Bundle

import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import umang.kamboj.mvvmdemokotlin.R
import umang.kamboj.mvvmdemokotlin.databinding.FragmentProjectDetailsBinding
import umang.kamboj.mvvmdemokotlin.service.model.Project
import umang.kamboj.mvvmdemokotlin.viewmodel.ProjectViewModel


class ProjectFragment: Fragment() {
    private var binding: FragmentProjectDetailsBinding? = null

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?,
                              @Nullable savedInstanceState: Bundle?): View? {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_details, container, false)

        // Create and set the adapter for the RecyclerView.
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = ProjectViewModel.Factory(
                activity!!.application, arguments!!.getString(KEY_PROJECT_ID)!!)

        val viewModel = ViewModelProviders.of(this, factory)
                .get(ProjectViewModel::class.java)

        binding?.projectViewModel=viewModel
        binding?.isLoad=true

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectViewModel) {
        // Observe project data
        viewModel.getObservableProject().observe(this, Observer<Project> { project ->
            if (project != null) {
                binding?.isLoad=false
                viewModel.setProject(project)
            }
        })
    }

    companion object {
        private val KEY_PROJECT_ID = "project_id"
        /** Creates project fragment for specific project ID  */
        @JvmStatic
        fun forProject(projectID: String): ProjectFragment {
            val fragment = ProjectFragment()
            val args = Bundle()

            args.putString(KEY_PROJECT_ID, projectID)
            fragment.arguments = args

            return fragment
        }
    }
}