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

import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class NoteViewModel extends ViewModel {

    public static final String NO_CONTENT_ERROR = "Can't save note with no content";
    private static final String TAG = "NoteViewModel";
    // inject
    private final NoteRepository noteRepository;

    // vars
    private MutableLiveData<ViewState> viewState = new MutableLiveData<>();
    private MutableLiveData<Note> note = new MutableLiveData<>();
    private boolean isNewNote;
    private Subscription updateSubscription, insertSubscription;

    @Inject
    public NoteViewModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    private void cancelInsertTransaction() {
        insertSubscription.cancel();
        insertSubscription = null;
    }

    private void cancelPendingTransaction() {
        if (insertSubscription != null) {
            cancelInsertTransaction();
        }
        if (updateSubscription != null) {
            cancelUpdateTransaction();
        }
    }

    private void cancelUpdateTransaction() {
        updateSubscription.cancel();
        updateSubscription = null;
    }

    private String removeWhiteSpace(String string) {
        string = string.replace("\n", "");
        string = string.replace(" ", "");
        return string;
    }

    private boolean shouldAllowSave() {
        return removeWhiteSpace(note.getValue().getContent()).length() > 0;
    }

    public LiveData<Resource<Integer>> insertNote() throws Exception {
        return LiveDataReactiveStreams
                .fromPublisher( // Converts flowable to livedata, look at gradle
                        noteRepository.insertNote(note.getValue())
                                .doOnSubscribe(new Consumer<Subscription>() {
                                    @Override
                                    public void accept(Subscription subscription) throws Exception {
                                        insertSubscription = subscription;
                                    }
                                })
                );
    }

    public LiveData<Note> observeNote() {
        return note;
    }

    public LiveData<ViewState> observeViewState() {
        return viewState;
    }

    public LiveData<Resource<Integer>> saveNote() throws Exception {
        if (!shouldAllowSave()) {
            throw new Exception(NO_CONTENT_ERROR);
        }
        cancelPendingTransaction();


        return null;
    }

    public void setIsNewNote(boolean isNewNote) {
        this.isNewNote = isNewNote;
    }

    public void setNote(Note note) throws Exception {
        if (note.getTitle() == null || note.getTitle().equals("")) {
            throw new Exception(NOTE_TITLE_NULL);
        }
        this.note.setValue(note);
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

    public LiveData<Resource<Integer>> updateNote() throws Exception {
        return LiveDataReactiveStreams.fromPublisher(
                noteRepository.updateNote(note.getValue())
                        .doOnSubscribe(new Consumer<Subscription>() {
                            @Override
                            public void accept(Subscription subscription) throws Exception {
                                updateSubscription = subscription;
                            }
                        })
        );
    }

    void updateNote(String title, String content) throws Exception {
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

    public enum ViewState {VIEW, EDIT}
}
