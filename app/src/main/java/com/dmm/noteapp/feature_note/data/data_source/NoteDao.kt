package com.dmm.noteapp.feature_note.data.data_source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dmm.noteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteDao {

	@Query("Select * FROM note")
	fun getNotes(): Flow<List<Note>>

	@Query("Select * FROM note Where id = :_id")
	suspend fun getNoteById(_id: Int): Note?

	@Insert()
	suspend fun insertNote(note: Note)

	@Delete
	suspend fun deleteNote(note: Note)
}