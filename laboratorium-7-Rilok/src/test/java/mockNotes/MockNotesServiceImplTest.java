package mockNotes;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MockNotesServiceImplTest {

    @InjectMocks
    private NotesServiceImpl notesService;

    @Mock
    private Note note;

    @Mock
    private MockNotesStorage notesStorage;



}