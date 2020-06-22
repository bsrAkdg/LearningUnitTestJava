package com.bsrakdg.noteapp.repository;

import static com.bsrakdg.noteapp.repository.NoteRepository.INSERT_FAILURE;
import static com.bsrakdg.noteapp.repository.NoteRepository.INSERT_SUCCESS;
import static com.bsrakdg.noteapp.repository.NoteRepository.NOTE_TITLE_NULL;
import static com.bsrakdg.noteapp.repository.NoteRepository.UPDATE_FAILURE;
import static com.bsrakdg.noteapp.repository.NoteRepository.UPDATE_SUCCESS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.bsrakdg.noteapp.models.Note;
import com.bsrakdg.noteapp.persistence.NoteDao;
import com.bsrakdg.noteapp.ui.Resource;
import com.bsrakdg.noteapp.utils.TestUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS) // if you use BeforeAll, you need to add this
class NoteRepositoryTest {

    private static final Note NOTE1 = new Note(TestUtil.TEST_NOTE_1);

    // system under test
    private NoteRepository noteRepository;

    @Mock
    private NoteDao noteDao;

    /**
     * You would need to use beforeEach, which will run before every test,
     * so it can reset the conditions for the next one.
     */
    @BeforeEach // individual test
    void initEach() {
        MockitoAnnotations.initMocks(this);
        noteRepository = new NoteRepository(noteDao);
    }

    /**
     * If you're certain that the tests don't make any changes to those conditions,
     * you can use beforeAll (which will run once).
     */
    /*@BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
        noteRepository = new NoteRepository(noteDao);
    }*/

    /*
        Insert note
        verify the correct method is called
        confirm observer is triggered
        confirm new rows inserted
    */
    @Test
    void insertNote_returnRow() throws Exception {
        // Arrange
        final Long insertedRow = 1L;
        final Single<Long> returnedData = Single.just(insertedRow); // NoteDao -> insertNote

        when(noteDao.insertNote(any(Note.class))).thenReturn(returnedData);

        // Act
        final Resource<Integer> returnedValue = noteRepository.insertNote(NOTE1)
                .blockingFirst(); // NoteRepository -> insertNote

        // Assert
        verify(noteDao).insertNote(any(Note.class));
        verifyNoMoreInteractions(noteDao);

        System.out.println("Returned values : " + returnedValue.data);
        assertEquals(Resource.success(1, INSERT_SUCCESS), returnedValue);

        // Or test using RxJava
        /*
        noteRepository.insertNote(NOTE1)
                .test()
                .await() // like blockingFirst
                .assertValue(Resource.success(1, INSERT_SUCCESS));
        */
    }

    /*
        Insert note
        Failure (return -1)
    */
    @Test
    void insertNote_returnFailure() throws Exception {
        // Arrange
        final Long failedInsertedRow = -1L;
        final Single<Long> returnedData = Single.just(failedInsertedRow); // NoteDao -> insertNote

        when(noteDao.insertNote(any(Note.class))).thenReturn(returnedData);

        // Act
        final Resource<Integer> returnedValue = noteRepository.insertNote(NOTE1)
                .blockingFirst(); // NoteRepository -> insertNote

        // Assert
        verify(noteDao).insertNote(any(Note.class));
        verifyNoMoreInteractions(noteDao);

        assertEquals(Resource.error(null, INSERT_FAILURE), returnedValue);
    }

    /*
        Insert note
        null title
        confirm throw exception
    */
    @Test
    void insertNote_nullTitle_throwException() throws Exception {
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final Note note = new Note(TestUtil.TEST_NOTE_1);
                note.setTitle(null);
                noteRepository.insertNote(note);
            }
        });
    }

    /*
        update note
        verify correct method is called
        confirm observer is trigger
        confirm number of rows updated
     */
    @Test
    void updateNote_returnNumRowsUpdated() throws Exception {
        // Arrange
        final int updatedRow = 1;
        when(noteDao.updateNote(any(Note.class))).thenReturn(Single.just(updatedRow));

        // Act
        final Resource<Integer> returnedValue = noteRepository.updateNote(NOTE1).blockingFirst();

        // Assert
        verify(noteDao).updateNote(any(Note.class));
        verifyNoMoreInteractions(noteDao);

        assertEquals(Resource.success(updatedRow, UPDATE_SUCCESS), returnedValue);
    }

    /*
        update note
        failure (-1)
     */
    @Test
    void updateNote_returnFailure() throws Exception {
        // Arrange
        final int failedInsert = -1;
        final Single<Integer> returnedData = Single.just(failedInsert);
        when(noteDao.updateNote(any(Note.class))).thenReturn(returnedData);
        final Resource<Integer> returnedValue = noteRepository.updateNote(NOTE1).blockingFirst();

        // Assert
        verify(noteDao).updateNote(any(Note.class));
        verifyNoMoreInteractions(noteDao);

        assertEquals(Resource.error(null, UPDATE_FAILURE), returnedValue);
    }

    /*
        update note
        null title
        throw exception
     */
    @Test
    void updateNote_nullTitle_throwException() throws Exception {
        Exception exception = assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final Note note = new Note(NOTE1);
                note.setTitle(null);
                noteRepository.updateNote(note);
            }
        });
        assertEquals(NOTE_TITLE_NULL, exception.getMessage());
    }
}
