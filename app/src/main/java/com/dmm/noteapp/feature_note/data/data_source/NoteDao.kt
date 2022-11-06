package com.dmm.noteapp.feature_note.data.data_source

import androidx.room.*
import com.dmm.noteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

	@Query("Select * FROM note")
	fun getNotes(): Flow<List<Note>>

	@Query("Select * FROM note Where id = :id")
	suspend fun getNoteById(id: Int): Note?

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertNote(note: Note)

	@Delete
	suspend fun deleteNote(note: Note)
}