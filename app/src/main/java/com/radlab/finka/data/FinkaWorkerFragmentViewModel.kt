package com.radlab.finka.data

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class FinkaWorkerFragmentViewModel : ViewModel() {
    var name = ObservableField<String>("")

    fun setWorker(worker: String) {
        name.set(worker)
    }
}