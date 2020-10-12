package com.example.roomdb.repository

import androidx.lifecycle.LiveData
import com.example.roomdb.dao.WordDao
import com.example.roomdb.entity.Word

class WordRepository (private val wordDao: WordDao){
    val allWords:LiveData<List<Word>> = wordDao.getAllWord()

    suspend fun insert(word: Word){
        wordDao.inset(word)

    }
    fun searchWord(word: String):LiveData<List<Word>>{
        return wordDao.getSearchWords(word)
    }
    suspend fun deleteWord(word: String){
        wordDao.delete(word)
    }
    suspend fun updateWord(word: String,update_word:String){
        wordDao.update(word,update_word)
    }
}