package com.learnsprint.sprinwebapp.Bootstrap;

import org.springframework.boot.CommandLineRunner;

import com.learnsprint.sprinwebapp.domain.Author;
import com.learnsprint.sprinwebapp.domain.Book;
import com.learnsprint.sprinwebapp.respositories.AuthorRepository;
import com.learnsprint.sprinwebapp.respositories.BookRepository;

public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJBo = new Book("J2EE Dev without EJB", "68716817");

        rod.getBooks().add(noEJBo);
        noEJBo.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJBo);
    }
}
