package com.bsrakdg.noteapp.ui.note;

import com.bsrakdg.noteapp.repository.NoteRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class NoteViewModelTest {

    // system under test
    private NoteViewModel noteViewModel;

    @Mock
    private NoteRepository noteRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        noteViewModel = new NoteViewModel(noteRepository);
    }

    /*
        can't observe a note that hasn't been set
     */
    @Test
    void observeEmptyNote_whenNoteSet() throws Exception {
        // Arrange

        // Act

        // Assert
    }

    /*
        Observe a note has been set and onChange will trigger in activity
     */
    @Test
    void observeNote_whenSet() throws Exception {
        // Arrange

        // Act

        // Assert
    }

    /*
        Insert a new note and observe row returned
     */

    @Test
    void insertNote_returnRow() throws Exception {
        // Arrange

        // Act

        // Assert
    }

    /*
        Insert : don't return a new row without observer
     */

    @Test
    void doNotReturnInsertRow_withoutObserver() throws Exception {
        // Arrange

        // Act

        // Assert
    }

    /*
        set note, null title, throw exception
     */

    @Test
    void setNote_nullTitle_throwException() throws Exception {
        // Arrange

        // Act

        // Assert
    }
}