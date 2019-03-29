package com.radlab.finka.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.radlab.finka.R
import com.radlab.finka.data.FinkaWorkerFragmentViewModel
import com.radlab.finka.databinding.FragmentFinkaWorkerBinding

class FinkaWorkerFragment : Fragment() {

    private val finkaWorkerFragmentViewModel = FinkaWorkerFragmentViewModel()

    companion object {
        private const val KEY = "my_key"
        fun newInstance(user: String) = FinkaWorkerFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, user)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentFinkaWorkerBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_finka_worker, container, false)

        binding.model = finkaWorkerFragmentViewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val worker: String = arguments?.getString(KEY)!!
        finkaWorkerFragmentViewModel.setWorker(worker)
    }

}