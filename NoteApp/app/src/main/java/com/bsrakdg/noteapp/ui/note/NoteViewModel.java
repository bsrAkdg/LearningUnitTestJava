package com.bsrakdg.noteapp.ui.note;

import static com.bsrakdg.noteapp.repository.NoteRepository.NOTE_TITLE_NULL;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bsrakdg.noteapp.models.Note;
import com.bsrakdg.noteapp.repository.NoteRepository;
import com.bsrakdg.noteapp.ui.Resource;
import com.bsrakdg.noteapp.utils.DateUtil;

import javax.inject.Inject;

public class NoteViewModel extends ViewModel {

    private static final String TAG = "NoteViewModel";

    private MutableLiveData<ViewState> viewState = new MutableLiveData<>();

    // inject
    private final NoteRepository noteRepository;

    // vars
    private MutableLiveData<Note> note = new MutableLiveData<>();
    private boolean isNewNote;

    private String removeWhiteSpace(String string) {
        string = string.replace("\n", "");
        string = string.replace(" ", "");
        return string;
    }

    @Inject
    public NoteViewModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public LiveData<Resource<Integer>> insertNote() throws Exception {
        return LiveDataReactiveStreams.fromPublisher( // Converts flowable to livedata, look at gradle
                noteRepository.insertNote(note.getValue())
        );
    }

    public LiveData<ViewState> observeViewState() {
        return viewState;
    }

    public LiveData<Resource<Integer>> saveNote() {
        return null;
    }

    public void setIsNewNote(boolean isNewNote) {
        this.isNewNote = isNewNote;
    }

    public void setViewState(ViewState viewState) {
        this.viewState.setValue(viewState);
    }

    public boolean shouldNavigateBack() {
        if (viewState.getValue() == ViewState.VIEW) {
            return true;
        } else {
            return false;
        }
    }

    public void updateNote(String title, String content) throws Exception {
        if (title == null || title.equals("")) {
            throw new NullPointerException(NOTE_TITLE_NULL);
        }
        String temp = removeWhiteSpace(content);
        if (temp.length() > 0) {
            Note updatedNote = new Note(note.getValue());
            updatedNote.setTitle(title);
            updatedNote.setContent(content);
            updatedNote.setTimeStamp(DateUtil.getCurrentTimeStamp());

            note.setValue(updatedNote);
        }
    }

    public LiveData<Note> observeNote() {
        return note;
    }

    public void setNote(Note note) throws Exception {
        if (note.getTitle() == null || note.getTitle().equals("")) {
            throw new Exception(NOTE_TITLE_NULL);
        }
        this.note.setValue(note);
    }

    public enum ViewState {VIEW, EDIT}
}
