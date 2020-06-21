package com.bsrakdg.noteapp.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.bsrakdg.noteapp.persistence.NoteDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS) // if you use BeforeAll, you need to add this
class NoteRepositoryTest {

    // system under test
    private NoteRepository noteRepository;

    @Mock
    private NoteDao noteDao;

    /**
     * You would need to use beforeEach, which will run before every test,
     * so it can reset the conditions for the next one.
     */
    @BeforeEach // individual test
    public void initEach() {
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
    @Test
    void dummyTest() throws Exception {
        assertNotNull(noteDao);
        assertNotNull(noteRepository);
    }
}
