package com.example.roomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdb.entity.Word

@Dao
interface WordDao {
    @Query("SELECT * from word_table ORDER BY word_id ASC")
    fun getAllWord(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inset(word: Word)

    @Query("SELECT * from word_table WHERE word_id LIKE :word ORDER BY word_id ASC")
    fun getSearchWords(word: String): LiveData<List<Word>>

    @Query("DELETE FROM word_table where word_id = :word_id")
    suspend fun delete(word_id: String)

    @Query("UPDATE word_table SET word_id = :update_word WHERE word_id = :word_id")
    suspend fun update(word_id: String,update_word:String)
}