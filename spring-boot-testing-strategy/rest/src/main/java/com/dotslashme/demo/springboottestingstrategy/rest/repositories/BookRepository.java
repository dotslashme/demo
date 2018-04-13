package com.dotslashme.demo.springboottestingstrategy.rest.repositories;

import com.dotslashme.demo.springboottestingstrategy.rest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
