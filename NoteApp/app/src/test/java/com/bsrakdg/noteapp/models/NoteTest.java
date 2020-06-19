package com.bsrakdg.noteapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class NoteTest {

    private static final String TIMESTAMP_1 = "06-2020";
    private static final String TIMESTAMP_2 = "05-2020";

    /*
        Compare two equal Notes
     */
    @Test
    void isNotesEqual_identicalProperties_returnTrue() {
        // Arrange
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);

        Note note2 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note2.setId(1);

        // Act

        // Assert
        assertEquals(note1, note2);
        System.out.println("The notes are equal!");
    }

    /*
        Compare notes with 2 different ids
     */
    @Test
    void isNotesEqual_differentIds_returnFalse() {
        // Arrange
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);

        Note note2 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note2.setId(2);

        // Act

        // Assert
        assertNotEquals(note1, note2);
        System.out.println("The notes are not equal!");
    }

    /*
        Compare two notes with different timeStamps
     */
    @Test
    void isNotesEqual_differentTimeStamps_returnTrue() {
        // Arrange
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);

        Note note2 = new Note("Note #1", "This is note #1", TIMESTAMP_2);
        note2.setId(1);

        // Act

        // Assert
        assertEquals(note1, note2);
        System.out.println("The notes are equal!");
    }

    /*
         Compare two notes with different titles
     */
    @Test
    void isNotesEqual_differentTitles_returnFalse() {
        // Arrange
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);

        Note note2 = new Note("Note #2", "This is note #1", TIMESTAMP_1);
        note2.setId(1);

        // Act

        // Assert
        assertNotEquals(note1, note2);
        System.out.println("The notes are not equal!");
    }

    /*
        Compare two notes with different contents
     */
    @Test
    void isNotesEqual_differentContent_returnFalse() {
        // Arrange
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);

        Note note2 = new Note("Note #1", "This is note #2", TIMESTAMP_1);
        note2.setId(1);

        // Act

        // Assert
        assertNotEquals(note1, note2);
        System.out.println("The notes are not equal!");
    }
}