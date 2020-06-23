package com.bsrakdg.noteapp.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bsrakdg.noteapp.ui.note.NoteViewModel;
import com.bsrakdg.noteapp.ui.notelist.NoteListViewModel;
import com.bsrakdg.noteapp.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    @Binds
    @IntoMap
    @ViewModelKey(NoteListViewModel.class)
    public abstract ViewModel bindNoteListViewModel(NoteListViewModel noteListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel.class)
    public abstract ViewModel bindNoteViewModel(NoteViewModel noteViewModel);
}
