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

        viewModel.getMaritalCount().observe(this,  {
            it?.run {
                tv_unmarried_count.text = "Total Unmarried Residents: ${it.unmarried_count}"
                tv_married_count.text = "Total Married Residents: ${it.married_count}"
                tv_divorced_count.text = "Total Married Residents: ${it.divorced_count}"
                tv_widow_count.text = "Total Married Residents: ${it.widow_count}"

            }
        })

        viewModel.getLocalityCount().observe(this,  {
            it?.run {
                tv_count_sindh.text = "Total Residents in Sindh: ${it.sindh_count}"
                tv_count_punjab.text = "Total Residents in Punjab: ${it.punjab_count}"
                tv_count_karachi.text = "Total Residents in Karachi: ${it.karachi_count}"
                tv_count_lahore.text = "Total Residents in Lahore: ${it.lahore_count}"

            }
        })

    }

}
