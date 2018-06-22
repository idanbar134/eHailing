package com.ehailing.ehailing.ui.taxis

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.ehailing.ehailing.R
import com.ehailing.ehailing.base.BaseFragment
import kotlinx.android.synthetic.main.taxi_fragment.*
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.inject

class TaxiFragment : BaseFragment() {

    private val viewModel: TaxiViewModel by viewModel()
    private val adapter: TaxiAdapter by inject()

    override fun layoutId(): Int = R.layout.taxi_fragment

    companion object {
        fun newInstance() = TaxiFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        viewModel.getStations()
    }

    private fun initRecyclerView() {
        recyclerView.adapter = adapter
    }

    override fun render() {
        viewModel.uiData.observe(this, Observer {
            adapter.stations = it ?: listOf()
        })

        viewModel.failure.observe(this, Observer {

        })

    }
}