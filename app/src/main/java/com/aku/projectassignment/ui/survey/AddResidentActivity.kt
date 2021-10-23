package com.aku.projectassignment.ui.survey

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.aku.projectassignment.R
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
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
                et_resident_name.text.toString(), et_fname.text.toString(),
                et_mname.text.toString(), et_res_address.text.toString(),
                et_mobile_num.text.toString(), et_age.text.toString(),
            )

        }


    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchQuestions.observe(this, {
            it.getIfNotHandled()?.run {
                clearForm(mainParent)
                startActivity(Intent(applicationContext, ResidentQuestionsActivity::class.java))
            }
        })



    }


    private fun clearForm(group: ViewGroup) {
        var i = 0
        val count = group.childCount
        while (i < count) {
            val view: View = group.getChildAt(i)
            if (view is EditText) {
                (view as EditText).setText("")
                (view as EditText).clearFocus()
            }
            if (view is ViewGroup && (view as ViewGroup).childCount > 0) clearForm(view as ViewGroup)
            ++i
        }
    }

    override fun onResume() {
        super.onResume()
        et_age.setText("")
        et_serial_num.setText("")

    }

}

