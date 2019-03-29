package com.radlab.finka.data

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class FinkaWorkerFragmentViewModel : ViewModel() {
    var name = ObservableField<String>("")
    val bucketTypeList: ArrayList<String> = ArrayList()

    fun setWorker(worker: String) {
        name.set(worker)
    }

    fun getBucketTypeListList(): ArrayList<String> {
        bucketTypeList.add(" 10 kg")
        bucketTypeList.add(" 20 kg")
        bucketTypeList.add(" 30 kg")
        bucketTypeList.add(" 40 kg")

        return bucketTypeList;
    }
}