package com.example.reviewcard.repository

import androidx.lifecycle.LiveData
import com.example.reviewcard.model.Word
import com.example.reviewcard.model.WordDao

class WordsRepository( private val wordDao: WordDao) {

    val allWords : LiveData<List<Word>> = wordDao.getAllWords()

    val allWordsForReview : LiveData<List<Word>> = wordDao.getWordsForReview()

    suspend fun insertWord(word: Word){
        return wordDao.insert(word = word)
    }

    suspend fun deleteWord(word: Word){
        return wordDao.delete(word = word)
    }

    suspend fun updateWord(word: Word){
        return wordDao.update(word = word)
    }
}