package com.aku.projectassignment.ui.splash

import android.content.Intent
import android.os.Bundle
import com.aku.projectassignment.R
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.ui.base.BaseActivity
import com.aku.projectassignment.ui.home.HomeActivity
import com.aku.projectassignment.ui.login.LoginActivity
import kotlinx.coroutines.*

class SplashActivity : BaseActivity<SplashViewModel>() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setUpView(savedInstanceState: Bundle?) {}

    override fun setupObservers() {
        super.setupObservers()
        // Event is used by the view model to tell the activity to launch another activity
        // view model also provided the Bundle in the event that is needed for the Activity
        viewModel.launchLogin.observe(this, {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }
        })

        viewModel.launchHome.observe(this, {

            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
                finish()
            }
        })


    }
}