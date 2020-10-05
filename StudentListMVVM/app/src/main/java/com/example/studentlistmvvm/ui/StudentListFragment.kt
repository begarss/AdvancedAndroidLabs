package com.example.studentlistmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentlistmvvm.R
import com.example.studentlistmvvm.TopPadding

import com.example.studentlistmvvm.databinding.ListFragmentBinding
import com.example.studentlistmvvm.model.dataClass.Student
import com.example.studentlistmvvm.model.repository.RepoListRepository
import com.example.studentlistmvvm.ui.adapter.Adapter
import com.example.studentlistmvvm.ui.adapter.OnStudentListener
import com.example.studentlistmvvm.viewmodel.RepoListViewModel
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.experimental.property.inject

class StudentListFragment : Fragment(), OnStudentListener {

    private lateinit var viewDataBinding: ListFragmentBinding
    private lateinit var adapter: Adapter
    private val listViewModel : RepoListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = ListFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        viewDataBinding.viewmodel = listViewModel
        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()

        setupAdapter()
        setObservers()
    }


    private fun setObservers() {
        viewDataBinding.viewmodel?.repolistLive?.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it as ArrayList<Student>)
        })


    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = Adapter(this, viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(requireContext())
            recycler.layoutManager = layoutManager
            recycler.addItemDecoration(
                TopPadding(30)
            )
            recycler.adapter = adapter
        }
    }

    override fun onStudentClick(position: Int) {
        val bundle = Bundle()
        bundle.putInt("id", adapter.getList()[position].id)
        val detailFragment = StudentDetailsFragment()
        detailFragment.arguments = bundle
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame, detailFragment)
            ?.addToBackStack("")?.commit()
    }

}