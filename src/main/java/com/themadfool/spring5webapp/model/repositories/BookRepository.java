package com.themadfool.spring5webapp.model.repositories;

import com.themadfool.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
