package com.aku.projectassignment.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aku.projectassignment.data.local.db.dao.ResidentDao
import com.aku.projectassignment.data.local.db.entity.ResidentEntity
import javax.inject.Singleton


@Singleton
@TypeConverters(Converter::class)
@Database(entities = [ResidentEntity::class], exportSchema = false, version = 1)
abstract class DatabaseService : RoomDatabase() {

    abstract fun residentDao() : ResidentDao

}