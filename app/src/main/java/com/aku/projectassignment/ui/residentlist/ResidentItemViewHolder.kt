package com.aku.projectassignment.ui.residentlist

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.aku.projectassignment.R
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.aku.projectassignment.di.component.ViewHolderComponent
import com.mindorks.bootcamp.instagram.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_residen_list.view.*

class ResidentItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<ResidentEntity, ResidentItemViewModel>(R.layout.item_view_residen_list, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.name.observe(this, Observer {
            itemView.tv_name.text = "Resident Name:  $it"
        })

        viewModel.age.observe(this, Observer {
            itemView.tv_age.text =  "Resident Age : $it"
        })

        viewModel.gender.observe(this, {
            if (it == 1){
                itemView.tv_gender.text =  "Gender : Male"

            }else if (it == 2 ){
                itemView.tv_gender.text =  "Gender : Female"
            }else{
                itemView.tv_gender.text =  "Gender : Not Known"

            }

        })


    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }
}