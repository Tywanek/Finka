package com.radlab.finka.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radlab.finka.R
import com.radlab.finka.interfaces.FinkaActivityInterface
import com.radlab.finka.interfaces.FinkaFragmentInterface
import kotlinx.android.synthetic.main.finka_list_item.view.*

class BucketTypeAdapter(
    private val items: ArrayList<String>,
    private val context: Context,
    private val intface: FinkaFragmentInterface
) : RecyclerView.Adapter<BucketTypeViewHolder>() {
    override fun onBindViewHolder(holder: BucketTypeViewHolder, position: Int) {
        holder.tvBucketType.text = items[position]
        holder.tvBucketType.setOnClickListener {
            intface.onBucketSelected(items[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BucketTypeViewHolder {
        return BucketTypeViewHolder(LayoutInflater.from(context).inflate(R.layout.bucket_type_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class BucketTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvBucketType = view.worker_number!!
}