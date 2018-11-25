package com.dotslashme.demo.sbts.entities;

import org.apache.commons.text.RandomStringGenerator;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccessKey {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Type(type = "uuid-char")
  private final UUID safeId = UUID.randomUUID();

  private final String key = new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(1024);

  private final LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("UTC"));

  private LocalDateTime expiresAt = LocalDateTime.now(ZoneId.of("UTC")).plusHours(4L);

  public UUID getSafeId() {
    return safeId;
  }

  public String getKey() {
    return key;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getExpiresAt() {
    return expiresAt;
  }

  public AccessKey setExpiresAt(LocalDateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }
}
