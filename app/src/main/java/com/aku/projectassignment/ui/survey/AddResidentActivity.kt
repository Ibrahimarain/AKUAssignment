package com.aku.projectassignment.ui.survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.aku.projectassignment.R
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import com.aku.projectassignment.ui.home.HomeActivity
import com.aku.projectassignment.utils.common.Event
import com.aku.projectassignment.utils.display.Toaster
import kotlinx.android.synthetic.main.activity_add_resident.*

class AddResidentActivity : BaseActivity<AddResidentViewModel>() {

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun provideLayoutId() = R.layout.activity_add_resident


    override fun setUpView(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Add Resident"
        btn_next.setOnClickListener{
            viewModel.onNext(
                    et_serial_num.text.toString(),
                    et_resident_name.text.toString(),et_fname.text.toString(),
                    et_mname.text.toString(),et_res_address.text.toString(),
                    et_mobile_num.text.toString(),et_age.text.toString(),
            )

        }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchQuestions.observe(this, {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, ResidentQuestionsActivity::class.java))
            }
        })



    }


}

