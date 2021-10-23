package com.aku.projectassignment.di.component

import com.aku.projectassignment.di.ViewModelScope
import com.aku.projectassignment.di.module.ViewHolderModule
import com.aku.projectassignment.ui.residentlist.ResidentItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: ResidentItemViewHolder)
}