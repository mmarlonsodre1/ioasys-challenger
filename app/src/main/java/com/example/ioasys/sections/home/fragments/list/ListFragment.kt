package com.example.ioasys.sections.home.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ioasys.R
import com.example.ioasys.models.Enterprise
import com.example.ioasys.sections.home.Home
import com.example.ioasys.sections.home.fragments.detail.DetailEnterpriseArgs
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_loading.*

class ListFragment : Fragment(), ListInterface {
    val presenter = ListPresenter(
            coroutineScope = lifecycleScope,
            view = this,
            dataProvider = ListDataProvider()
    )

    private val adapter by lazy {
        ListAdapter(this::getEnterprise)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv_items?.adapter = adapter
        presenter.context = context
        NavigationUI.setupWithNavController((activity as Home).toolbar, findNavController())
    }

    private fun getEnterprise(id: Int) {
        presenter.getEnterprise(id)
    }

    override fun goToDetailEnterprise(enterprise: Enterprise) {
        findNavController().navigate(R.id.detail_fragment, DetailEnterpriseArgs(enterprise).toBundle())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.menu, menu)

        val searchView: SearchView? = menu.findItem(R.id.search)?.actionView as SearchView?
        searchView?.queryHint = getString(R.string.search)
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.getList(query.toString())
                tv_empty_search?.isVisible = false
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun updateList(list: List<Enterprise>) {
        tv_empty?.isVisible = false
        rv_items?.isVisible = true
        adapter.list = list
    }

    override fun showEmptyList() {
        tv_empty?.apply {
            text = getString(R.string.empty_list)
            isVisible = true
        }
        rv_items?.isVisible = false
    }

    override fun showLoading() {
        loading?.isVisible = true
    }

    override fun hideLoading() {
        loading?.isVisible = false
    }

    override fun showGenericError() {
        tv_empty?.apply {
            text = getString(R.string.generic_error)
            isVisible = true
        }
        rv_items?.isVisible = false
    }
}