package com.example.reviewcard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reviewcard.model.Word
import com.example.reviewcard.repository.WordsRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordsRepository) : ViewModel() {

    val allWords : LiveData<List<Word>> = repository.allWords
    val allWordsForReview : LiveData<List<Word>> = repository.allWordsForReview

    fun insert(word: Word){
        viewModelScope.launch {
            repository.insertWord(word = word)
        }
    }

    fun delete(word: Word){
        viewModelScope.launch {
            repository.deleteWord(word = word)
        }
    }

    fun update(word: Word){
        viewModelScope.launch {
            repository.updateWord(word = word)
        }
    }

}