package com.dmm.noteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dmm.noteapp.feature_note.domain.model.Note

@Database(
	entities = [Note::class],
	version = 1
)
abstract class NoteDataBase : RoomDatabase(){

	abstract fun noteDao(): NoteDao

	companion object {
		val DATABASE_NAME = "notes_db"
	}
}