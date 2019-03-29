package com.radlab.finka.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.radlab.finka.R
import com.radlab.finka.adapters.FinkaWorkersAdapter
import com.radlab.finka.data.FinkaViewModel
import com.radlab.finka.interfaces.FinkaActivityInterface
import com.radlab.finka.ui.fragment.FinkaWorkerFragment
import kotlinx.android.synthetic.main.finka_activity.*


class FinkaActivity : AppCompatActivity(), FinkaActivityInterface {
    override fun onWorkerSelected(name: String?) {
        if(name!=null)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FinkaWorkerFragment.newInstance(name))
            .commit()
    }

    private val viewModel = FinkaViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finka_activity)
        val binding: com.radlab.finka.databinding.FinkaActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.finka_activity)

        val adapter = FinkaWorkersAdapter(viewModel.getAdapterList(), this, this)
        recyclerView.layoutManager = GridLayoutManager(this, 4)
        recyclerView.adapter = adapter
    }
}