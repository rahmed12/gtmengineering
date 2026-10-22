package com.gtm.gtmengineering.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gtm.gtmengineering.factory.NoteRepositoryFactory;
import com.gtm.gtmengineering.repository.NoteRepository;

@Configuration 
@Profile("duckdb")
public class DuckDbRepositoryConfig {

    @Bean
    public NoteRepository noteRepository(
        NoteRepositoryFactory factory,
        JdbcTemplate jdbcTemplate
    ) {

        return factory.createDuckDb(jdbcTemplate);

    }

}
