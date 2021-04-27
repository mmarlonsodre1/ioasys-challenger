package com.example.ioasys.sections.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.ioasys.R
import com.example.ioasys.models.Enterprise
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_loading.*

class Home : AppCompatActivity(), HomeInterface {
    val presenter = HomePresenter(
            context = this,
            coroutineScope = lifecycleScope,
            view = this,
            dataProvider = HomeDataProvider()
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        val searchView: SearchView? = menu?.findItem(R.id.search)?.actionView as SearchView?
        searchView?.queryHint = getString(R.string.search)
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.getList(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        return true
    }

    override fun updateList(list: List<Enterprise>) {
        TODO("Not yet implemented")
    }

    override fun showEmptyList() {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        loading?.isVisible = true
    }

    override fun hideLoading() {
        loading?.isVisible = false
    }
}