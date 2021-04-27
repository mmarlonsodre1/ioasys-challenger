package com.example.ioasys.sections.home.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.ioasys.MyApplication
import com.example.ioasys.R
import kotlinx.android.synthetic.main.adapter_list.view.*
import kotlinx.android.synthetic.main.fragment_detail_enterprise.*

class DetailEnterprise : Fragment() {
    val args: DetailEnterpriseArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_enterprise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_description?.text = args.enterprise.description
        Glide.with(this)
            .load("${MyApplication().BASE_URL}${args.enterprise.photo}")
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .into(iv_description)
    }
}