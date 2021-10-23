package com.aku.projectassignment.ui.residentlist

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aku.projectassignment.R
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_resident_list.*
import javax.inject.Inject


class ResidentListActivity : BaseActivity<ResidentListViewModel>() {

    companion object {
        const val TAG = "ResidentListActivity"
    }

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var residentAdapter: ResidentListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_resident_list

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setUpView(savedInstanceState: Bundle?) {

        supportActionBar?.title = "Resident List"

        rv_resident_list.layoutManager = linearLayoutManager
        rv_resident_list.adapter = residentAdapter

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.residentLiveData.observe(this, Observer {
            it?.run { residentAdapter.appendData(this) }

        })
    }


}