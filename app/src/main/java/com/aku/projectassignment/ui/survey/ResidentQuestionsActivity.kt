package com.aku.projectassignment.ui.survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import com.aku.projectassignment.R
import com.aku.projectassignment.data.local.Constants
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import com.aku.projectassignment.utils.common.DateTimeHelper
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_locality.*
import kotlinx.android.synthetic.main.activity_resident_questions.*
import java.util.*

class ResidentQuestionsActivity : BaseActivity<AddResidentViewModel>(){

    val TAG = "ResidentQuestionsActivity"

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }


    override fun provideLayoutId(): Int = R.layout.activity_resident_questions

    override fun setUpView(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Add Resident Details"

        radioGroupGender.check(optionMale.id)
        radioGroupMaritalStatus.check(optionUnMarried.id)

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()

        education_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            Constants.education)

        occupation_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            Constants.occupation)

        et_date_of_birth.setOnClickListener(){ view: View->
            datePicker.show(supportFragmentManager,"DOB")
        }

        datePicker.addOnPositiveButtonClickListener {
            et_date_of_birth.setText(DateTimeHelper.convertLongToDate(it))
        }

        btn_add_resident.setOnClickListener{
            val gender = radioGroupGender.indexOfChild(
                findViewById(radioGroupGender.checkedRadioButtonId))
            val maritalStatus = radioGroupMaritalStatus.indexOfChild(
                findViewById(radioGroupMaritalStatus.checkedRadioButtonId))
            val preg = radioGroupPreg.indexOfChild(
                findViewById(radioGroupPreg.checkedRadioButtonId))

            viewModel.onSubmit(gender,maritalStatus,preg,
                et_num_children.text.toString(),
                et_date_of_birth.text.toString(),
                education_spinner.selectedItemPosition,
                occupation_spinner.selectedItemPosition)

        }

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchBackAddResident.observe(this, {
            onBackPressed()


        })
    }


}