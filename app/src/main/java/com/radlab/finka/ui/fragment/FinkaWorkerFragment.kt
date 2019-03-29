package com.radlab.finka.ui.fragment

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
import com.radlab.finka.data.FinkaWorkerFragmentViewModel
import com.radlab.finka.databinding.FragmentFinkaWorkerBinding
import com.radlab.finka.interfaces.FinkaFragmentInterface
import kotlinx.android.synthetic.main.fragment_finka_worker.*

class FinkaWorkerFragment : Fragment(), FinkaFragmentInterface {

    private val finkaWorkerFragmentViewModel = FinkaWorkerFragmentViewModel()

    companion object {
        private const val KEY = "my_key"
        fun newInstance(user: String) = FinkaWorkerFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, user)
            }
        }
    }

    override fun onBucketSelected(name: String?) {
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentFinkaWorkerBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_finka_worker, container, false)

        //buckets_recyclerView.layoutManager = GridLayoutManager(context, 4)
        binding.model = finkaWorkerFragmentViewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val worker: String = arguments?.getString(KEY)!!

        finkaWorkerFragmentViewModel.setWorker(worker)
//        buckets_recyclerView.adapter =
//            BucketTypeAdapter(finkaWorkerFragmentViewModel.getBucketTypeListList(), context!!, this)
//

        val adapter =  BucketTypeAdapter(finkaWorkerFragmentViewModel.getBucketTypeListList(), context!!, this)
        //buckets_recyclerView.layoutManager = GridLayoutManager(context, 4)
        buckets_recyclerView.layoutManager = LinearLayoutManager(context)

        buckets_recyclerView.adapter = adapter
    }
}