package mockNotes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesServiceImplTest {

    NotesServiceImpl notesService;

    Note kowalski1;
    Note szapołowicz1;
    Note janowicz1;

    MockNotesStorage notesStorage;

    @BeforeEach
    void init() {
        notesStorage = new MockNotesStorage();
        notesService = NotesServiceImpl.createWith(notesStorage);
        kowalski1 = Note.of("Jan Kowalski", 3.0f);
        szapołowicz1 = Note.of("Grażyna Szapołowicz", 5.0f);
        janowicz1 = Note.of("Jerzy Janowicz", 4.5f);
    }

    @Test
    void checkAdd() {

        notesService.add(kowalski1);
        notesService.add(szapołowicz1);
        notesService.add(janowicz1);
        
        assertEquals(3, notesStorage.noteList.size());
    }

    @Test
    void checkAverageStudentNotes_OneNoteAdded() {
        notesService.add(janowicz1);

        assertEquals(4.5f, notesService.averageOf("Jerzy Janowicz"));
    }

    @Test
    void checkAverageStudentNotes_TwoNotesAdded() {
        notesService.add(janowicz1);

        janowicz1 = Note.of("Jerzy Janowicz", 3.5f);
        notesService.add(janowicz1);

        assertEquals(4.0f, notesService.averageOf("Jerzy Janowicz"));
    }

    @Test
    void checkAverageStudentNotes_MoreStudents(){
        notesService.add(janowicz1);
        notesService.add(szapołowicz1);
        notesService.add(kowalski1);

        assertEquals(3.0f, notesService.averageOf("Jan Kowalski"));
    }

    @Test
    void checkClear() {
        notesService.add(kowalski1);
        notesService.add(szapołowicz1);
        notesService.add(janowicz1);

        notesService.clear();

        assertTrue(notesStorage.noteList.isEmpty());
    }

    @Test
    void testAddNoteException_WrongNote() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            notesStorage.add(Note.of("Włodzimierz Bażant", 7.0f));
        });
    }

    @Test
    void testAddNoteException_NullName() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            notesStorage.add(Note.of(null, 4.5f));
        });
    }

    @Test
    void testAddNoteException_WhiteSpaceName() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            notesStorage.add(Note.of(" ", 5.0f));
        });
    }
}