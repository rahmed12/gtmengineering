package com.gtm.gtmengineering.exception;

public class NoteNotFoundException extends RuntimeException{


    public NoteNotFoundException(String id) {
        super("Note not found with id " + id);
    }

}
