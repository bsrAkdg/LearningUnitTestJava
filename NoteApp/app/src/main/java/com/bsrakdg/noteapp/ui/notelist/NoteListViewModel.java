package com.bsrakdg.noteapp.ui.notelist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.bsrakdg.noteapp.models.Note;
import com.bsrakdg.noteapp.repository.NoteRepository;
import com.bsrakdg.noteapp.ui.Resource;

import java.util.List;

import javax.inject.Inject;

public class NoteListViewModel extends ViewModel {
    private static final String TAG = "NoteListViewModel";

    // inject
    private final NoteRepository noteRepository;

    private MediatorLiveData<List<Note>> notes = new MediatorLiveData<>();

    @Inject
    public NoteListViewModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public LiveData<Resource<Integer>> deleteNote(final Note note) throws Exception {
        return noteRepository.deleteNote(note);
    }

    public void getNotes() {
        final LiveData<List<Note>> source = noteRepository.getNotes();
        notes.addSource(source, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> noteList) {
                if (noteList != null) {
                    notes.setValue(noteList);
                }
                notes.removeSource(source);
            }
        });
    }

    public LiveData<List<Note>> observeNotes() {
        return notes;
    }
}
