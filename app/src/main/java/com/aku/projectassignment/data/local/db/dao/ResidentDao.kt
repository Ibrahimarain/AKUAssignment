package com.aku.projectassignment.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aku.projectassignment.data.local.db.entity.LocalityCount
import com.aku.projectassignment.data.local.db.entity.MaritalCount
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import io.reactivex.Single

@Dao
interface ResidentDao {

    @Query("Select * from tbl_resident")
    fun getAllResident() : Single<List<ResidentEntity>>

    @Query("Select * from tbl_resident where gender IN (:gender)" +
            " AND maritalStatus IN (:maritalStatus)")
    fun getFilteredResident(gender : List<Int>, maritalStatus: List<Int>) : Single<List<ResidentEntity>>

    @Insert
    fun addResident(entity: ResidentEntity) : Single<Long>

    @Query("Select Count(*) from tbl_resident where gender = 1")
    fun getMaleCount() : Single<Int>

    @Query("Select Count(*) from tbl_resident where gender = 2")
    fun getFemaleCount() : Single<Int>


    @Query("Select " +
            "Count(CASE WHEN ageInYears > 14 AND maritalStatus = 1 THEN 1 END) as unmarried_count, " +
            "Count(CASE WHEN ageInYears > 14 AND maritalStatus = 2 THEN 1 END) as married_count, " +
            "Count(CASE WHEN ageInYears > 14 AND maritalStatus = 3 THEN 1 END) as divorced_count, " +
            "Count(CASE WHEN ageInYears > 14 AND maritalStatus = 4 THEN 1 END) as widow_count " +
            "from tbl_resident")
    fun getUnMaritalCount() : Single<MaritalCount>

    @Query("Select " +
            "Count(CASE WHEN province = 1 THEN 1 END) as sindh_count, " +
            "Count(CASE WHEN province = 2 THEN 1 END) as punjab_count, " +
            "Count(CASE WHEN district = 1 THEN 1 END) as karachi_count, " +
            "Count(CASE WHEN district = 2 THEN 1 END) as lahore_count " +
            "from tbl_resident")
    fun getLocalityWiseCount() : Single<LocalityCount>


    @Query("Select Count(*) from tbl_resident")
    fun geCount() : Single<Int>



}