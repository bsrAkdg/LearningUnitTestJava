package com.bsrakdg.noteapp.ui.notelist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bsrakdg.noteapp.R;
import com.bsrakdg.noteapp.ui.note.NoteActivity;

import dagger.android.support.DaggerAppCompatActivity;

public class NoteListActivity extends DaggerAppCompatActivity {

    private static final String TAG = "NoteListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }
}
