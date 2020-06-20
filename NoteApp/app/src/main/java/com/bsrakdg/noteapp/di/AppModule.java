package com.bsrakdg.noteapp.di;

import static com.bsrakdg.noteapp.persistence.NoteDatabase.DATABASE_NAME;

import android.app.Application;

import androidx.room.Room;

import com.bsrakdg.noteapp.persistence.NoteDao;
import com.bsrakdg.noteapp.persistence.NoteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    static NoteDao provideNoteDao(NoteDatabase noteDatabase) {
        return noteDatabase.getNoteDao();
    }

    @Singleton
    @Provides
    static NoteDatabase provideNoteDatabase(Application application) {
        return Room.databaseBuilder(
                application,
                NoteDatabase.class,
                DATABASE_NAME).build();
    }
}
