package com.bsrakdg.noteapp;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.bsrakdg.noteapp.persistence.NoteDao;
import com.bsrakdg.noteapp.persistence.NoteDatabase;

import org.junit.After;
import org.junit.Before;

public abstract class NoteDatabaseTest {

    // system under test
    private NoteDatabase noteDatabase;

    public NoteDao getNoteDao() {
        return noteDatabase.getNoteDao();
    }

    @Before
    public void init() {
        // Creates a RoomDatabase.Builder for an in memory database (Mock database for testing)
        // database alive as long as application is alive
        noteDatabase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(), // reference android text core framework
                NoteDatabase.class
        ).build();
    }

    @After
    public void finish() {
        noteDatabase.close();
    }
}
