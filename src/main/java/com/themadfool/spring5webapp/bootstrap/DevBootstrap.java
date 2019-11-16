package com.themadfool.spring5webapp.bootstrap;


import com.themadfool.spring5webapp.model.Author;
import com.themadfool.spring5webapp.model.Book;
import com.themadfool.spring5webapp.model.Publisher;
import com.themadfool.spring5webapp.repositories.AuthorRepository;
import com.themadfool.spring5webapp.repositories.BookRepository;
import com.themadfool.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisher = new Publisher("Harper Collins", "123 Some Street", "Some Place", "London", "LO63 5RR");
        publisherRepository.save(publisher);
        Book ddd = new Book("Domain Driven Design", "1234", publisher );
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher2 = new Publisher("Worx", "41 Another Street", "Another Place", "New York", "NY6345");
        publisherRepository.save(publisher);
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2 );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
