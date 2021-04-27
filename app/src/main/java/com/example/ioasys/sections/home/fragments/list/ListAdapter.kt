package com.example.ioasys.sections.home.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ioasys.MyApplication
import com.example.ioasys.R
import com.example.ioasys.models.Enterprise
import kotlinx.android.synthetic.main.adapter_list.view.*

class ListAdapter(
    private val action: (id: Int) -> Unit
) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>(){
    var list: List<Enterprise> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_list,
                parent,
                false
        )
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position], action)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(enterprise: Enterprise, action: (id: Int) -> Unit) = with(itemView) {
            tv_title?.text = enterprise.enterpriseName
            tv_subtitle.text = enterprise.enterpriseType?.enterpriseTypeName
            tv_country.text = context.getString(R.string.enterprise_location, enterprise.city, enterprise.country)
            Glide.with(this)
                .load("${MyApplication().BASE_URL}${enterprise.photo}")
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(iv_list)

            setOnClickListener {
                enterprise.id?.let { action.invoke(it) }
            }
        }
    }
}