package com.dotslashme.demo.rest.singlewriteoperations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dotslashme.demo.rest.singlewriteoperations.entities.ProfileEntity;
import com.dotslashme.demo.rest.singlewriteoperations.repositories.ProfileRepository;

@SpringBootApplication
public class Application {

  @Autowired
  private ProfileRepository repo;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public boolean injectDemoData() {
    if (this.repo.findAll().isEmpty()) {
      ProfileEntity p = new ProfileEntity();
      p.setIdentifier(UUID.fromString("0a3ff82e-6408-4c66-ad45-d869f41fea43"));
      p.setFirstName("Glenn");
      p.setSurname("Demo");
      p.setAddress("Drottninggatan 11, 111 11 Sveaborg");
      p.setPhone("+46 111 66 55 44");
      this.repo.save(p);

      p = new ProfileEntity();
      p.setIdentifier(UUID.fromString("53cb04cf-df1d-4785-bfa3-90bebe94ae02"));
      p.setFirstName("Pelle");
      p.setSurname("Demo");
      p.setAddress("Kungsgatan 1, 111 11 Sveaborg");
      p.setPhone("+46 111 22 33 44");
      this.repo.save(p);
    }
    return true;
  }
}
