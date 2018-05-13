package mockNotes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MockNoteTest {

    @Mock
    Note note;

   @Test
   @DisplayName("Sprawdzanie nulla")
    void testNullCreate() {
        assertThrows(IllegalArgumentException.class, () -> {
            note = Note.of(null, 4.5f);
        });
   }

   @Test
    @DisplayName("Sprawdzenie pustego pola")
    void testBlankCreate() {
       assertThrows(IllegalArgumentException.class, () -> {
           note = Note.of(" ", 4.5f);
       });
   }

   @Test
    @DisplayName("Sprawdzenie niepoprawnej oceny")
    void testWrongNote() {
       assertThrows(IllegalArgumentException.class, () -> {
           note = Note.of("Ziemek Kowalski", 1.0f);
       });
   }

}