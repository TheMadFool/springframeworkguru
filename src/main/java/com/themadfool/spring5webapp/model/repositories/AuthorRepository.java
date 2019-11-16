package com.themadfool.spring5webapp.model.repositories;

import com.themadfool.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
