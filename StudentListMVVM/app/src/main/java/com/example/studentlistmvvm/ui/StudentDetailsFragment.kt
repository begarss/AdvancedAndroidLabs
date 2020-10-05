package com.example.studentlistmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.studentlistmvvm.BR
import com.example.studentlistmvvm.R
import com.example.studentlistmvvm.databinding.ListFragmentBinding
import com.example.studentlistmvvm.databinding.StudentDetailsBinding
import com.example.studentlistmvvm.viewmodel.RepoListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudentDetailsFragment : Fragment() {
    private lateinit var  dataBinding: StudentDetailsBinding
    private val listViewModel : RepoListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = StudentDetailsBinding.inflate(inflater, container, false).apply {
            viewmodel =
                listViewModel
            lifecycleOwner = viewLifecycleOwner
        }
//        dataBinding = DataBindingUtil.setContentView(requireActivity(), R.layout.student_details)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("id")

        if (id != null) {
            dataBinding.viewmodel?.fetchStudentDetails(id)

        }

        setObservers()
    }

    private fun setObservers() {
        dataBinding.viewmodel?.student?.observe(viewLifecycleOwner, Observer {
            var view = dataBinding.root
            dataBinding.setVariable(BR.studentData,it)
            dataBinding.executePendingBindings()
        })


    }


}