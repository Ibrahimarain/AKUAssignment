package com.aku.projectassignment.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import io.reactivex.Single

@Dao
interface ResidentDao {

    @Query("Select * from tbl_resident")
    fun getAllResident() : Single<List<ResidentEntity>>

    @Insert
    fun addResident(entity: ResidentEntity) : Single<Long>

    @Query("Select Count(*) from tbl_resident where gender = 1")
    fun getMaleCount() : Single<Int>

    @Query("Select Count(*) from tbl_resident where gender = 2")
    fun getFemaleCount() : Single<Int>


    @Query("Select Count(*) from tbl_resident where ageInYears > 14 AND maritalStatus = 1")
    fun getUnMarriedCount() : Single<Int>

    @Query("Select Count(*) from tbl_resident where ageInYears > 14 AND maritalStatus = 2")
    fun getMarriedCount() : Single<Int>

    @Query("Select Count(*) from tbl_resident where ageInYears > 14 AND maritalStatus = 3")
    fun getDivorcedCount() : Single<Int>

    @Query("Select Count(*) from tbl_resident where ageInYears > 14 AND maritalStatus = 4")
    fun getWidowCount() : Single<Int>


    @Query("Select Count(*) from tbl_resident")
    fun geCount() : Single<Int>



}