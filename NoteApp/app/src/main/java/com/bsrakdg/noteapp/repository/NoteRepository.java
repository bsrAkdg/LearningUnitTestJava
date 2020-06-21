package com.bsrakdg.noteapp.repository;

import androidx.annotation.NonNull;

import com.bsrakdg.noteapp.persistence.NoteDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NoteRepository {

    // inject
    @NonNull
    private final NoteDao noteDao;

    @Inject
    public NoteRepository(@NonNull NoteDao noteDao) {
        this.noteDao = noteDao;
    }
}
