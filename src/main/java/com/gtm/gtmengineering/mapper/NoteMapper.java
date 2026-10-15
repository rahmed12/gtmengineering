package com.gtm.gtmengineering.mapper;

import org.springframework.stereotype.Component;

import com.gtm.gtmengineering.dto.NoteResponse;
import com.gtm.gtmengineering.model.Note;

@Component 
public class NoteMapper {

    public NoteResponse toResponse(Note note) {
        return new NoteResponse(note.id(), note.text());
    }


}
