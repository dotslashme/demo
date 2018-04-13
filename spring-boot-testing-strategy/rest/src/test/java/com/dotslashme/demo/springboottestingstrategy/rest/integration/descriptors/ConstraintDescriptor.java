package com.dotslashme.demo.springboottestingstrategy.rest.integration.descriptors;

import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.util.StringUtils;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.key;

class ConstraintDescriptor {

  private final ConstraintDescriptions constraintDescriptions;

  ConstraintDescriptor(Class<?> c) {
    this.constraintDescriptions = new ConstraintDescriptions(c);
  }

  FieldDescriptor withPath(String path) {
    return fieldWithPath(path)
      .attributes(key("constraints")
        .value(StringUtils
          .collectionToDelimitedString(
            this.constraintDescriptions.descriptionsForProperty(path), ". ")));
  }

  FieldDescriptor withManualConstraint(String path, String constraint) {
    return fieldWithPath(path).attributes(key("constraints").value(constraint));
  }
}
