package com.learnsprint.sprinwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;

import com.learnsprint.sprinwebapp.domain.Author;
import com.learnsprint.sprinwebapp.domain.Book;
import com.learnsprint.sprinwebapp.domain.Publisher;
import com.learnsprint.sprinwebapp.respositories.AuthorRepository;
import com.learnsprint.sprinwebapp.respositories.BookRepository;
import com.learnsprint.sprinwebapp.respositories.PublisherRepository;

public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setCity("FL");

        publisherRepository.save(publisher);
        
        System.out.println("Publisher Count; " + publisherRepository.count());
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJBo = new Book("J2EE Dev without EJB", "68716817");

        rod.getBooks().add(noEJBo);
        noEJBo.getAuthors().add(rod);

        noEJBo.setPublisher(publisher);
        publisher.getBooks().add(noEJBo);

        authorRepository.save(rod);
        bookRepository.save(noEJBo);
        publisherRepository.save(publisher);

        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
