package com.radlab.finka.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.radlab.finka.R
import com.radlab.finka.adapters.ViewPagerAdapter
import com.radlab.finka.interfaces.FinkaActivityInterface
import com.radlab.finka.ui.fragment.FinkaWorkerFragment
import com.radlab.finka.ui.fragment.FinkaWorkesListrFragment
import kotlinx.android.synthetic.main.finka_activity.*

class FinkaActivity : AppCompatActivity(), FinkaActivityInterface{

    private val adapter = ViewPagerAdapter(supportFragmentManager)

    private val finkaWorkesListrFragment: FinkaWorkesListrFragment = FinkaWorkesListrFragment()

    private val finkaWorkerFragment: FinkaWorkerFragment = FinkaWorkerFragment()

    override fun onWorkerSelected(name: String?) {
        finkaWorkerFragment.finkaWorkerFragmentViewModel.setWorker(name!!)
        viewPager.setCurrentItem(2, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finka_activity)
        adapter.addFragment(finkaWorkesListrFragment, "ONE")
        adapter.addFragment(finkaWorkerFragment, "TWO")

        if (viewPager != null) {
            viewPager.adapter = adapter
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@FinkaActivity)
        builder.setTitle(getString(R.string.alert_dialog_title_close_app))
        builder.setMessage(getString(R.string.alert_dialog_message_close_app))
        builder.setPositiveButton(getString(R.string.alert_dialog_close_app_yes_button)){ dialog, which ->
           this.finish()
        }
        builder.setNeutralButton(getString(R.string.alert_dialog_close_app_cancel_button)){ _, _ ->
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}