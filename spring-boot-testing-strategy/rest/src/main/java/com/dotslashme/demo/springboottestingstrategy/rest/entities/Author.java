package com.dotslashme.demo.springboottestingstrategy.rest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, columnDefinition = "VARCHAR(150)")
  private String name;

  @ManyToMany
  @JoinTable(
    joinColumns = {@JoinColumn(name = "author_id")},
    inverseJoinColumns = {@JoinColumn(name = "book_id")})
  private List<Book> books;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Author withName(String name) {
    this.name = name;
    return this;
  }

  public List<Book> getBooks() {
    return books;
  }

  public Author withBooks(List<Book> books) {
    this.books = books;
    return this;
  }
}
