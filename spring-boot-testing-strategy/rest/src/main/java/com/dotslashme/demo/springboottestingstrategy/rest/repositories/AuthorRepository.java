package com.dotslashme.demo.springboottestingstrategy.rest.repositories;

import com.dotslashme.demo.springboottestingstrategy.rest.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
}
