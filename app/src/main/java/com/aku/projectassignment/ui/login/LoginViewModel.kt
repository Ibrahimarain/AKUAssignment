package com.aku.projectassignment.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aku.projectassignment.data.model.User
import com.aku.projectassignment.data.repository.UserRepository
import com.aku.projectassignment.ui.base.BaseViewModel
import com.aku.projectassignment.utils.common.*
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(
    compositeDisposable: CompositeDisposable,
    private val userRepository: UserRepository
) : BaseViewModel(compositeDisposable) {

    private val validationsList: MutableLiveData<List<Validation>> = MutableLiveData()

    val launchDummy: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()


    val emailField: MutableLiveData<String> = MutableLiveData()
    val passwordField: MutableLiveData<String> = MutableLiveData()
    val loggingIn: MutableLiveData<Boolean> = MutableLiveData()

    val emailValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.EMAIL)
    val passwordValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.PASSWORD)

    private fun filterValidation(field: Validation.Field) =
        Transformations.map(validationsList) {
            it.find { validation -> validation.field == field }
                ?.run { return@run this.resource }
                ?: Resource.unknown()
        }

    override fun onCreate() {}

    fun onEmailChange(email: String) = emailField.postValue(email)

    fun onPasswordChange(email: String) = passwordField.postValue(email)

    fun onLogin() {
        val email = emailField.value
        val password = passwordField.value

        val validations = Validator.validateLoginFields(email, password)
        validationsList.postValue(validations)

        if (validations.isNotEmpty() && email != null && password != null) {
            val successValidation = validations.filter { it.resource.status == Status.SUCCESS }
            if (successValidation.size == validations.size) {
                loggingIn.postValue(true)

                if (email == "ibrahimarain15@gmail.com" && password == "123456"){

                    val user = User("1","Ibrahim","ibrahimarain15@gmail.com",
                            "123456")

                    userRepository.saveCurrentUser(user)
                    loggingIn.postValue(false)
                    launchDummy.postValue(Event(emptyMap()))
                }else{
                    loggingIn.postValue(false)
                    messageString.postValue("Invalid Credentials")
                }




            }
        }
    }
}