package com.dotslashme.demo.springboottestingstrategy.rest.integration.descriptors;

import com.dotslashme.demo.springboottestingstrategy.rest.entities.Author;
import org.springframework.restdocs.payload.FieldDescriptor;

public class AuthorDescriptor {

  public static FieldDescriptor[] responseFields() {
    ConstraintDescriptor authorConstraints = new ConstraintDescriptor(Author.class);

    return new FieldDescriptor[] {
      authorConstraints.withManualConstraint("id", "").description(""),
      authorConstraints.withManualConstraint("name", "").description(""),
      authorConstraints.withManualConstraint("books", "").description("")
    };
  }
}
