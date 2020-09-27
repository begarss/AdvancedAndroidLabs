package com.example.studentlistmvvm.ui

import android.view.View
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.studentlistmvvm.BR
import com.example.studentlistmvvm.model.dataClass.Student
import com.example.studentlistmvvm.ui.adapter.OnStudentListener
import kotlinx.android.synthetic.main.student_item_row.view.*

class StudentListViewHolder internal constructor(
    private val dataBinding: ViewDataBinding,
    onStudentListener: OnStudentListener

):RecyclerView.ViewHolder(dataBinding.root),View.OnClickListener {
    private val title: TextView = itemView.tvTitle

    private val listener = onStudentListener
    fun bind(student: Student, position: Int) {
        val index = position + 1
        title.text = "Student $index "
        dataBinding.setVariable(BR.itemData,student)
        dataBinding.executePendingBindings()


        itemView.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        listener.onStudentClick(adapterPosition)
    }
}