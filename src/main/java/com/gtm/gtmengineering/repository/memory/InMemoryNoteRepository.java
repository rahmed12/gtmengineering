package com.gtm.gtmengineering.repository.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gtm.gtmengineering.model.Note;
import com.gtm.gtmengineering.repository.NoteRepository;



public class InMemoryNoteRepository implements NoteRepository{

    private final Map<String, Note> notes = new ConcurrentHashMap<>();

    public InMemoryNoteRepository() {

    }

    @Override
    public Note save(Note note) {
        notes.put(note.id(), note);

        return note;
    }

    @Override
    public List<Note> findAll() {

        return new ArrayList<>(notes.values());

    }

    @Override
    public boolean deleteById(String id) {

        return notes.remove(id) != null;

    }

    


}
