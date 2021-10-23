package com.aku.projectassignment.ui.residentlist

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import com.mindorks.bootcamp.instagram.ui.base.BaseAdapter

class ResidentListAdapter(
    parentLifecycle: Lifecycle,
    private val residents: ArrayList<ResidentEntity>
) : BaseAdapter<ResidentEntity, ResidentItemViewHolder>(parentLifecycle, residents) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ResidentItemViewHolder(parent)
}