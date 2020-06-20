package com.bsrakdg.noteapp.di;

import androidx.lifecycle.ViewModelProvider;

import com.bsrakdg.noteapp.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
