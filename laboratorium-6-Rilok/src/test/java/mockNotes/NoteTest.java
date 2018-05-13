package mockNotes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NoteTest {


	@Test
	void testCreate() {
		final Note note = Note.of("Mateusz Miotk", 4.5f);
		assertEquals("Mateusz Miotk", note.getName());
		assertEquals(4.5f, note.getNote(),0.01f);
	}

	@Test
	void testNullCreate() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
		{
			final Note note = Note.of(null, 4.5f);
		});
		assertEquals("Imię ucznia nie może być null", exception.getMessage());
	}

	@Test
	void testNullWhiteSpaceCreate() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
		{
			final Note note = Note.of(" ", 4.5f);
		});
		assertEquals("Imię ucznia nie może być puste", exception.getMessage());
	}

	@Test
	void testWrongNoteToStudent() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
		{
			final Note note = Note.of("Jan Kowalski", 1.0f);
		});
		assertEquals("Niewłaściwa ocena", exception.getMessage());
	}

}
