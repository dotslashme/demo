package com.dotslashme.demo.springboottestingstrategy.rest.controllers;

import com.dotslashme.demo.springboottestingstrategy.rest.entities.Author;
import com.dotslashme.demo.springboottestingstrategy.rest.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

  private final AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @GetMapping
  public List<Author> getAllAuthors() {
    return this.authorRepository.findAll();
  }
}
