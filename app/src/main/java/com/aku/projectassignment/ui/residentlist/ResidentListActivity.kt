package com.aku.projectassignment.ui.residentlist

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aku.projectassignment.R
import com.aku.projectassignment.data.local.Constants
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_resident_list.*
import kotlinx.android.synthetic.main.activity_resident_questions.*
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

        gender_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            Constants.gender)

        marital_status_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            Constants.martialStatus)

        gender_spinner.setSelection(0,false)
        gender_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.getFilterData(position,
                    marital_status_spinner.selectedItemPosition)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }


        }
        marital_status_spinner.setSelection(0,false)
        marital_status_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.getFilterData(gender_spinner.selectedItemPosition,
                    position)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }


    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.residentLiveData.observe(this, Observer {
            it?.run { residentAdapter.appendData(it) }
        })

        viewModel.filteredDataObservable().observe(this, {
            it?.run { residentAdapter.swapData(it) }

        })
    }


}