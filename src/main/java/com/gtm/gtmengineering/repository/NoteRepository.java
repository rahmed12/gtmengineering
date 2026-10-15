package com.gtm.gtmengineering.repository;

import java.util.List;

import com.gtm.gtmengineering.model.Note;

public interface NoteRepository {
    Note save(Note note);

    List<Note> findAll();

    boolean deleteById(String id);
}
