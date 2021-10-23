package com.aku.projectassignment.ui.summary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.aku.projectassignment.R
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dashboard_activity.*

class DashboardActivity : BaseActivity<DashboardViewModel>(){

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_dashboard_activity

    override fun setUpView(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Population Summary"

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.getMaleCount().observe(this,  {
            it?.run { tv_male_count.text = "Total Male in Population: $it" }
        })

        viewModel.getFemaleCount().observe(this,  {
            it?.run { tv_female_count.text = "Total Female in Population: $it" }
        })

        viewModel.getMarriedCount().observe(this,  {
            it?.run { tv_married_count.text = "Total Married Residents: $it" }
        })




    }

}
