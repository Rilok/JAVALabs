package mockNotes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockNotesStorage implements NotesStorage {

    public List<Note> noteList = new ArrayList<>();

    public void add(Note note) {
        noteList.add(note);
    }

    public List<Note> getAllNotesOf(String name) {
        List<Note> result = noteList.stream()
                .filter(note -> note.getName().equals(name))
                .collect(Collectors.toList());
        return result;
    }

    public void clear() {
        noteList.clear();
    }
}
