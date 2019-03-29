package com.radlab.finka.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.radlab.finka.R
import com.radlab.finka.adapters.BucketTypeAdapter
import com.radlab.finka.adapters.FinkaWorkersAdapter
import com.radlab.finka.data.FinkaWorkerFragmentViewModel
import com.radlab.finka.databinding.FragmentFinkaWorkerBinding
import com.radlab.finka.interfaces.FinkaActivityInterface
import com.radlab.finka.interfaces.FinkaFragmentInterface
import kotlinx.android.synthetic.main.fragment_finka_worker.*

class FinkaWorkesListrFragment : Fragment(), FinkaFragmentInterface {


    private val finkaWorkerFragmentViewModel = FinkaWorkerFragmentViewModel()
    private lateinit var listener: FinkaActivityInterface

    companion object {
        private const val KEY = "my_key"
        private const val KEY_interface = "my_key_interface"
        fun newInstance(user: String) = FinkaWorkesListrFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, user)
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FinkaActivityInterface) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement FinkaActivityInterface.")
        }
    }

    override fun onBucketSelected(name: String?) {
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentFinkaWorkerBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_finka_worker, container, false)
        binding.model = finkaWorkerFragmentViewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
                val adapter = FinkaWorkersAdapter(finkaWorkerFragmentViewModel.getWorkersList(), context!!, listener)
        buckets_recyclerView.layoutManager = GridLayoutManager(context, 4)
        buckets_recyclerView.adapter = adapter  }
}