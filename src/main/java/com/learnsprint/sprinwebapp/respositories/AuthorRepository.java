package com.learnsprint.sprinwebapp.respositories;

import org.springframework.data.repository.CrudRepository;

import com.learnsprint.sprinwebapp.domain.Author;

public interface AuthorRepository  extends CrudRepository<Author, Long>{
    
}
