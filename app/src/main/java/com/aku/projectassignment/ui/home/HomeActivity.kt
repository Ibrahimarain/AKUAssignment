package com.aku.projectassignment.ui.home

import android.content.Intent
import android.os.Bundle
import com.aku.projectassignment.R
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import com.aku.projectassignment.ui.locality.LocalityActivity
import com.aku.projectassignment.ui.residentlist.ResidentListActivity
import com.aku.projectassignment.ui.summary.DashboardActivity
import com.aku.projectassignment.ui.survey.AddResidentActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity<HomeViewModel>() {


    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setUpView(savedInstanceState: Bundle?) {

        btnAddSurvey.setOnClickListener { viewModel.onAddSurvey() }
        btnChangeLocality.setOnClickListener { viewModel.onChangeLocality() }

        btnResidentList.setOnClickListener { viewModel.residentDidTapped() }
        btnSummary.setOnClickListener { viewModel.summaryDidTapped() }

        supportActionBar?.title = "Home"

    }

    override fun setupObservers() {
        super.setupObservers()
        // Event is used by the view model to tell the activity to launch another activity
        // view model also provided the Bundle in the event that is needed for the Activity
        viewModel.launchAddSurvey.observe(this,  {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, AddResidentActivity::class.java))
            }
        })

        viewModel.launchAddLocality.observe(this,  {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, LocalityActivity::class.java))
            }
        })

        viewModel.launchResidentList.observe(this,  {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, ResidentListActivity::class.java))
            }
        })

        viewModel.launchSummary.observe(this,  {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, DashboardActivity::class.java))
            }
        })


    }


}