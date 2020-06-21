package com.bsrakdg.noteapp;

import android.os.Bundle;
import android.util.Log;

import com.bsrakdg.noteapp.repository.NoteRepository;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NoteListActivity extends DaggerAppCompatActivity {
    private static final String TAG = "NoteListActivity";

    @Inject
    NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        Log.d(TAG, "onCreate: " + noteRepository);
    }
}
