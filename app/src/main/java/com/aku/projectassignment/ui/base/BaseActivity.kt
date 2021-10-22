package com.aku.projectassignment.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.aku.projectassignment.AKUApplication
import com.aku.projectassignment.di.component.ActivityComponent
import com.aku.projectassignment.di.component.DaggerActivityComponent
import com.aku.projectassignment.di.module.ActivityModule
import com.aku.projectassignment.utils.display.Toaster
import javax.inject.Inject

abstract class BaseActivity<VM: BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setUpView(savedInstanceState)
        viewModel.onCreate()
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as AKUApplication)
            .applicationComponent)
            .activityModule(
            ActivityModule(this))
            .build()

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })
    }

    private fun showMessage(message: String) = Toaster.show(this, message)

    private fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))


    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    @LayoutRes
    protected abstract fun provideLayoutId() : Int

    protected abstract fun setUpView(savedInstanceState: Bundle?)



}