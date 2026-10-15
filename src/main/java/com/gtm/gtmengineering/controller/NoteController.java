package com.gtm.gtmengineering.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtm.gtmengineering.dto.CreateNoteRequest;
import com.gtm.gtmengineering.dto.NoteResponse;
import com.gtm.gtmengineering.mapper.NoteMapper;
import com.gtm.gtmengineering.model.Note;
import com.gtm.gtmengineering.service.NoteService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;
    private final NoteMapper noteMapper;


    public NoteController(
        NoteService noteService,
        NoteMapper noteMapper
    ) {

        this.noteService = noteService;
        this.noteMapper = noteMapper;

    }

    @PostMapping()
    public ResponseEntity<NoteResponse> create(
        @Valid @RequestBody 
        CreateNoteRequest request
    ) {

        Note note = noteService.create(request.text());

        NoteResponse response = noteMapper.toResponse(note);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);

    }

    @GetMapping()
    public List<NoteResponse> findAll() {

        return noteService
            .findAll()
            .stream()
            .map(noteMapper::toResponse)
            .toList();

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id
    ) {

        noteService.delete(id);

        return ResponseEntity
            .noContent()
            .build();

    }


}
