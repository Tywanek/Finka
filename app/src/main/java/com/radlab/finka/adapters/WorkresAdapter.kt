package com.radlab.finka.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radlab.finka.R
import com.radlab.finka.data.Worker
import com.radlab.finka.interfaces.FinkaActivityInterface
import kotlinx.android.synthetic.main.finka_list_item.view.*

class FinkaWorkersAdapter(
    private val items: ArrayList<Worker>,
    private val context: Context,
    private val intface: FinkaActivityInterface) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.finka_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvFinkaWorkerName.text = items[position].name
        holder.tvFinkaWorkerNumber.text = items[position].id_number.toString()
        holder.cardView.setOnClickListener {
            intface.onWorkerSelected(items[position].name)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvFinkaWorkerName = view.worker_name!!
    val tvFinkaWorkerNumber = view.worker_number!!
    val cardView = view.cardView!!
}