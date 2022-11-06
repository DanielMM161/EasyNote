package com.dmm.noteapp.feature_note.domain.use_case

data class NoteUseCase(
	val getNotes: GetNotes,
	val getNote: GetNote,
	val deleteNote: DeleteNote,
	val addNote: AddNote
)