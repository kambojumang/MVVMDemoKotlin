package umang.kamboj.mvvmdemokotlin.view.adapter


import android.view.ViewGroup

import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView


import umang.kamboj.mvvmdemokotlin.R
import umang.kamboj.mvvmdemokotlin.databinding.ProjectListItemBinding
import umang.kamboj.mvvmdemokotlin.service.model.Project
import umang.kamboj.mvvmdemokotlin.view.callback.ProjectClickCallback

import java.util.*


class ProjectAdapter(private val projectList: MutableList<Project>, private val projectClickCallback: ProjectClickCallback): RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = DataBindingUtil.inflate<ProjectListItemBinding>(LayoutInflater.from(parent.context), R.layout.project_list_item,
                        parent, false)

        binding.callback=projectClickCallback

        return ProjectViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return projectList!!.size
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.binding.project=projectList?.get(position)
        holder.binding.executePendingBindings()
    }

    class ProjectViewHolder(val binding: ProjectListItemBinding) : RecyclerView.ViewHolder(binding.root)
}