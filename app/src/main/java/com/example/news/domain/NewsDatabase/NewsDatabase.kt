package com.example.news.domain.NewsDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsRoom::class], version = 3, exportSchema = false)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun getDao(): NewsDao
    companion object{
        var INSTANCE : NewsDatabase? = null
        fun getInstance(context: Context): NewsDatabase {
            synchronized(this){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "addNews_database"
                    ).addMigrations().fallbackToDestructiveMigration().build()
                }
                return INSTANCE!!
            }
        }
    }
}