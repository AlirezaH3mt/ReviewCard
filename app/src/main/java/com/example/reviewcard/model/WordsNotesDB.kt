package com.example.reviewcard.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.reviewcard.defaultdata.AddDefaultData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Word::class, Note::class], version = 1)
abstract class WordsNotesDB : RoomDatabase() {

    abstract val wordsDao : WordDao
    abstract val notesDao : NoteDao

    companion object {
        @Volatile
        private var INSTANCE : WordsNotesDB ?= null

        fun getInstance (context: Context) : WordsNotesDB{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        WordsNotesDB::class.java,
                        name = "wordsNotes_db"
                    ).addCallback(PopulateDatabaseCallback()).build()
                }
                INSTANCE = instance
                return instance
            }
        }

    }


    /**
     * A callback class to populate the database with initial data.
     * This method is called only once, when the database is first created.
     */
    private class PopulateDatabaseCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // Launch a coroutine on the IO dispatcher to perform the database operation off the main thread.
            CoroutineScope(Dispatchers.IO).launch {
                INSTANCE?.let { database ->
                    val wordDao = database.wordsDao
                    // Get the list of initial words you want to insert.
                    val initialWords = AddDefaultData().add504()

                    // Iterate over the list and insert each word.
                    for (word in initialWords) {
                        wordDao.insert(word)
                    }
                }
            }
        }

    }

}