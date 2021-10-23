package com.aku.projectassignment.ui.residentlist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.aku.projectassignment.data.repository.ResidentRepository
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.Resource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ResidentListViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val residentRepository: ResidentRepository,
    private val userRepository: UserRepository

) : BaseViewModel(compositeDisposable) {

    val residentLiveData: MutableLiveData<List<ResidentEntity>> = MutableLiveData()

    private val filterGender: MutableLiveData<Resource<List<ResidentEntity>>> = MutableLiveData()
    private val filterMaritalStatus: MutableLiveData<Resource<List<ResidentEntity>>> = MutableLiveData()

    fun filteredDataObservable(): LiveData<List<ResidentEntity>>  {
         return Transformations.map(filterGender) { it.data }

    }

    fun getFilterData(gender : Int, maritalStatus: Int){

        var genderList = ArrayList<Int>()
        var maritalList = ArrayList<Int>()

        if (gender == 0){
            genderList.add(1)
            genderList.add(2)

        }else{
            genderList.add(gender)
        }

        if (maritalStatus == 0){

            maritalList.add(1)
            maritalList.add(2)
            maritalList.add(3)
            maritalList.add(4)

        }else{
            maritalList.add(maritalStatus)
        }

        compositeDisposable.add(
            residentRepository.getFilteredResident(genderList,maritalList)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { filterGender.postValue(Resource.success(it)) },
                    {
                        filterGender.postValue(Resource.error())
                    })
        )

    }




    fun getFemaleCount(): LiveData<List<ResidentEntity>> =
        Transformations.map(filterMaritalStatus) { it.data }


    override fun onCreate() {
        getResidents()
    }

     fun getResidents() {
        compositeDisposable.add(residentRepository
            .getAllResident()
            .subscribeOn(Schedulers.io())
            .subscribe({ list ->
                residentLiveData.postValue(list)

            },{ error ->
                messageString.postValue("getResidents: a ${error.localizedMessage}")

            }))
    }

}