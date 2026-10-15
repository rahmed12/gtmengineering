package com.gtm.gtmengineering.factory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gtm.gtmengineering.repository.NoteRepository;
import com.gtm.gtmengineering.repository.duckdb.DuckDbNoteRepository;
import com.gtm.gtmengineering.repository.memory.InMemoryNoteRepository;

@Component 
public class NoteRepositoryFactory {

    public NoteRepository createDuckDb(JdbcTemplate jdbcTemplate) {

        return new DuckDbNoteRepository(jdbcTemplate);

    }

    public NoteRepository createMemory() {

        return new InMemoryNoteRepository();

    }

}
