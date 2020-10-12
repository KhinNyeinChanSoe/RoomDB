package com.example.roomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdb.database.WordDatabase
import com.example.roomdb.entity.Word
import com.example.roomdb.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewmodel(application: Application) : AndroidViewModel(application) {
    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        var wordDao = WordDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
    fun getSearchWord(word: String):LiveData<List<Word>>{
        return repository.searchWord(word)
    }
    fun deleteWord(word: String) = viewModelScope.launch{
        repository.deleteWord(word)
    }
}