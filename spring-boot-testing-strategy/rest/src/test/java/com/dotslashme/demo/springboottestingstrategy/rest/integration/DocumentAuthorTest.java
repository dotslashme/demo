package com.dotslashme.demo.springboottestingstrategy.rest.integration;

import com.dotslashme.demo.springboottestingstrategy.rest.entities.Author;
import com.dotslashme.demo.springboottestingstrategy.rest.integration.descriptors.AuthorDescriptor;
import com.dotslashme.demo.springboottestingstrategy.rest.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentAuthorTest {
  @Rule
  public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private ObjectMapper mapper;

  @Autowired
  private AuthorRepository authorRepository;

  private MockMvc mockMvc;

  private RestDocumentationResultHandler documentationHandler;

  private int authorsInjected;

  @Before
  public void setUp() {
    this.documentationHandler = document("{method-name}",
      preprocessRequest(prettyPrint()),
      preprocessResponse(prettyPrint()));

    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
      .apply(documentationConfiguration(this.restDocumentation))
      .alwaysDo(this.documentationHandler)
      .build();

    injectAuthorTestData();
  }

  private void injectAuthorTestData() {
    List<Author> authors = Arrays.asList(
      new Author().withName("Charles Dickens"),
      new Author().withName("Agatha Christie"),
      new Author().withName("Stephen King"),
      new Author().withName("Edgar Allen Poe")
    );

    this.authorsInjected = authors.size();
    this.authorRepository.saveAll(authors);
  }

  @Test
  public void authorGetExample() throws Exception {
    JsonNode root = this.mapper.readTree(this.mockMvc.perform(get("/author"))
      .andExpect(status().isOk())
      .andDo(this.documentationHandler.document(responseFields()
        .andWithPrefix("[].", AuthorDescriptor.responseFields())))
      .andReturn()
      .getResponse()
      .getContentAsString());

    assertThat(
      root.size())
      .as("Author objects")
      .isEqualTo(this.authorsInjected);
  }
}
