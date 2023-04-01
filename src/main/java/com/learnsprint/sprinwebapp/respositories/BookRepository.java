package com.learnsprint.sprinwebapp.respositories;

import org.springframework.data.repository.CrudRepository;

import com.learnsprint.sprinwebapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}
