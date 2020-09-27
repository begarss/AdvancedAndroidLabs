package com.example.studentlistmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentlistmvvm.R
import com.example.studentlistmvvm.model.dataClass.Student
import com.example.studentlistmvvm.ui.StudentListViewHolder
import com.example.studentlistmvvm.viewmodel.RepoListViewModel
import com.example.studentlistmvvm.databinding.ListFragmentBinding
import com.example.studentlistmvvm.databinding.StudentItemRowBinding


class Adapter internal constructor(
    listener: OnStudentListener,
    private val repoListViewModel: RepoListViewModel
) :
    RecyclerView.Adapter<StudentListViewHolder>() {
    private var listener: OnStudentListener = listener

    private var items: ArrayList<Student> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        val databinding = StudentItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StudentListViewHolder(
            databinding, listener
        )
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        when (holder) {
            is StudentListViewHolder -> {
                holder.bind(items.get(position), position)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(studentList: ArrayList<Student>) {
        items = studentList
        notifyDataSetChanged()
    }

    fun getList(): ArrayList<Student> {
        return items as ArrayList<Student>
    }
}

internal interface OnStudentListener {
    fun onStudentClick(position: Int)
}