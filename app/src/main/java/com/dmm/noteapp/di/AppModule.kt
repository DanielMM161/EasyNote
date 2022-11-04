package com.dmm.noteapp.di

import android.app.Application
import androidx.room.Room
import com.dmm.noteapp.feature_note.data.data_source.NoteDataBase
import com.dmm.noteapp.feature_note.data.reposiotry.NoteRepositoryImpl
import com.dmm.noteapp.feature_note.domain.repository.NoteRepository
import com.dmm.noteapp.feature_note.domain.use_case.AddNote
import com.dmm.noteapp.feature_note.domain.use_case.DeleteNote
import com.dmm.noteapp.feature_note.domain.use_case.GetNotes
import com.dmm.noteapp.feature_note.domain.use_case.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun provideNoteDatabase(app: Application): NoteDataBase {
		return Room.databaseBuilder(
			app,
			NoteDataBase::class.java,
			NoteDataBase.DATABASE_NAME
		).build()
	}

	@Provides
	@Singleton
	fun provideRepository(db: NoteDataBase): NoteRepository {
		return NoteRepositoryImpl(db.noteDao())
	}

	@Provides
	@Singleton
	fun provideUseCase(repository: NoteRepository): NoteUseCase {
		return NoteUseCase(
			getNotes = GetNotes(repository),
			deleteNote = DeleteNote(repository),
			addNote = AddNote(repository)
		)
	}
}