package com.aku.projectassignment.ui.survey

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.aku.projectassignment.data.repository.ResidentRepository
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.Event
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AddResidentViewModel (private val compositeDisposable: CompositeDisposable,
                            private val residentRepository: ResidentRepository,
                            private val userRepository: UserRepository)
    : BaseViewModel(compositeDisposable)  {

    val TAG = "AddResidentViewModel"
    val launchQuestions: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchBackAddResident: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    override fun onCreate() {

    }

    fun onNext(serialNum: String,name: String, fname: String,
               mName: String,address: String, mobileNum: String,
               age: String){


        if (serialNum.isEmpty()){
            messageString.postValue("Please Enter Serial Number")
            return
        }

        if (name.isEmpty()){
            messageString.postValue("Please Enter Name")
            return
        }

        if (fname.isEmpty()){
            messageString.postValue("Please Enter Father Name")
            return
        }

        if (age.isEmpty()){
            messageString.postValue("Please Enter Resident Age")
            return
        }

        var residentEntity = ResidentEntity()

        residentEntity.serialNum = serialNum.toLong()
        residentEntity.name = name
        residentEntity.fatherName = fname
        residentEntity.motherName = mName
        residentEntity.address = address
        residentEntity.mobileNum = mobileNum
        residentEntity.ageInYears = age.toInt()

        residentRepository.storeInitialData(residentEntity)
        launchQuestions.postValue(Event(emptyMap()))

    }

    fun onSubmit(gender: Int,maritalStatus: Int,
                 pregnant: Int,numOfchildren: String,
                 dob: String,education: Int,
                 occupation: Int){

        if (numOfchildren.isEmpty()){
            messageString.postValue("Please Enter Number of Children")
            return
        }

        if (education ==  0){
            messageString.postValue("Please Enter Education")
            return
        }

        if (occupation == 0){
            messageString.postValue("Please Enter Occupation")
            return
        }

        var residentEntity = residentRepository.getInitialData()

        residentEntity.gender = gender+1
        residentEntity.maritalStatus = maritalStatus+1
        residentEntity.isPregnant = pregnant+1
        residentEntity.childrenCount = numOfchildren.toInt()
        residentEntity.dateOfBirth = dob
        residentEntity.education = education
        residentEntity.occupation = occupation
        residentEntity.province = userRepository.getLocality()?.province!!
        residentEntity.district = userRepository.getLocality()?.district!!
        residentEntity.tehsil = userRepository.getLocality()?.tehsil!!


        compositeDisposable.add(residentRepository
                .addResident(residentEntity)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    insertedId ->
                    Log.i(TAG, "onCreate: a $insertedId")
                    messageString.postValue("Resident Added Successfully")
                    launchBackAddResident.postValue(Event(emptyMap()))

                },{ error ->
                    Log.i(TAG, "onCreate: "+ error.localizedMessage)
                    Log.i(TAG,  ""+ error)
                    messageString.postValue("onCreate: a ${error.localizedMessage}")

                }))

    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()

    }



}