package com.gtm.gtmengineering.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gtm.gtmengineering.exception.NoteNotFoundException;
import com.gtm.gtmengineering.model.Note;
import com.gtm.gtmengineering.repository.NoteRepository;

@Service 
public class NoteService {

    private final NoteRepository noteRepository;


    public NoteService(
        NoteRepository noteRepository
     ) {
        this.noteRepository = noteRepository;
    }


    public Note create(String text) {
        String id = UUID.randomUUID().toString();
        Note note = new Note(id, text.strip());

        return noteRepository.save(note);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public void delete(String id) {
        boolean deleted =  noteRepository.deleteById(id);

        if (!deleted)
            throw new NoteNotFoundException(id);
    }

}
