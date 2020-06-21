package com.bsrakdg.noteapp.di;

import com.bsrakdg.noteapp.NoteListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract NoteListActivity contributeNoteListActivity();
}