package com.radlab.finka.data

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class FinkaViewModel : ViewModel() {
    val name = "Ray"
    val lastName = "Locooo"
    val workersList: ArrayList<String> = ArrayList()

    fun onLike() {
        workersList.add("new item")
    }

    fun  getAdapterList():ArrayList<String>{
        mockWorkers()
        return workersList
    }

    fun mockWorkers():ArrayList<String>{
        for (i in 1..60)
            workersList.add(""+i)
        return workersList
    }
}
