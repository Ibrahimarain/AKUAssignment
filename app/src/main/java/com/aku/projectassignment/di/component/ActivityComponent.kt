package com.aku.projectassignment.di.component

import com.aku.projectassignment.di.ActivityScope
import com.aku.projectassignment.di.module.ActivityModule
import com.aku.projectassignment.ui.home.HomeActivity
import com.aku.projectassignment.ui.locality.LocalityActivity
import com.aku.projectassignment.ui.login.LoginActivity
import com.aku.projectassignment.ui.residentlist.ResidentListActivity
import com.aku.projectassignment.ui.splash.SplashActivity
import com.aku.projectassignment.ui.summary.DashboardActivity
import com.aku.projectassignment.ui.survey.AddResidentActivity
import com.aku.projectassignment.ui.survey.ResidentQuestionsActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class],modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity : AddResidentActivity)

    fun inject(activity : SplashActivity)

    fun inject(activity : LoginActivity)

    fun inject(activity : HomeActivity)

    fun inject(activity : LocalityActivity)

    fun inject(activity : ResidentQuestionsActivity)

    fun inject(activity : ResidentListActivity)

    fun inject(activity : DashboardActivity)




}