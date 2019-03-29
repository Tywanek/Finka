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

    fun getWorkersList(): ArrayList<Worker> {
        val workersList: ArrayList<Worker> = ArrayList()
        workersList.add(Worker("Jesus Maria","Sanchez Villegas",1))
        workersList.add(Worker("Carlos","Sanchez Villegas",2))
        for (i in 3..60){
            workersList.add(Worker("Jose Manuel","Sanchez Villegas",i))
        }

        return workersList
    }
}