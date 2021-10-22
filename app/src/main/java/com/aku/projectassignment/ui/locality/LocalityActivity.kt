package com.aku.projectassignment.ui.locality

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.aku.projectassignment.R
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import com.aku.projectassignment.ui.survey.AddResidentActivity
import com.aku.projectassignment.data.local.Constants
import com.aku.projectassignment.data.model.Locality
import com.aku.projectassignment.utils.display.Toaster
import kotlinx.android.synthetic.main.activity_locality.*

class LocalityActivity : BaseActivity<LocalityViewModel>() {

    private val locality = Locality()

    val TAG = "LocalityActivity"


    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_locality

    override fun setUpView(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Add Locality"
        province_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            locality.provinceList.map { province -> province.name })

        province_spinner.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                p_tehsil_spinner.visibility = View.GONE

                if (position != 0){
                    Log.i(TAG, "onItemSelected: ${locality
                            .provinceList[position].code}")

                    p_distrcit_spinner.visibility = View.VISIBLE

                    district_spinner.adapter = parent?.context?.let { context ->
                        ArrayAdapter(context,
                                android.R.layout.simple_list_item_1,
                                locality.provinceList[position]
                                        .district.map { district -> district.name })
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        district_spinner.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0){
                    p_tehsil_spinner.visibility = View.VISIBLE

                    Log.i(TAG, "onItemSelected: ${locality
                            .provinceList[province_spinner.selectedItemPosition]
                            .district[position].code}")

                    tehsil_spinner.adapter = parent?.context?.let { context ->
                        ArrayAdapter(context,
                                android.R.layout.simple_list_item_1,
                                locality.provinceList[province_spinner.selectedItemPosition]
                                        .district[position]
                                        .tehsil.map { tehsil -> tehsil.name })
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        tehsil_spinner.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0){
                    Log.i(TAG, "onItemSelected: ${locality
                            .provinceList[province_spinner.selectedItemPosition]
                            .district[district_spinner.selectedItemPosition]
                            .tehsil[position].code}")
                    btnSetLocality.isEnabled = true
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        btnSetLocality.setOnClickListener {
            viewModel.onSubmit(province_spinner.selectedItemPosition,
                    district_spinner.selectedItemPosition,
                    tehsil_spinner.selectedItemPosition)
        }

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchResident.observe(this,{
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, AddResidentActivity::class.java))
                finish()
            }
        })
    }


}
