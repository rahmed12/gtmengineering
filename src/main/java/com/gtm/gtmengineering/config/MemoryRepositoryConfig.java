package com.gtm.gtmengineering.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gtm.gtmengineering.factory.NoteRepositoryFactory;
import com.gtm.gtmengineering.repository.NoteRepository;

@Configuration 
@Profile("memory")
public class MemoryRepositoryConfig {

    @Bean 
    public NoteRepository noteRepository(
        NoteRepositoryFactory factory
    ) {

        return factory.createMemory();

    }

}
