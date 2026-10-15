package com.gtm.gtmengineering.repository.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gtm.gtmengineering.model.Note;
import com.gtm.gtmengineering.repository.NoteRepository;

public abstract class AbstractJdbcNoteRepository implements NoteRepository{

    protected final JdbcTemplate jdbcTemplate;

    protected AbstractJdbcNoteRepository(
        JdbcTemplate jdbcTemplate
    ) {

        this.jdbcTemplate = jdbcTemplate;

    }

    @Override 
    public List<Note> findAll() {
        String sql = """
                SELECT id, text
                FROM notes
                ORDER BY id
                """;

        return jdbcTemplate.query(
            sql,
            (resultSet, rowNumber) ->
                new Note(
                    resultSet.getString("id"),
                    resultSet.getString("text")
                )); 
    }

    @Override 
    public boolean deleteById(String id) {
        String sql = """
                DELETE FROM notes
                WHERE id = ?
                """;

        int rowDeleted = jdbcTemplate.update(sql, id);

        return rowDeleted > 0;
    }

}
