package com.aku.projectassignment.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "tbl_resident")
data class ResidentEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NotNull
    var serialNum: Long = 0,

    @ColumnInfo(name = "name")
    @NotNull
    var name: String = "",

    @ColumnInfo(name = "fatherName")
    @NotNull
    var fatherName: String = "",

    @ColumnInfo(name = "motherName")
    @NotNull
    var motherName: String = "",

    @ColumnInfo(name = "address")
    @NotNull
    var address: String = "",

    @ColumnInfo(name = "mobileNum")
    @NotNull
    var mobileNum: String = "",

    @ColumnInfo(name = "dateOfBirth")
    @NotNull
    var dateOfBirth: String = "",

    @ColumnInfo(name = "ageInYears")
    @NotNull
    var ageInYears: String = "",

    @ColumnInfo(name = "gender")
    @NotNull
    var gender: Int = 0,

    @ColumnInfo(name = "maritalStatus")
    @NotNull
    var maritalStatus: Int = 0,

    @ColumnInfo(name = "education")
    @NotNull
    var education: Int = 0,

    @ColumnInfo(name = "occupation")
    @NotNull
    var occupation: Int = 0,

    @ColumnInfo(name = "children_count")
    @NotNull
    var childrenCount: Int = 0,

    @ColumnInfo(name = "isPregnant")
    @NotNull
    var isPregnant: Int = 0,

    @ColumnInfo(name = "province")
    @NotNull
    var province: Int = 0,

    @ColumnInfo(name = "district")
    @NotNull
    var district: Int = 0,

    @ColumnInfo(name = "tehsil")
    @NotNull
    var tehsil: Int = 0,


)