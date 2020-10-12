package com.example.roomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.dao.WordDao
import com.example.roomdb.entity.Word
import kotlinx.coroutines.CoroutineScope


@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: WordDatabase? = null
        fun getDatabase(
            context: Context, scope: CoroutineScope
        ):WordDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}