package com.gtm.gtmengineering.repository.duckdb;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gtm.gtmengineering.model.Note;
import com.gtm.gtmengineering.repository.jdbc.AbstractJdbcNoteRepository;

public class DuckDbNoteRepository extends AbstractJdbcNoteRepository{

    public DuckDbNoteRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override 
    public Note save(Note note) {

        String sql = """
                INSERT INTO notes (id, text)
                VALUES (?, ?)
                """;

        jdbcTemplate.update(sql, note.id(), note.text());

        return note;
    }

}
