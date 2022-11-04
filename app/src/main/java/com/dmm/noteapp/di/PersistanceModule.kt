package com.dmm.noteapp.di

import com.dmm.noteapp.feature_note.data.data_source.NoteDataBase
import com.dmm.noteapp.feature_note.data.data_source.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistanceModule {

	@Provides
	@Singleton
	fun provideNoteDao(noteDatabase: NoteDataBase): NoteDao {
		return noteDatabase.noteDao()
	}
}